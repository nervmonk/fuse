package com.btsk.fuseintegration.fuse_integration.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail {
    private String message;
    private String code;
    private String error;
    private String latency;
}
