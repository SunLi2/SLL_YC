package com.zsc.imagesbed.controller;

import com.zsc.imagesbed.log.Logger;
import com.zsc.imagesbed.prop.Prop;
import com.zsc.imagesbed.result.Result;
import com.zsc.imagesbed.tool.ToolBox;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
public class JLTController {

    @PostMapping("/api/localimagesbed/wx_upload")
    @ResponseBody
    public Result WX_APP_Upload(@RequestPart("file") MultipartFile file, @RequestParam("userid") String userid) {
        Result result = new Result();

        //是否上传了文件
        if (file.isEmpty()) {
            result.setCode(406);
            return result;
        }
        ZonedDateTime beijingDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String dateTime = beijingDateTime.format(formatter);


        //是否是图片格式
        String filename = file.getOriginalFilename();
        String suffixName = ToolBox.getSuffixName(filename);
        Logger.log("SuffixName: " + suffixName);

        if (ToolBox.isPic(suffixName)) {
            String time = ToolBox.getDirByTime();
            File dest = ToolBox.savePicFile(suffixName, userid,dateTime);
            result.setData(filename);

            filename = dest.getName();
            Logger.log("Saving into " + dest.getAbsolutePath());
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }

            try {
                file.transferTo(dest);
                String url = "/uploadImages/" + userid + "/"  + filename;
                result.setCode(200);
                result.setMsg("成功保存到本地图床，地址是:IP:端口"+url);
                result.setData(url);
//                System.out.println("url="+url);
                int count = Integer.parseInt(Prop.get("imageUploadedCount"));
                ++count;
                Prop.set("imageUploadedCount", String.valueOf(count));
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            result.setCode(500);
            result.setMsg("不是jpg/jpeg/png/svg/gif图片！");
            return result;
        }
        result.setCode(500);
        result.setMsg("未知错误。");
        return result;

    }
}
