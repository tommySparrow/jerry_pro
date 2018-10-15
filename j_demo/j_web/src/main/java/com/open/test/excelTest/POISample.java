package com.open.test.excelTest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/10/15
 * @ Description：简单的POI--生成一个空白的工作簿
 * @ throws
 */
public class POISample {
    public static void main(String[] args){

        HSSFWorkbook workbook = new HSSFWorkbook();//创建一个空白的workbook
        HSSFSheet sheet = workbook.createSheet("test");//创建一个名为test空的sheet

        HSSFRow row = sheet.createRow(2);//创建行号为2的行，excel中的第三行

        HSSFCell cell = row.createCell((short)0);//创建上面行的第一个单元格
        cell.setCellValue("test");//将test写入单元格

        FileOutputStream out = null;
        try{
            out = new FileOutputStream("E:/sample.xls");//在E盘下生成一个空的表格
            workbook.write(out);//调用HSSFWorkbook类的write方法写入到输出流
        }catch(IOException e){
            System.out.println(e.toString());
        }finally{
            try {
                out.close();
            }catch(IOException e){
                System.out.println(e.toString());
            }
        }
    }
}
