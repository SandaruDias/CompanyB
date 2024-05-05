package com.example.CompanyB.CustomerOrderMnaagementModule.Controller;

import com.example.CompanyB.CustomerOrderMnaagementModule.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@SpringBootApplication
@RestController
@RequestMapping("/customer/image")
public class FileController {

	@Autowired
	private FileService service;

	@PatchMapping("/{orderID}/upload")
	public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file, @PathVariable Long orderID)
			throws IOException {
		String uploadImage = service.uploadImage(file, orderID);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}

	@GetMapping("/{orderID}/download")
	public ResponseEntity<?> downloadImage(@PathVariable Long orderID) {

		byte[] imageData = service.downloadImage(orderID);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);

	}

}