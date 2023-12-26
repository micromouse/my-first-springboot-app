package com.studies.myfirstspringbootapp.web;

import com.studies.myfirstspringbootapp.web.demos.web.dao.ServerConfigMapper;
import com.studies.myfirstspringbootapp.web.demos.web.models.ServerConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
     * 成功获得所有服务器配置
     */
    @Test
    public void get_all_ServerConfig_Success() {
        List<ServerConfig> serverConfigs = serverConfigMapper.list();
        Assertions.assertEquals(5, serverConfigs.size());
    }

    /**
     * 按key查找服务器配置成功
     */
    @Test
    public void find_ServerConfig_By_Key_Success() {
        ServerConfig serverConfig = serverConfigMapper.findByKey("eureka.service.url");
        Assertions.assertNotNull(serverConfig);
        Assertions.assertEquals(LocalDateTime.parse("2023-11-21T03:42:02"), serverConfig.getDataChangeCreatedTime());
        Assertions.assertEquals("eureka.service.url", serverConfig.getKey());
    }

    /**
     * 按key集合查找服务器配置成功
     */
    @Test
    public void find_ServerConfig_By_Keys_Success() {
        List<String> keys = Arrays.asList("item.key.length.limit", "item.value.length.limit");
        List<ServerConfig> serverConfigs = serverConfigMapper.findByKeys(keys);
        Assertions.assertEquals(2, serverConfigs.size());
    }

    /**
     * 查询符合条件的服务器配置
     */
    @Test
    public void query_ServerConfig_Success() {
        LocalDate createdTimeStart = LocalDate.parse("2023-01-01");
        LocalDate createdTimeEnd = LocalDate.parse("2023-12-01");
        List<ServerConfig> serverConfigs = serverConfigMapper.query("item", createdTimeStart, createdTimeEnd);
        Assertions.assertEquals(2, (long) serverConfigs.size());
    }

    /**
     * 按mybatis xml配置映射方式查询符合条件的服务器配置
     */
    @Test
    public void query_ServerConfig_By_Xml_Success() {
        LocalDate createdTimeStart = LocalDate.parse("2023-01-01");
        LocalDate createdTimeEnd = LocalDate.parse("2023-12-01");
        List<ServerConfig> serverConfigs = serverConfigMapper.queryByXml("item", createdTimeStart, createdTimeEnd);
        Assertions.assertEquals(2, (long) serverConfigs.size());
    }

    /**
     * 按mybatis xml配置映射方式查询符合条件的服务器配置
     */
    @Test
    public void query_serverConfig_By_Xml_Optional_Condition_Success() {
        List<ServerConfig> serverConfigs = serverConfigMapper.queryByXml("", null, null);
        Assertions.assertEquals(5, (long) serverConfigs.size());
    }

    /**
     * 按id删除服务器配置成功
     */
    @Test
    public void delete_ServerConfig_By_Id_Success() {
        Integer count = serverConfigMapper.DeleteById(12);
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
