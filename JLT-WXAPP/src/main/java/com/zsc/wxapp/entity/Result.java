package com.zsc.wxapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private String code;  //返回的状态码
    private String msg;   // 返回的信息提示，什么错误，什么成功
    //    private Object data;   //返回的数据
    private T data; // 返回的数据

    public static <T> Result<T> ok() {
//        return new Result("200","success",null);
        return new Result<T>("200", "success", null);
    }

    public static <T> Result<T> ok(String msg) {
//        return new Result("200",msg,null);
        return new Result<T>("200", msg, null);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<T>("200", "success", data);
    }

    public static <T> Result<T> ok(String msg, T data) {
        return new Result<T>("200", msg, data);
    }

    public static <T> Result<T> fail(String msg, T data) {
        return new Result("404", msg, data);
    }

    public static <T> Result<T> fail(String msg) {
        return new Result("404", msg, null);
    }

//    public static Result ok(String msg){
//        return new Result("200",msg,null);
//    }
//    public static Result ok(Object data){
//        return new Result("200","success",data);
//    }
//    public static Result ok(String msg,Object data){
//        return new Result("200",msg,data);
//    }
//    public static Result fail(String msg,String data){
//        return new Result("404",msg,data);
//    }
//    public static Result fail(String msg){
//        return new Result("404",msg,null);
//    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.code = "200";
        result.msg = "成功";
        result.data = object;
        return result;
    }

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = "200";
        result.msg = "成功";
        return result;
    }
}