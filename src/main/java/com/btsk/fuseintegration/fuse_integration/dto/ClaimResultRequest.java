package com.btsk.fuseintegration.fuse_integration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClaimResultRequest {
    private String policyNo;
    private String thirdClaimNo;
    private String claimNo;
    private int claimStatus;
    private String reasonMessage;
    private int claimCloseTime;
    private int claimSubmitAmount;
    private int claimPaidAmount;
}
