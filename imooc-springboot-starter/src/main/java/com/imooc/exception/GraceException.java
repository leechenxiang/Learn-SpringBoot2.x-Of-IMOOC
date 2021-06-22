package com.imooc.exception;

/**
 * 优雅的处理异常，进行调用
 */
public class GraceException {

    public static void display(String errMsg) {
        throw new MyCustomException(errMsg);
    }

}
