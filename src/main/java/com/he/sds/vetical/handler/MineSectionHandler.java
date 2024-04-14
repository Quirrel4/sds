package com.he.sds.vetical.handler;

import com.he.sds.vetical.entity.MaterialByte;
import com.he.sds.vetical.entity.MineSection;
import com.he.sds.vetical.entity.Section;
import com.he.sds.vetical.reponse.SectionVO;
import com.he.sds.vetical.service.MaterialByteService;
import com.he.sds.vetical.service.impl.MineSectionServiceImpl;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class MineSectionHandler extends SectionHandler<List<String[]>> {

    @Qualifier("mineSectionServiceImpl")
    MineSectionServiceImpl sectionService;

    @Autowired
    MaterialByteService materialByteService;

    public static String separator="---";
    public static String property="property";
    public static String Material="Material";

    Color[] colors=new Color[5];

    {
        colors[0]=Color.GREEN;
        colors[1]=Color.blue;
        colors[2]=Color.cyan;
        colors[3]=Color.lightGray;
        colors[4]=Color.ORANGE;
    }

    @Override
    SectionVO handle(FileData<List<String[]>> fileData,String sectionId) {
        int colorCount=0;
        List<String[]> list = fileData.getData();
        int i=0;
        DrawApplication drawApplication = new DrawApplication();
        drawApplication.init(sectionId+".pdf");
        while(i<list.size()&&list.get(i)[0].equals(separator)){
                i++;
                if (i<list.size()&&list.get(i)[0].equals("x")){
                    i++;
                    Point prePoint=null;
                    Point curPoint=new Point(Double.parseDouble(list.get(i)[0]),Double.parseDouble(list.get(i)[1]));
                    while(i+1<list.size()&&!list.get(i+1)[0].equals(separator)){
                        i++;
                        prePoint=curPoint;
                        curPoint=new Point(Double.parseDouble(list.get(i)[0]),Double.parseDouble(list.get(i)[1]));
                        drawApplication.drawLine(prePoint,curPoint);
                    }
                    i++;
                }
        }
        while(i<list.size()){
            if (i<list.size()&&list.get(i)[0].equals(property)){
                i++;
                if (i<list.size()&&list.get(i)[0].equals("x")){
                    ArrayList<Point2D.Double> list1 = new ArrayList<>();
                    while(i+1<list.size()&&!list.get(i+1)[0].equals(Material)){
                        i++;
                        list1.add(new Point2D.Double(Double.parseDouble(list.get(i)[0]),Double.parseDouble(list.get(i)[1])));
                    }
                    i++;
                    if (i<list.size()&&list.get(i)[0].equals(Material)){
                        i++;
                        String materialName=list.get(i)[0];
                        //MaterialByte materialByte = materialByteService.getMaterialByteByName(materialName);
                        //这边后续还要处理，没有的材料需要插入
                    }
                    drawApplication.fillColor(list1,colors[colorCount]);
                    colorCount++;
                    i+=2;
                }
            }
        }
        drawApplication.shutDown();
        return new SectionVO(sectionId+".pdf",null, "",sectionId+".pdf");
    }

    @Override
    public Section transferSectionVO2PO(SectionVO sectionVO, String sectionId) {
        return new MineSection(sectionId,sectionVO.getSectionName(),sectionVO.getSectionSourceId(),sectionVO.getDescription());
    }

    public class Point{
        double x;
        double y;

        public Point() {
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public class DrawApplication {
        Document document;
        Graphics2D g2d;

        String output;

        public void init(String outputRoute){
            output=outputRoute;
            document=new Document(new Rectangle(1000,1000));
            try{
                // 创建一个PdfWriter对象，并指定输出文件路径
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputRoute));
                // 打开文档
                document.open();

                // 获取PdfContentByte对象，用于在文档中绘制图形
                PdfContentByte cb = writer.getDirectContent();

                // 创建一个Graphics2D对象，以便在内存中绘制图形
                g2d = cb.createGraphicsShapes(document.getPageSize().getWidth(), document.getPageSize().getHeight());
                g2d.translate(0, 1000);
                // 反转y轴方向，使y轴向上延伸
                g2d.scale(1, -1);
                // 设置绘图颜色和线宽
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new java.awt.BasicStroke(1f));
            } catch (DocumentException | FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }


        public void drawLine(Point pre,Point cur){
            Point pre1 = new Point(pre.x * 10, pre.y * 10);
            Point cur1 = new Point(cur.x * 10, cur.y * 10);
            g2d.fillOval((int)pre1.x,(int) pre1.y, 1, 1);
            g2d.draw(new Line2D.Double(pre1.x,pre1.y,cur1.x,cur1.y));
        }



        public ArrayList<Point2D.Double> getScaledPoints(ArrayList<Point2D.Double> points){
            ArrayList<Point2D.Double> list = new ArrayList<>();
            for (Point2D.Double point : points) {
                Point2D.Double point1 = new Point2D.Double();
                point1.x=point.x*10;
                point1.y=point.y*10;
                list.add(point1);
            }
            return list;
        }

        public void fillColor(ArrayList<Point2D.Double> points,Color color){
            ArrayList<Point2D.Double> scaledPoints = getScaledPoints(points);
            // 绘制并填充多边形
            int[] xPoints = new int[scaledPoints.size()];
            int[] yPoints = new int[scaledPoints.size()];
            for (int i = 0; i < scaledPoints.size(); i++) {
                Point2D.Double point = scaledPoints.get(i);
                xPoints[i] = (int) point.getX();
                yPoints[i] = (int) point.getY();
            }
            g2d.setColor(color);
            g2d.fillPolygon(xPoints, yPoints, points.size());
            g2d.setColor(Color.black);
        }

        public void shutDown(){
            g2d.dispose();
            document.close();
            System.out.println("PDF已生成，路径为"+output);
        }
    }

}
