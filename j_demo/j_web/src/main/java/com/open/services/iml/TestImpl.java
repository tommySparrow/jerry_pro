package com.open.services.iml;

import com.open.javabean.Stu;
import com.open.mappers.TestMapper;
import com.open.services.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/10
 * @ Description：
 * @ throws
 */
@Service
public class TestImpl implements TestService {

    public static final Logger logger = LoggerFactory.getLogger(TestService.class);
    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Stu> getAll() {

        logger.info(" info成功了");
        logger.debug(" debug成功了");
        logger.error(" erro成功了");
        List<Stu> stuList = testMapper.getAll();
        return stuList;

    }
}
