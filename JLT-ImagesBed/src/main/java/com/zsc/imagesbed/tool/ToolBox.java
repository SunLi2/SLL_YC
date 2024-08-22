package com.zsc.imagesbed.tool;

import org.springframework.util.ClassUtils;

import java.io.File;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * <h3>picuang</h3>
 * <p>工具箱</p>
 *
 * @author : https://github.com/AdlerED
 * @date : 2019-11-06 11:09
 **/
public class ToolBox {
    private static final Set<String> suffixSet;

    static {
        suffixSet = new HashSet<>();
        suffixSet.add(".jpeg");
        suffixSet.add(".jpg");
        suffixSet.add(".png");
        suffixSet.add(".gif");
        suffixSet.add(".svg");
        suffixSet.add(".bmp");
        suffixSet.add(".ico");
        suffixSet.add(".tiff");
    }
    
    public static String getSuffixName(String filename) {
        String suffixName = filename.substring(filename.lastIndexOf("."));
        suffixName = suffixName.toLowerCase();
        return suffixName;
    }
    public static String getParentDirectory(String path) {
        File file = new File(path);
        // 获取父目录的路径
        String parentPath = file.getParent();
        return parentPath;
    }

    public static boolean isPic(String suffixName) {
        return suffixName.contains(suffixName);
    }

    public static String getPicStoreDir() {
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        return ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/uploadImages/";
//        return dir + "/JLT-ImagesBed/uploadImages/";

    }

    public static File generatePicFile(String suffixName, String time, String IP) {
        String path = getPicStoreDir() + IP + "/" + time;
        String fileName = UUID.randomUUID() + suffixName;
        return new File(path + fileName);
    }
    public static File savePicFile(String suffixName, String userid, String detetime) {
        String path = getPicStoreDir()+ "/" + userid+"/";
        String fileName = detetime+"_"+UUID.randomUUID() + suffixName;
        return new File(path + fileName);
    }
    public static String getDirByTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/HH/mm/");
        return simpleDateFormat.format(date);
    }

    public static String getINIDir() {
        return new File("config.ini").getAbsolutePath();
    }
}
