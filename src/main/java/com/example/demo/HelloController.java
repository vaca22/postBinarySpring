package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }

    byte[] fuck=new byte[100];

    @ResponseBody
    @PostMapping("/post")
    public String hello2(InputStream dataStream) throws IOException {
        int s=0;
        int a=0;
        while (true){
            a=dataStream.read(fuck);
            if(a>0){
                s+=a;
            }else{
                break;
            }
        }
        System.out.println(s);

        return "Hello W22orld!";
    }
}