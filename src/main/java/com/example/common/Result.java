package com.example.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: suragi
 * @Date: 2024/12/23 20:22
 * @Description:
 */
@Data
public class Result<T> implements Serializable {
    private int code;           // 响应状态码
    private String message;     // 响应消息
    private T data;             // 数据内容

    // 无参构造函数
    public Result() {}

    // 全参构造函数
    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 静态方法：成功响应
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "Success", data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(200, message, data);
    }

    // 静态方法：错误响应
    public static <T> Result<T> error(int code, String message) {
        return new Result<>(code, message, null);
    }

    public static <T> Result<T> error(String message) {
        return new Result<>(500, message, null);
    }

    // Getters and Setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

