package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }

    byte[] receiveTemp =new byte[1000];

    @ResponseBody
    @PostMapping("/post")
    public String hello2(InputStream dataStream,@RequestHeader("filename") String name) throws IOException {
        int s=0;
        int a=0;
        String name2="files/"+name;
        File myObj = new File(name2);
        myObj.getParentFile().mkdirs();
        if(myObj.exists()){
            myObj.delete();
        }

        FileOutputStream out=new FileOutputStream(name2);


        while (true){
            a=dataStream.read(receiveTemp);
            if(a>0){
                if(a==1000){
                    out.write(receiveTemp);
                }else{
                    out.write(receiveTemp,0,a);
                }
                s+=a;
            }else{
                break;
            }
        }
        out.close();
        System.out.println(s);

        return "Hello W22orld!";
    }
}