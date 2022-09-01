package com.cdut.controller;

import com.cdut.epidemicsyscontrolcommon.utils.AjaxResult;
import com.cdut.epidemicsyscontrolframework.security.SecurityUtil;
import com.cdut.epidemicsyscontrolsystem.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    @Value("${file.location}")
    private String BASE_DIR;

    @Autowired
    private SysUserService sysUserService;


    /**
     * 上传头像接口
     * @param avatar
     * @param request
     * @return
     */
    @PostMapping("/uploadAvatar")
    public AjaxResult uploadAvatar(@RequestParam("avatar") MultipartFile avatar, HttpServletRequest request) {
        String fileName = avatar.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));

        File parentDir = new File(BASE_DIR);
        if(!parentDir.exists())
            parentDir.mkdirs();
        String username = SecurityUtil.getUsername();
        String uuid = UUID.randomUUID().toString();
        // 文件储存包位置
        String finalPath = BASE_DIR +File.separator + uuid + suffix;
        try {
            avatar.transferTo(new File(finalPath));
            sysUserService.saveAvatarUrl(username, uuid + suffix);
            return AjaxResult.success("上传成功", uuid + suffix);
        } catch (IOException e) {
            return AjaxResult.error("上传失败", e.getMessage());
        }
    }

    /**
     * 获取当前用户头像接口
     * @param response
     * @throws IOException
     */
    @GetMapping("/getAvatar")
    public void getAvatar(HttpServletResponse response) throws IOException {
        String username = SecurityUtil.getUsername();
        String avatar = sysUserService.getAvatarByUsername(username);
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream inputStream = new BufferedInputStream(
                new FileInputStream(
                        new File(BASE_DIR+File.separator+avatar)
                )
        );
        byte[]buffer = new byte[1024];
        int len = 0;
        while((len = inputStream.read(buffer))!= -1){
            out.write(buffer,0, len);
        }
        out.flush();
        out.close();
    }
}
