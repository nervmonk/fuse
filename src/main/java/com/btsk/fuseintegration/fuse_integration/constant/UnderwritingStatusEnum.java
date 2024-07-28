package com.btsk.fuseintegration.fuse_integration.constant;

public enum UnderwritingStatusEnum {
    PENDING(102, "Insurance Underwriting Pending"),
    REJECTED(107, "Quote Rejected"),
    INACTIVE(103, "Policy Inactive"),
    ACTIVE(104, "Policy Active"),
    EXPIRED(105, "Policy Expired"),
    CANCEL(106, "Cancellation Status Initialization"),
    ACTIVE_UNVERIFIED(120, "Policy Active But Unverified");

    private final int code;
    private final String description;

    UnderwritingStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static UnderwritingStatusEnum ofCode(int code) {
        for (UnderwritingStatusEnum underwritingStatusEnum : UnderwritingStatusEnum.values()) {
            if (underwritingStatusEnum.code == code) {
                return underwritingStatusEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
