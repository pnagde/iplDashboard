package com.example.lazydevs.ipl.Controller;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.lazydevs.ipl.Service.FileStorageService;
import com.example.lazydevs.ipl.modal.UploadFileResponse;

@RestController
public class UploadFileController {

	private static final Logger logger = LoggerFactory.getLogger(UploadFileController.class);
	
	@Autowired
	private final FileStorageService fileStorageService = null;
	
	@PostMapping(value = "/uploadFiles")
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {

		String fileName=fileStorageService.storeFile(file);
		String fileDownloadUri=ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(fileName).toUriString();
		
		System.out.println("called");
		System.out.println(fileName+"/"+fileDownloadUri);
		return new UploadFileResponse(fileName,fileDownloadUri,file.getContentType(),file.getSize());
	}
	
	@PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
		return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }
	
	@GetMapping(value = "/downloadFile/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@PathVariable String filename,HttpServletRequest request){
		
		//load file as resource
		Resource file=fileStorageService.loadFileAsResource(filename);
		
		System.out.println(file);
		
		String contentType = null; // Try to determine file's content type
		
		try {
			contentType=request.getServletContext().getMimeType(file.getFile().getAbsolutePath());
			
		}catch(IOException ex) {
			 logger.info("Could not determine file type.");
		}
		//default
		 if(contentType == null) {
	            contentType = "application/octet-stream";
	        }
		 
		 
		 return ResponseEntity.ok()
	                .contentType(org.springframework.http.MediaType.parseMediaType(contentType))
	                .header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
	                .body(file);
	}
	
//	@GetMapping("/allfiles")
//	public String handleFileUpload(@RequestParam("file") MultipartFile file,
//			RedirectAttributes redirectAttributes) {
//
//		try {
//			fileStorageService.storeFile(file);
//		} catch (FileUploadException e) {
//			e.printStackTrace();
//		}
//		redirectAttributes.addFlashAttribute("message",
//				"You successfully uploaded " + file.getOriginalFilename() + "!");
//
//		return "redirect:/allfiles";
//	}


}
