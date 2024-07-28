package com.btsk.fuseintegration.fuse_integration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UnderwritingResultResponse {
    private ResponseData data;
    private String code;
    private String latency;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseData {
        private Boolean declineFlag;
        private String thirdOrderNo;
    }
}
