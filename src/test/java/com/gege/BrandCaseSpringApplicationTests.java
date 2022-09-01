package com.gege;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;


@SpringBootTest
class BrandCaseSpringApplicationTests {




    @Autowired
    Environment environment;


    @Test
    void testGenerator(){
        System.out.println(environment);
//        System.out.println(dataSource);
//        System.out.println(autoGenerator);
    }

}
