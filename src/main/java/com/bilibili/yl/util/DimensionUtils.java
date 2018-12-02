package com.bilibili.yl.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bilibili_jiaozhu
 * <p>
 * 二维码生成工具类
 */
public class DimensionUtils {
    private String url;
    private Integer width;
    private Integer height;

    /**
     * @param url    二维码内容，不局限于url也可以是其他，中文可能会乱码
     * @param width  二维码宽度
     * @param height 二维码高度
     * @throws IOException IO流异常
     */
    public DimensionUtils(String url, Integer width, Integer height) throws IOException {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public DimensionUtils() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * 生成二维码并发送至客户端
     *
     * @param response 域对象
     * @throws IOException IO流异常
     */
    public void sendDimension(HttpServletResponse response) throws IOException {
        if (url != null && !"".equals(url)) {
            ServletOutputStream stream;
            stream = response.getOutputStream();
            QRCodeWriter writer = new QRCodeWriter();
            try {
                BitMatrix matrix = writer.encode(url, BarcodeFormat.QR_CODE, width, height);
                MatrixToImageWriter.writeToStream(matrix, "png", stream);
            } catch (WriterException e) {
                e.printStackTrace();
            } finally {
                if (stream != null) {
                    stream.flush();
                    stream.close();
                }
            }
        }
    }
}
