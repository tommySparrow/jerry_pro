package com.open.test.uniteEntity;

import com.open.mappers.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/28
 * @ Description：
 * @ throws
 */
@RestController
public class TestUnitController {

    @Autowired
    private RecordMapper recordMapper;

    @RequestMapping("/testUnit")
    private void getUnit(){

        List<EntityResponse> unite = recordMapper.getUnite("18");
        System.out.println(unite.toString());
    }

}
