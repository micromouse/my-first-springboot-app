package com.studies.myfirstspringbootapp.web.demos.web.controllers;

import com.studies.myfirstspringbootapp.web.demos.web.dao.ServerConfigMapper;
import com.studies.myfirstspringbootapp.web.demos.web.models.Result;
import com.studies.myfirstspringbootapp.web.demos.web.models.ServerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Mybatis控制器
 */
@RestController
@RequestMapping("/mybatis")
public class MybatisController {
    private final ServerConfigMapper serverConfigMapper;
    private final Logger logger = LoggerFactory.getLogger(MybatisController.class);

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
     * 限定Get请求也可以用[@GetMapping("/list")]
     *
     * @return ：服务器配置信息集合
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result<List<ServerConfig>> list() {
        logger.info("正在获取所有服务器配置信息");
        List<ServerConfig> serverConfigs = serverConfigMapper.list();
        serverConfigs.forEach(System.out::println);
        return Result.success(serverConfigs);
    }

    /**
     * 按key查找服务器配置信息
     *
     * @param key ：key
     * @return ：服务器配置信息
     */
    @GetMapping("/findByKey")
    public Result<ServerConfig> findByKey(String key) {
        ServerConfig serverConfig = serverConfigMapper.findByKey(key);
        return Result.success(serverConfig);
    }

    /**
     * 按id删除服务器配置
     *
     * @param id ：id
     * @return ：结果
     */
    @DeleteMapping(value = "/deleteById/{id}")
    public Result<ServerConfig> deleteById(@PathVariable Integer id) {
        Integer count = serverConfigMapper.DeleteById(id);
        if (count == 0) {
            return Result.error("0行服务器配置被删除");
        } else {
            return Result.success();
        }
    }
}
