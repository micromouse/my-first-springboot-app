package com.studies.myfirstspringbootapp.web.demos.web.models;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * 结果
 *
 * @param <TData> : 数据类型
 */
@Data
public class Result<TData> {
    private int code;
    private String message;
    private TData data;

    /**
     * 初始化结果
     */
    public Result() {

    }

    /**
     * 初始化结果
     *
     * @param code    : 代码
     * @param message : 消息
     * @param data    : 数据
     */
    public Result(int code, String message, TData data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 获得成功结果
     *
     * @return : 成功结果
     */
    public static <TData> Result<TData> success() {
        return success(null);
    }

    /**
     * 获得成功结果
     *
     * @param data    : 数据
     * @param <TData> : 结果数据类型
     * @return : 成功结果
     */
    public static <TData> Result<TData> success(TData data) {
        return new Result<>(HttpStatus.OK.value(), "success", data);
    }

    /**
     * 获得错误结果
     *
     * @param message : 错误消息
     * @param <TData> : 结果数据类型
     * @return : 错误结果
     */
    public static <TData> Result<TData> error(String message) {
        return error(HttpStatus.BAD_REQUEST, message);
    }

    /**
     * 获得错误结果
     *
     * @param httpStatus : Http错误码
     * @param message : 错误消息
     * @param <TData> : 结果数据类型
     * @return : 错误结果
     */
    public static <TData> Result<TData> error(HttpStatus httpStatus, String message) {
        return new Result<>(httpStatus.value(), message, null);
    }
}
