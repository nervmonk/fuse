package com.btsk.fuseintegration.fuse_integration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TilakaCeritificateStatus {
    private String user_identifier;
    private Boolean success;
    private String request_id;
    private String status;
}
