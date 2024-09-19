package com.btsk.fuseintegration.fuse_integration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TilakaKycResult {
    public String registerId;
    public Boolean success;
    public String message;
    public ResponseData data;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseData {
        private String status;
        private Boolean nik;
        private Boolean name;
        private String photo_selfie;
        private String fr_score;
        private String fr_score_percentage;
        private Boolean liveness_result;
        private String liveness_fail_message;
        private Boolean summary_verification_result;
        private String tilaka_name;
        private String reason_code;
        private String date_of_birth;
        private String manual_registration_status;
    }

}
