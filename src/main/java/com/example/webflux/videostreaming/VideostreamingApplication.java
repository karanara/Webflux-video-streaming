package com.example.webflux.videostreaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

import org.springframework.core.io.Resource;

@SpringBootApplication
@RestController
public class VideostreamingApplication {
	
	@Autowired
	private StreamingClass service;

	public static void main(String[] args) {
		SpringApplication.run(VideostreamingApplication.class, args);
	}
	
	@GetMapping(value="video/{title}",produces="video/mp4")
	public Mono<Resource> getVideos(@PathVariable String title){
		return service.getVideo(title);
		
	}

}
