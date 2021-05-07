package com.example.lazydevs.ipl.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Files")
@Entity
public class UploadFileResponse {


	@Id
	private String fileName;

	@Column(name = "fileDownloadUri")
	private String fileDownloadUri;

	@Column(name = "fileType")
	private String fileType;
	
	@Column(name = "size")
	private long size;

	public UploadFileResponse(String fileName, String fileDownloadUri, String fileType, long size) {
	    this.fileName = fileName;
	    this.fileDownloadUri = fileDownloadUri;
	    this.fileType = fileType;
	    this.size = size;
	}

	public UploadFileResponse() {
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileDownloadUri() {
		return fileDownloadUri;
	}
	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}

}
