package com.he.sds;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ColorTest {
    public static void main(String[] args) {
        // 创建一个Document对象
        Document document = new Document(PageSize.A4);

        try {
            // 创建一个PdfWriter对象，并指定输出文件路径
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
            // 打开文档
            document.open();

            // 获取PdfContentByte对象，用于在文档中绘制图形
            Graphics2D g2d = writer.getDirectContent().createGraphicsShapes(PageSize.A4.getWidth(), PageSize.A4.getHeight());

            // 设置绘图颜色
            g2d.setColor(Color.GREEN);

            // 定义四个点的坐标
            ArrayList<Point2D.Double> points = new ArrayList<>();
            points.add(new Point2D.Double(37.52, 26.06));
            points.add(new Point2D.Double(30.17, 35.01));
            points.add(new Point2D.Double(0.00, 34.99));
            points.add(new Point2D.Double(0.00, 26.80));

            // 绘制四个点
            for (int i = 0; i < points.size(); i++) {
                Point2D.Double point = points.get(i);
                g2d.fillOval((int) point.getX(), (int) point.getY(), 1, 1); // 绘制圆形点
            }

            // 绘制并填充多边形
            int[] xPoints = new int[points.size()];
            int[] yPoints = new int[points.size()];
            for (int i = 0; i < points.size(); i++) {
                Point2D.Double point = points.get(i);
                xPoints[i] = (int) point.getX();
                yPoints[i] = (int) point.getY();
            }
            g2d.fillPolygon(xPoints, yPoints, points.size());

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
