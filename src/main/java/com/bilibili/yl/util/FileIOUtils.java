package com.bilibili.yl.util;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class FileIOUtils {
    /**
     * Base64位码图片上传
     *
     * @param url      上传路径
     * @param fileName 上传图片名称，不需要后缀
     * @param base64   64位码
     * @return null为失败, 成功返回文件名
     */
    public String base64UpLoad(String base64, String fileName, String url) {
        try {
            String dataPix;
            String data;
            //判断数据正确性
            if (base64 == null || "".equals(base64)) throw new Exception("上传失败,上传图片为空");
            else {
                String[] d = base64.split("base64,");
                if (d.length == 2) {
                    dataPix = d[0];
                    data = d[1];
                } else throw new Exception("上传数据不合法,数据不合法");
            }
            //对数据进行解析,获取文件名和流数据
            String suffix;
            //data:image/jpeg;base64,base64编码的jpeg图片数据
            if ("data:image/jpeg;".equalsIgnoreCase(dataPix)) suffix = ".jpg";
            else //data:image/x-icon;base64,base64编码的icon图片数据
                if ("data:image/x-icon;".equalsIgnoreCase(dataPix)) suffix = ".ico";
                else //data:image/gif;base64,base64编码的gif图片数据
                    if ("data:image/gif;".equalsIgnoreCase(dataPix)) suffix = ".gif";
                    else //data:image/png;base64,base64编码的png图片数据
                        if ("data:image/png;".equalsIgnoreCase(dataPix)) suffix = ".png";
                        else throw new Exception("上传图片格式不合法");
            String tempFileName = fileName + suffix;  //生成文件名
            //因为BASE64Decoder的jar问题，此处使用本框架提供的工具包
            byte[] bs = Base64Utils.decodeFromString(data);
            FileUtils.writeByteArrayToFile(new File(url, tempFileName), bs);
            return tempFileName;
        } catch (Exception e) {
            return null;
        }
    }
}
