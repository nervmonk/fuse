package com.btsk.fuseintegration.fuse_integration.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btsk.fuseintegration.fuse_integration.annotations.ApiHeader;
import com.btsk.fuseintegration.fuse_integration.constant.HeaderConstant;
import com.btsk.fuseintegration.fuse_integration.constant.ResponseConstant;
import com.btsk.fuseintegration.fuse_integration.dto.ClaimResultRequest;
import com.btsk.fuseintegration.fuse_integration.dto.ClaimResultResponse;
import com.btsk.fuseintegration.fuse_integration.dto.UnderWritingResultRequest;
import com.btsk.fuseintegration.fuse_integration.dto.UnderwritingResultResponse;
import com.btsk.fuseintegration.fuse_integration.exception.BadRequestException;
import com.btsk.fuseintegration.fuse_integration.security.AuthUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/fuse")
public class FuseApi {

    @PostMapping("/underwriting-result")
    @ApiHeader
    public UnderwritingResultResponse getUnderwritingResult(
            @RequestBody UnderWritingResultRequest request, HttpServletRequest httpServletRequest) {
        String partnerCode = httpServletRequest.getHeader(HeaderConstant.PARTNER_CODE);
        String timestamp = httpServletRequest.getHeader(HeaderConstant.TIMESTAMP);
        String orderNo = request.getOrderNo();
        String expectedText = partnerCode + "\n" + timestamp + "\n" + orderNo;
        if (!AuthUtil.decrypt(expectedText, httpServletRequest.getHeader(HeaderConstant.SIGNATURE))) {
            throw new BadRequestException("Authentication Failed", "403000", "Signature validation failed", "0.87 ms");
        }
        var resultData = UnderwritingResultResponse.ResponseData.builder()
                .declineFlag(false)
                .thirdOrderNo(orderNo)
                .build();
        return UnderwritingResultResponse.builder()
                .data(resultData)
                .code(ResponseConstant.SUCCESS)
                .latency("1.13 ms")
                .build();
    }

    @PostMapping("/claim-result")
    @ApiHeader
    public ClaimResultResponse getClaimResult(
            @RequestBody ClaimResultRequest request, HttpServletRequest httpServletRequest) {
        String partnerCode = httpServletRequest.getHeader(HeaderConstant.PARTNER_CODE);
        String timestamp = httpServletRequest.getHeader(HeaderConstant.TIMESTAMP);
        String orderNo = request.getThirdClaimNo();
        String expectedText = partnerCode + "\n" + timestamp + "\n" + orderNo;
        if (!AuthUtil.decrypt(expectedText, httpServletRequest.getHeader(HeaderConstant.SIGNATURE))) {
            throw new BadRequestException("Authentication Failed", "403000", "Signature validation failed", "0.87 ms");
        }
        var responseData = ClaimResultResponse.ResponseData.builder()
                .policyNo(request.getPolicyNo())
                .claimNo(request.getClaimNo())
                .applyFlag(false)
                .build();
        return ClaimResultResponse.builder()
                .data(responseData)
                .code("200")
                .latency("2.43 ms")
                .build();
    }

}
