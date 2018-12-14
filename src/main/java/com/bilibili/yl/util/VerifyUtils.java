package com.bilibili.yl.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class VerifyUtils {
    /**
     * 图片宽，默认150
     */
    private int width = 150;
    /**
     * 图片高，默认35
     */
    private int height = 35;
    /**
     * 随机对象
     */
    private Random r = new Random();
    /**
     * 验证码字体
     */
    private String[] fontNames = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};
    /**
     * 验证码随机域
     */
    private String codes = "0123456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
    /**
     * 背景色
     */
    private Color bgColor = new Color(255, 255, 255);
    /**
     * 验证码上的文本
     */
    private String text;

    /**
     * 生成随机的颜色
     */
    private Color randomColor() {
        int red = r.nextInt(150);
        int green = r.nextInt(150);
        int blue = r.nextInt(150);
        return new Color(red, green, blue);
    }

    /**
     * 生成随机的字体
     */
    private Font randomFont() {
        int index = r.nextInt(fontNames.length);
        String fontName = fontNames[index];//生成随机的字体名称
        int style = r.nextInt(4);//生成随机的样式, 0(无样式), 1(粗体), 2(斜体), 3(粗体+斜体)
        int size = r.nextInt(5) + 32; //生成随机字号, 32 ~ 36
        return new Font(fontName, style, size);
    }

    /**
     * 画干扰线
     *
     * @param image 图片
     */
    private void drawLine(BufferedImage image) {
        int num = 3;//一共画3条
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        for (int i = 0; i < num; i++) {//生成两个点的坐标，即4个值
            int x1 = r.nextInt(width);
            int y1 = r.nextInt(height);
            int x2 = r.nextInt(width);
            int y2 = r.nextInt(height);
            g2.setStroke(new BasicStroke(1.5F));
            g2.setColor(Color.BLUE); //干扰线是蓝色
            g2.drawLine(x1, y1, x2, y2);//画线
        }
    }

    /**
     * 随机生成一个字符
     */
    private char randomChar() {
        int index = r.nextInt(codes.length());
        return codes.charAt(index);
    }

    /**
     * 创建BufferedImage
     */
    private BufferedImage createImage() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(this.bgColor);
        g2.fillRect(0, 0, width, height);
        return image;
    }

    /**
     * 调用这个方法得到验证码
     *
     * @return BufferedImage类型图片文件
     */
    public BufferedImage getImage() {
        BufferedImage image = createImage(); //创建图片缓冲区
        Graphics2D g2 = (Graphics2D) image.getGraphics(); //得到绘制环境
        StringBuilder sb = new StringBuilder(); //用来装载生成的验证码文本
        // 向图片中画4个字符
        for (int i = 0; i < 4; i++) { //循环四次，每次生成一个字符
            String s = randomChar() + ""; //随机生成一个字母
            sb.append(s); //把字母添加到sb中
            float x = i * 1.0F * width / 4; //设置当前字符的x轴坐标
            g2.setFont(randomFont()); //设置随机字体
            g2.setColor(randomColor()); //设置随机颜色
            g2.drawString(s, x, height - 5); //画图
        }
        this.text = sb.toString(); //把生成的字符串赋给了this.text
        drawLine(image); //添加干扰线
        return image;
    }

    /**
     * 返回验证码图片上的文本
     *
     * @return 图片上的文本，用于验证
     */
    public String getText() {
        return text;
    }

    /**
     * 保存图片到指定的输出流
     *
     * @param image 图片
     * @param out   输出流
     * @throws IOException 输出流异常
     */
    public void output(BufferedImage image, OutputStream out)
            throws IOException {
        ImageIO.write(image, "JPEG", out);
    }

    /**
     * 自定义的随机字符串
     *
     * @param codes 字符串（用于随机）
     */
    public void setCodes(String codes) {
        this.codes = codes;
    }

    /**
     * 自定义图片的大小
     *
     * @param width  图片的宽
     * @param height 图片的高
     */
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
