package com.open.utils;

import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/21
 * @ Description：导出表格工具类
 * sheetName 表格sheet名和标题名
 * dataList 从数据表中获取的数据
 * headers 表格表头
 * exportExcelName 表名
 */
public class ExcelUtil {

    public  static String  exportExcel(String sheetName, List<?> dataList,
                                       List<String> headers,String exportExcelName) {

        String tmpPath = null;

        // 声明一个工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet(sheetName);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth(15);

        XSSFDataFormat df = workbook.createDataFormat();
        // 生成表格中非标题栏的样式
        XSSFCellStyle style = workbook.createCellStyle();
        setDataStyle(style, workbook);

        // 设置表格标题栏的样式
        XSSFCellStyle titleStyle = workbook.createCellStyle();
        setTitleStyle(titleStyle, workbook);

        // 产生表格标题行
        XSSFRow titleRow = sheet.createRow(0);
        sheet.addMergedRegion(new CellRangeAddress(0,1,0,headers.size()-1));
        XSSFCell titleCell = titleRow.createCell(0);
        titleCell.setCellStyle(titleStyle);
        titleCell.setCellValue(exportExcelName);

        //设置字段行
        XSSFRow row = sheet.createRow(2);
        for (short i = 0; i < headers.size(); i++) {
            XSSFCell cell = row.createCell(i);
            XSSFRichTextString text = new XSSFRichTextString(headers.get(i));
            cell.setCellStyle(style);
            cell.setCellValue(text);
        }

        // 遍历集合数据，产生数据行
        if (dataList != null || dataList.size()>0) {
            for (int j=0;j<dataList.size();j++){
                row = sheet.createRow(j+3);
                String jsonStr = JsonUtils.toJson(dataList.get(j));
                JSONObject data = JSONObject.fromObject(jsonStr);
                Iterator<String> keys = data.keys();
                int i = 0;
                while (keys.hasNext()) {
                    String key = keys.next();
                    Object val = data.get(key);
                    XSSFCell cell = row.createCell(i);
                    if (val instanceof Double) {
                        XSSFCellStyle styleNumber = workbook.createCellStyle();
                        setDataStyle(styleNumber, workbook);
                        styleNumber.setDataFormat(df.getFormat("#,##0.00"));
                        cell.setCellStyle(styleNumber);
                        cell.setCellValue((Double) val);
                        i++;
                    } else {
                        cell.setCellStyle(style);
                        String textValue = (val==null || val.equals("null")) ?"":val.toString();
                        XSSFRichTextString text = new XSSFRichTextString(textValue);
                        cell.setCellValue(text);
                        i++;
                    }
                }
            }
        }

        OutputStream out = null;

        //定义下载到哪个位置--开始
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        char c = request.getRealPath("/").charAt(0);
        String contentPath = c+":";
        //定义下载到哪个位置--结束

        String fileDisk = "excels/";
        File file = new File(contentPath + fileDisk);
        if (!file.exists()) {
            file.mkdirs();
        }
        String downPath  = fileDisk + exportExcelName + ".xlsx";
        try {
            tmpPath = contentPath + downPath;
            out = new FileOutputStream(tmpPath);
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  downPath;
    }

    /*
     * 标题栏格式
     * */
    private static void setTitleStyle(XSSFCellStyle titleStyle, XSSFWorkbook workbook){
        titleStyle.setFillForegroundColor(HSSFColor.WHITE.index);
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleStyle.setBorderBottom(BorderStyle.THIN);
        titleStyle.setBorderLeft(BorderStyle.THIN);
        titleStyle.setBorderRight(BorderStyle.THIN);
        titleStyle.setBorderTop(BorderStyle.THIN);
        titleStyle.setAlignment(HorizontalAlignment.CENTER);//居中显示
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 设置标题栏字体
        XSSFFont titleFont = workbook.createFont();
        titleFont.setColor(HSSFColor.BLACK.index);
        titleFont.setFontHeightInPoints((short) 16);
        titleFont.setBold(true);
        // 把字体应用到当前的样式
        titleStyle.setFont(titleFont);
    }

    /*
     * 非标题栏格式
     * */
    private static void setDataStyle(XSSFCellStyle style, XSSFWorkbook workbook){
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.WHITE.index);//背景色
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        // 生成表格中非标题栏的字体
        XSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
//        font.setBold(true);//加黑
        // 把字体应用到当前的样式
        style.setFont(font);
    }
}
