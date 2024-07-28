package com.btsk.fuseintegration.fuse_integration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnderWritingResultRequest {
    private String orderNo;
    private String thirdOrderNo;
    private String policyNo;
    private Long premium;
    private String ePolicyLink; // Not mandatory
    private Long underwritingStatus;
    private String underwritingReason; // Not mandatory
}
