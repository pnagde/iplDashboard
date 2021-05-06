package com.example.lazydevs.ipl.properties;



@org.springframework.boot.context.properties.ConfigurationProperties(prefix = "file")
public class FileUploadProperties {
	private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
