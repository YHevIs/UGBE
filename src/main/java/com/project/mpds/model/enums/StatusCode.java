package com.project.mpds.model.enums;

/**
 * 通用业务码
 */
public enum StatusCode implements EnumProperties {

    /**
     * 请求成功2000X
     * 请求失败4000X
     * 服务器异常5000X
     */
    SUCCESS(20000, "操作成功"),
    PARAM_ERROR(40000, "参数异常"),
    NOT_FOUND(40004, "资源不存在"),
    FAILURE(50000, "系统异常");

    private final Integer code;
    private final String desc;

    StatusCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
