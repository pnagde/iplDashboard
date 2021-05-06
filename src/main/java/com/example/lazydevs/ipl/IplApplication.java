package com.example.lazydevs.ipl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.lazydevs.ipl.properties.FileUploadProperties;

@SpringBootApplication
@CrossOrigin
@EnableConfigurationProperties({
    FileUploadProperties.class
})
public class IplApplication {

	public static void main(String[] args) {
		SpringApplication.run(IplApplication.class, args);
	}
}
