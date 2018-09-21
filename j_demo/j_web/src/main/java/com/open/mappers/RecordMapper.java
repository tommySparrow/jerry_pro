package com.open.mappers;

import com.github.abel533.mapper.Mapper;
import com.open.javabean.Record;

import java.util.List;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/21
 * @ Description：
 * @ throws
 */
public interface RecordMapper extends Mapper<Record> {
   List<Record> getAllRecord();
}
