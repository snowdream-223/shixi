package com.hphs.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    private int code;
    private String message; //如果code 不是0的情况 message就是具体的内容
    private Object data; // 返回的数据

    // 返回正确数据
    public static ResponseDTO success(Object data){
        ResponseDTO dto=new ResponseDTO();
        dto.setCode(0);
        dto.setData(data);
        return dto;
    }
    //返回错误数据
    public static  ResponseDTO error(int code,String message){
        ResponseDTO dto=new ResponseDTO();
        dto.setCode(code);
        dto.setMessage(message);
        return dto;
    }

}
