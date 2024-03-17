package com.boot.restbookapi.controllers;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.boot.restbookapi.helper.FileUploadHepler;

@RestController
public class FileUploadController {
    
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request must contain a file");
        }
        
        if (!file.getContentType().equals("image/jpeg")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Only JPEG files are allowed");
        }
        
        boolean success = new FileUploadHepler().uploadFile(file);
		if (success) {
		    return ResponseEntity.ok("File uploaded successfully!");
		} else {
		    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
		}
    }
}
