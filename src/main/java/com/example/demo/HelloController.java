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



/*


    发送请求: method：POST
    url：https://xiaoputest.viatomtech.com.cn/napi/v1/app/version/update
    请求头：Content-Type: application/json; charset=UTF-8
    appid: test
    token:
    nonce: 38298890
    signature: 677A516F49355EE7E9567C48FE799DEA

    请求参数: {"channelType":"0","clientType":"0","deviceSn":"unknown","version":"1.0.4"}
2022-07-12 08:57:59.128 2571-2619/com.viatom.littlePu D/autical: 收到响应: code:200
    请求url：https://xiaoputest.viatomtech.com.cn/napi/v1/app/version/update
    请求body：{"channelType":"0","clientType":"0","deviceSn":"unknown","version":"1.0.4"}
    Response: {"code":1,"msg":"请求成功","data":{"version":"1.1.2.44","url":"http://vaca.vip/LittlePu-AnGui-exam-debug-1.1.2.44.apk","force":"0","versionCode":301,"vdesc":"emc log"}}



*/


    @ResponseBody
    @PostMapping("/napi/v1/app/version/update")
    public String hello3(InputStream dataStream) throws IOException {
        System.out.println("fucc");
        int s=0;
        int a=0;
        String name2="files/"+"gaga.txt";
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

        return "{\"code\":1,\"msg\":\"请求成功\",\"data\":{\"version\":\"1.1.2.44\",\"url\":\"http://vaca.vip/LittlePu-AnGui-exam-debug-1.1.2.44.apk\",\"force\":\"0\",\"versionCode\":301,\"vdesc\":\"emc log\"}}";
    }



}