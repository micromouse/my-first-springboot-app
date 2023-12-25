package com.studies.myfirstspringbootapp.web;

import com.studies.myfirstspringbootapp.web.demos.web.dao.ServerConfigMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试
 */
@SpringBootTest
public class WebApplicationTests {
    private final ServerConfigMapper serverConfigMapper;

    @Autowired
    public WebApplicationTests(ServerConfigMapper serverConfigMapper) {
        this.serverConfigMapper = serverConfigMapper;
    }


    /**
     * 按id删除服务器配置成功
     */
    @Test
    public void delete_ServerConfig_By_Id_Success() {
        Integer count = serverConfigMapper.DeleteById(10);
        Assertions.assertEquals(1, count, "0行服务器配置被删除");
    }
}
