package com.certificate.Taekwondo.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;

import com.certificate.Taekwondo.model.Certificate;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

// 通过对证书的图片模板操作，生成证书图片
public class ImageUtil {
    private static String templatePath = "d:\\certmodel.jpg";
    private static String fontName = "微软雅黑";
    private static int fontStyle = Font.PLAIN;
    private static int fontSize = 20;

//    public static byte[] incorrectImg() {
//        byte[] filebytes = null;
//        try {
//            File file = new File(incorrectTemplatePath);
//            filebytes = Files.readAllBytes(file.toPath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return filebytes;
//    }

    // 根据图片模板，填充对应证书信息, 返回字节流
    public static byte[] pressText(Certificate certificate) {
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

        graphics.setFont(new Font("黑体", fontStyle, fontSize));
        graphics.drawString(certificate.getGrade(), 383, 245);   // 级位

        graphics.setFont(new Font(fontName, fontStyle, 15));
        graphics.drawString(certificate.getNumber(), 250, 300);   // 编号
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        graphics.drawString(dateFormat.format(certificate.getDate()), 541, 373);   // 发证日期

        graphics.setFont(new Font(fontName, fontStyle, 17));
        graphics.drawString(certificate.getName(), 544, 300);   // 姓名
        graphics.drawString(certificate.getExaminer(), 277, 373);   // 考官

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
//    public static void main(String[] args) {
//        ByteArrayOutputStream byteArrayOutputStream = null;
//        try {
//            byteArrayOutputStream = new ByteArrayOutputStream();
//            byte[] bytes = ImageUtil.pressText("IT小奋斗", 10, 30);
//            byte[] bytes = ImageUtil.incorrectImg();
//            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
//            BufferedImage bi1 = ImageIO.read(bais);
//            File file2 = new File("d:/result.png");
//            ImageIO.write(bi1, "png", file2);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}
