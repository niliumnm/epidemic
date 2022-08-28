package com.cdut.controller;

import com.cdut.epidemic_common.utils.AjaxResult;
import com.google.code.kaptcha.Producer;
//import com.zlt.utils.RedisUtil;
import com.cdut.epidemic_common.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class ValidateController {
    @Autowired
    private Producer captchaProducer;

    @Autowired
    private RedisUtil redisUtil;



    @RequestMapping("/user/kaptcha")
    public AjaxResult getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //生成验证码
        String capText = captchaProducer.createText();

        //把生成的验证码放入redis缓存:针对每个用户的验证码都会放入redis
        //每个用户的验证码跟validateId绑定
        String userValidateId = UUID.randomUUID().toString();

        //分布式缓存：所有客户端的信息都是放入redis
        //所有客户端生成的验证码都是放入redis
        System.out.println(capText);
        redisUtil.set(userValidateId, capText);
        // 用响应头 把validateId发送给用户
        response.setHeader("validateKey", userValidateId);

        //向客户端输出
        byte[] captcha = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        BufferedImage bi = captchaProducer.createImage(capText);
        ImageIO.write(bi,"jpg",out);

        captcha = out.toByteArray();
        Map<String,Object> map = new HashMap<>();
        Base64.Encoder encoder = Base64.getEncoder();
        map.put("captcha","data:image/jpg;base64,"+encoder.encodeToString(captcha));

        return AjaxResult.success("验证码生成成功", map);

    }
}
