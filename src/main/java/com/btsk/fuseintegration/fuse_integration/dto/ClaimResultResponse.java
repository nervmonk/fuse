package com.btsk.fuseintegration.fuse_integration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClaimResultResponse {
    private ResponseData data;
    private String code;
    private String latency;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseData {
        private String policyNo;
        private String claimNo;
        private Boolean applyFlag;
    }
}
