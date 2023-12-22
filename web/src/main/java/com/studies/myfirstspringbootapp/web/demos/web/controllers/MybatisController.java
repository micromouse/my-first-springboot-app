package com.studies.myfirstspringbootapp.web.demos.web.controllers;

import com.studies.myfirstspringbootapp.web.demos.web.dao.ServerConfigMapper;
import com.studies.myfirstspringbootapp.web.demos.web.models.Result;
import com.studies.myfirstspringbootapp.web.demos.web.models.ServerConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Mybatis控制器
 */
@RestController
@RequestMapping("/mybatis")
public class MybatisController {
    private final ServerConfigMapper serverConfigMapper;

    /**
     * 初始化Mybatis控制器
     *
     * @param serverConfigMapper ：ServerConfig映射器
     */
    public MybatisController(ServerConfigMapper serverConfigMapper) {
        this.serverConfigMapper = serverConfigMapper;
    }

    /**
     * 获得服务器配置信息集合
     *
     * @return ：服务器配置信息集合
     */
    @RequestMapping("/list")
    public Result<List<ServerConfig>> list() {
        List<ServerConfig> serverConfigs = serverConfigMapper.list();
        return Result.success(serverConfigs);
    }

    /**
     * 按key查找服务器配置信息
     * @param key ：key
     * @return ：服务器配置信息
     */
    @RequestMapping("/findByKey")
    public Result<ServerConfig> findByKey(String key) {
        ServerConfig serverConfig = serverConfigMapper.findByKey(key);
        return Result.success(serverConfig);
    }
}
