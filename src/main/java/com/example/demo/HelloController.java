package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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

    byte[] fuck=new byte[100];

    @ResponseBody
    @PostMapping("/post")
    public String hello2(InputStream dataStream) throws IOException {
        int s=0;
        int a=0;
        File myObj = new File("filename.txt");
        if(myObj.exists()){
            myObj.delete();
        }

        FileOutputStream out=new FileOutputStream("filename.txt");


        while (true){
            a=dataStream.read(fuck);
            if(a>0){
                if(a==100){
                    out.write(fuck);
                }else{
                    out.write(fuck,0,a);
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