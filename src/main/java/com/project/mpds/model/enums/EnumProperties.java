package com.project.mpds.model.enums;

/**
 * 所有的枚举类都应该实现的接口
 **/
public interface EnumProperties {

    /**
     * 返回Code
     */
    Integer getCode();

    /**
     * 返回描述
     */
    String getDesc();
}
