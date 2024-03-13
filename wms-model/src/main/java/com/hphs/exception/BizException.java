package com.hphs.exception;

public class BizException extends RuntimeException{
    private int code;

    public BizException(int code,String msg){
        super(msg);
        this.code=code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
