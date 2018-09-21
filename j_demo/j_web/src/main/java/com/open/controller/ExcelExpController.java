package com.open.controller;

import com.open.constant.Constant;
import com.open.exception.MyException;
import com.open.javabean.Record;
import com.open.services.RecordService;
import com.open.utils.ExcelUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/21
 * @ Description：导出表格数据
 * @ throws
 */
@RestController
public class ExcelExpController {

    @Autowired
    private RecordService recordService;

    @RequestMapping("/expExcel")
    public String expExcel(@Param("sheetName") String sheetName, @Param("exportExcelName")String exportExcelName) throws MyException {


        List<Record> recordList = recordService.getAllRecord();

        List<String> headers = Arrays.asList(Constant.PROFIT_REPORT_HEAD);
        try {
            //导出表格
            ExcelUtil.exportExcel(sheetName, recordList, headers, exportExcelName);

            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            char c = request.getRealPath("/").charAt(0);

            return "请到"+c+"盘查看下载的文件!";
        } catch (Exception e){

            throw new MyException("下载出现错误!");
        }

    }
}
