package com.boot.bookingrestaurantapi.controllers;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.boot.bookingrestaurantapi.jsons.JsonToCsvRest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/json-to-csv/v1")
public class JsonToCsvController {
	
	private static final String UPLOAD_DIR = "/Users/chris/Documents/projects/java/springboot/Code Booking Restaurant/booking-restaurant-api/src/main/resources/data/input";
	private static final String OUTPUT_DIR = "/Users/chris/Documents/projects/java/springboot/Code Booking Restaurant/booking-restaurant-api/src/main/resources/data/output";

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, Object>> uploadContent(@RequestParam("file") MultipartFile file) throws JsonParseException, JsonMappingException, IOException {
    
    	Map<String, Object> response = new HashMap<>();
    	
    	if (file.isEmpty()) {
    		response.put("success", false);
    		response.put("message", "Archivo vacio");
            return ResponseEntity.badRequest().body(response);
        }
    	
    	File jsonFile = new File(UPLOAD_DIR + File.separator + file.getOriginalFilename());
    	file.transferTo(jsonFile);
    	
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
    		JsonToCsvRest[] personasArray = objectMapper.readValue(jsonFile, JsonToCsvRest[].class);

        	List<JsonToCsvRest> personas = Arrays.asList(personasArray);
        	
        	LocalDate todayLocale = LocalDate.now();
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        	String today = todayLocale.format(formatter);
        	String fileNameWithoutExtension = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf("."));
        	String fileName = fileNameWithoutExtension + "_" + today + ".csv";
        	
        	File csvFile = new File(OUTPUT_DIR + File.separator + fileName);
            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
                String[] encabezado = {"Nombre", "Edad", "Email"};
                writer.writeNext(encabezado);
                
                for (JsonToCsvRest item : personas) {
                    String[] datos = {item.getName(), item.getPosition(), item.getEmail()};
                    writer.writeNext(datos);
                }
            }
            
            String downloadUrl = "http://localhost:8080/json-to-csv/v1/download?fileName=" + fileName;
            
            response.put("success", true);
            response.put("file_url", downloadUrl);
        	return ResponseEntity.ok(response);
        			
    	} catch (IOException e) {
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    	}
    	
    }
    
    @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<InputStreamResource> downloadFile(@RequestParam("fileName") String fileName) throws IOException {
        File file = new File(OUTPUT_DIR + File.separator + fileName);
        if (!file.exists()) {
            return ResponseEntity.badRequest().body(null);
        }

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
    
}
