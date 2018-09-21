package com.open.services.iml;

import com.open.javabean.Record;
import com.open.mappers.RecordMapper;
import com.open.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/21
 * @ Description：
 * @ throws
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public List<Record> getAllRecord() {

        List<Record> recordList = recordMapper.getAllRecord();

        return recordList;
    }
}
