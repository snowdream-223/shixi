package com.hphs.advice;

import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.json.JSONUtil;
import com.hphs.dto.ResponseDTO;
import com.hphs.exception.BizException;
import com.hphs.info.PageInfo;
import com.hphs.threadutil.LocalPageInfoUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;

@RestControllerAdvice  //针对controller的增强类
public class MyResponseAdvice implements ResponseBodyAdvice<Object> {
    //支持的方法 默认是不支持的 参数是说明你要对哪些放法支持 哪些方法不支持
    @Override
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> aClass) {
       //开启执行
        return true;
    }
    @ExceptionHandler
    public Object processException(Exception ex){
        ex.printStackTrace();
        if(ex instanceof BizException){
            BizException bizException= (BizException) ex;
            return ResponseDTO.error(bizException.getCode(),ex.getMessage());
        }

        return ResponseDTO.error(88,ex.getMessage());

    }


    @Override
    public Object beforeBodyWrite(Object bady,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        if(bady instanceof ResponseDTO){
            return bady;
        }
        ResponseDTO dto=ResponseDTO.success(bady);
        //如果线程上有分页信息
        PageInfo pageInfo= LocalPageInfoUtil.get();
        if(pageInfo !=null){
            HashMap<Object,Object> map=new HashMap<>();
            //添加的总条数{total,31}
            map.put("total",pageInfo.getTotal());
            //把集合的名字更改成items 后续直接拿items
            map.put("items",bady);
            dto=ResponseDTO.success(map);
            //删除标签数据 防止内存溢出
            LocalPageInfoUtil.remove();
        }

        //证明 我返回就是String类型
        if(aClass == StringHttpMessageConverter.class){
            // 改正string JSON串的格式
            return JSONUtil.toJsonStr(dto);
        }
        return dto;
    }
}
