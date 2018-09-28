package com.open.mappers;

import com.github.abel533.mapper.Mapper;
import com.open.javabean.Record;
import com.open.test.uniteEntity.EntityResponse;

import java.util.List;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/21
 * @ Description：
 * @ throws
 */
public interface RecordMapper extends Mapper<Record> {
   List<Record> getAllRecord();

   //测试联合查询
   List<EntityResponse> getUnite(String age);
}
