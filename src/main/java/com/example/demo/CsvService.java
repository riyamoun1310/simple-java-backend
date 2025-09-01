package com.example.demo;

import org.apache.commons.csv.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

@Service
public class CsvService {

    public Map<String, Integer> analyzeCsv(MultipartFile file) {
        int rowCount = 0;
        int columnCount = 0;

        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
            columnCount = parser.getHeaderMap().size();
            for (CSVRecord record : parser) {
                rowCount++;
            }
        } catch (IOException e) {
            // Handle error
        }

        Map<String, Integer> result = new HashMap<>();
        result.put("rows", rowCount);
        result.put("columns", columnCount);
        return result;
    }
}
