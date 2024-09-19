package com.btsk.fuseintegration.fuse_integration.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btsk.fuseintegration.fuse_integration.dto.TilakaCeritificateStatus;
import com.btsk.fuseintegration.fuse_integration.dto.TilakaKycResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/tilaka")
@Slf4j
public class TilakaApi {

    private static final String certStatusFilename = "certificate_status.json";
    private static final String kycResultFilename = "kyc_result.json";

    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    @PostMapping("/certificate-status")
    public void getCertificateStatus(@RequestBody TilakaCeritificateStatus ceritificateStatus){
        try {
            writeToJsonFile(ceritificateStatus, certStatusFilename);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }   
    }

    @PostMapping("/get-kyc-result")
    public void getKycResult(@RequestBody TilakaKycResult tilakaKycResult){
        try {
            writeToJsonFile(tilakaKycResult, kycResultFilename);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }   
    }

        private void writeToJsonFile(Object object, String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            boolean isSuccess = file.createNewFile();
            if(!isSuccess){
                throw new RuntimeException();
            }
        }

        if (file.length() > 0) {
            try (FileWriter fileWriter = new FileWriter(file, true)) {
                fileWriter.write(",\n");
            }
        }

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            objectMapper.writeValue(fileWriter, object);
        }
    }
}
