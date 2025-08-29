package com.example.fileupload;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins="http://localhost:5173")
public class FileController {
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Map<String, Object> upload(@RequestPart("file") MultipartFile file) {
		return Map.of(
				"originalName", file.getOriginalFilename(),
				"size", file.getSize(),
				"contentType", file.getContentType()
				);
	}
}
