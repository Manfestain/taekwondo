package com.certificate.Taekwondo.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

// 通过对证书的图片模板操作，生成证书图片
public class ImageUtil {
    private static String templatePath = "d:\\psb.jpg";
    private static String fontName = "微软雅黑";
    private static int fontStyle = Font.PLAIN;
    private static int fontSize = 30;


    // 根据图片模板，填充对应证书信息, 返回字节流
    public static byte[] pressText(String pressText, int x, int y) {
        Color color = new Color(89, 89, 89);
        File imgFile = new File(templatePath);   // 加载图片模板
        Image sources = null;
        try {
            sources = ImageIO.read(imgFile);
        } catch (IOException ioe) {
            ioe.getMessage();
        }
        int width = sources.getWidth(null);
        int height = sources.getHeight(null);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);   // 虚拟图片
        Graphics2D graphics = image.createGraphics();

        graphics.drawImage(image, 0, 0, width, height, null);   // 文字去锯齿
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
                RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        graphics.drawImage(sources, 0, 0, width, height, null);   // 画目标图片

        graphics.setColor(color);   // 画文字水印
        graphics.setFont(new Font(fontName, fontStyle, fontSize));
        graphics.drawString(pressText, x, y);
        graphics.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", baos);
        } catch (IOException _ioe) {
            _ioe.getMessage();
        }
        return baos.toByteArray();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = ImageUtil.pressText("IT小奋斗", 10, 30);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            BufferedImage bi1 = ImageIO.read(bais);
            File file2 = new File("d:/result.jpg");
            ImageIO.write(bi1, "jpg", file2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
