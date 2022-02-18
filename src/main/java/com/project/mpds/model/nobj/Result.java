package com.project.mpds.model.nobj;

import com.project.mpds.model.enums.StatusCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一返回模型
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "通用返回响应结果对象", value = "result")
public class Result<T> implements Serializable {

    @ApiModelProperty(value = "响应状态码, 2000X表示成功, 4000X表示错误, 5000X表示服务器错误", required = true)
    private Integer statusCode;
    @ApiModelProperty(value = "响应信息", required = true)
    private String message;
    @ApiModelProperty(value = "响应结果体", required = true)
    private T data;

    public boolean isSuccess() {
        return statusCode.toString().startsWith("2000");
    }

    /**
     * 请求成功需要返回数据
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> ok(T data) {
        return new Result<>(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getDesc(), data);
    }

    /**
     * 请求成功不需要返回数据
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> ok() {
        return ok(null);
    }

    /**
     * 错误返回状态码，错误信息以及逻辑数据
     *
     * @param statusCode
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(StatusCode statusCode, T data) {
        return new Result<>(statusCode.getCode(), statusCode.getDesc(), data);
    }

    /**
     * 错误返回状态码，错误信息
     *
     * @param statusCode
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(StatusCode statusCode) {
        return error(statusCode, null);
    }

    /**
     * 错误返回状态码，错误信息
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(T data) {
        return error(StatusCode.FAILURE, data);
    }

    /**
     * 错误返回状态码，错误信息
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> error() {
        return error(StatusCode.FAILURE, null);
    }

    /**
     * 自定义错误信息
     *
     * @param statusCode
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(Integer statusCode, String message, T data) {
        return new Result<>(statusCode, message, data);
    }

    /**
     * 自定义错误信息
     *
     * @param statusCode
     * @param message
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(Integer statusCode, String message) {
        return new Result<>(statusCode, message, null);
    }

    /**
     * 自定义错误码
     *
     * @param statusCode
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(Integer statusCode) {
        return error(statusCode, StatusCode.FAILURE.getDesc(), null);
    }

    /**
     * 自定义错误信息
     *
     * @param message
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(String message) {
        return error(StatusCode.FAILURE.getCode(), message, null);
    }
}
