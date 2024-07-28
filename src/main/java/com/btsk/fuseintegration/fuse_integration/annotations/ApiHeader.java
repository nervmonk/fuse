package com.btsk.fuseintegration.fuse_integration.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.btsk.fuseintegration.fuse_integration.constant.HeaderConstant;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Operation(parameters = {
        @Parameter(in = ParameterIn.HEADER, description = "Partner Unique Code", name = HeaderConstant.PARTNER_CODE, content = @Content(schema = @Schema(type = "string", defaultValue = "")), required = true),
        @Parameter(in = ParameterIn.HEADER, description = "Timestamp", name = HeaderConstant.TIMESTAMP, content = @Content(schema = @Schema(type = "string", defaultValue = "")), required = true),
        @Parameter(in = ParameterIn.HEADER, description = "Signature", name = HeaderConstant.SIGNATURE, content = @Content(schema = @Schema(type = "string", defaultValue = "")), required = true),

})
public @interface ApiHeader {

}
