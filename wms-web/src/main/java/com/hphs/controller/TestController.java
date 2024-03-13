package com.hphs.controller;

import com.hphs.exception.BizException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin
@RequestMapping("/api")
public class TestController {

    @GetMapping("/test")
    public String test(){
       // int a=1/0;
//        if(1==1){
//            throw  new BizException(88,"你报错了，拜拜了您呐");
//        }
        return "abcd  来到了我的世界";
    }


}
