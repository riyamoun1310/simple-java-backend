package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
public class DataController {

    @Autowired
    private CsvService csvService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile file) {
        Map<String, Object> response = new HashMap<>();
        response.put("fileName", file.getOriginalFilename());
        response.put("fileSize", file.getSize());

        Map<String, Integer> analysis = csvService.analyzeCsv(file);
        response.putAll(analysis);

        response.put("status", "File processed.");
        return response;
    }
}
