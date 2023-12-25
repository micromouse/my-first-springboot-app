package com.studies.myfirstspringbootapp.web;

import com.studies.myfirstspringbootapp.web.demos.web.dao.ServerConfigMapper;
import com.studies.myfirstspringbootapp.web.demos.web.models.ServerConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * 服务器配置映射器测试
 */
@SpringBootTest
public class ServerConfigMapperTest {
    private final ServerConfigMapper serverConfigMapper;

    /**
     * 初始化服务器配置映射器测试
     *
     * @param serverConfigMapper : 服务器配置映射器
     */
    @Autowired
    public ServerConfigMapperTest(ServerConfigMapper serverConfigMapper) {
        this.serverConfigMapper = serverConfigMapper;
    }

    /**
     * 按key查找服务器配置成功
     */
    @Test
    public void find_ServerConfig_By_Key_Success() {
        ServerConfig serverConfig = serverConfigMapper.findByKey("eureka.service.url");
        Assertions.assertNotNull(serverConfig);
        Assertions.assertEquals("eureka.service.url", serverConfig.getKey());
    }

    /**
     * 按id删除服务器配置成功
     */
    @Test
    public void delete_ServerConfig_By_Id_Success() {
        Integer count = serverConfigMapper.DeleteById(11);
        Assertions.assertEquals(1, count, "0行服务器配置被删除");
    }

    /**
     * 添加服务器配置成功
     */
    @Test
    public void insert_ServerConfig_Success() {
        ServerConfig serverConfig = new ServerConfig();
        serverConfig.setKey("my key 1");
        serverConfig.setCluster("cluster 1");
        serverConfig.setValue("my value 1");
        serverConfig.setComment("my comment 1");
        serverConfig.setDeleted(false);
        serverConfig.setDeletedAt(0);
        serverConfig.setDataChangeCreatedBy("dxq 1");
        serverConfig.setDataChangeCreatedTime(LocalDateTime.now());
        serverConfig.setDataChangeLastModifiedBy("dxq 1");
        serverConfig.setDataChangeLastTime(LocalDateTime.now());

        serverConfigMapper.Insert(serverConfig);
        Assertions.assertNotNull(serverConfig.getId());
    }
}
