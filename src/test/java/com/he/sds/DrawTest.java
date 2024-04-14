package com.he.sds;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.awt.geom.Line2D;
import java.io.FileOutputStream;

public class DrawTest {
    public static void main(String[] args) {
        // 创建一个Document对象
        Document document = new Document(new Rectangle(100,100));

        try {
            // 创建一个PdfWriter对象，并指定输出文件路径
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
            // 打开文档
            document.open();

            // 获取PdfContentByte对象，用于在文档中绘制图形
            PdfContentByte cb = writer.getDirectContent();

            // 创建一个Graphics2D对象，以便在内存中绘制图形
            Graphics2D g2d = cb.createGraphicsShapes(document.getPageSize().getWidth(), document.getPageSize().getHeight());

            g2d.translate(0, 100);
            // 反转y轴方向，使y轴向上延伸
            g2d.scale(1, -1);
            // 设置绘图颜色和线宽
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new java.awt.BasicStroke(0.5f));

            System.out.println("top:"+document.getPageSize().getTop());//右上角y轴坐标
            System.out.println("bottom:"+document.getPageSize().getBottom());//左下角y轴坐标
            System.out.println("left:"+document.getPageSize().getLeft());//左下角x轴坐标
            System.out.println("right:"+document.getPageSize().getRight());//右上角x轴坐标
            // 绘制一些点和线
            g2d.draw(new Line2D.Double(30.17, 35.01, 37.52, 26.06)); // 绘制一条线
            g2d.draw(new Line2D.Double(0, 0, 50, 50)); // 绘制一条线
            // 结束绘图
            g2d.dispose();

            // 关闭文档
            document.close();

            System.out.println("PDF文件已生成为 output.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
