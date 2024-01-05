package com.studies.myfirstspringbootapp.web.demos.web.controllers;

import com.studies.myfirstspringbootapp.web.demos.web.models.PaginationModel;
import com.studies.myfirstspringbootapp.web.demos.web.models.Result;
import com.studies.myfirstspringbootapp.web.demos.web.models.ServerConfig;
import com.studies.myfirstspringbootapp.web.demos.web.service.ServerConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Mybatis控制器
 */
@RestController
@RequestMapping("/mybatis/serverConfig")
public class MybatisController {
    private final ServerConfigService serverConfigService;
    private final Logger logger = LoggerFactory.getLogger(MybatisController.class);

    /**
     * 初始化Mybatis控制器
     *
     * @param serverConfigService ：服务器配置服务
     */
    public MybatisController(ServerConfigService serverConfigService) {
        this.serverConfigService = serverConfigService;
    }

    /**
     * 获得服务器配置信息集合
     * 限定Get请求也可以用[@GetMapping("/getServerConfigs")]
     *
     * @return ：服务器配置信息集合
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result<List<ServerConfig>> list() {
        logger.info("正在获取所有服务器配置信息");
        List<ServerConfig> serverConfigs = serverConfigService.getServerConfigs();
        serverConfigs.forEach(System.out::println);
        return Result.success(serverConfigs);
    }

    /**
     * 按key查找服务器配置信息
     *
     * @param key ：key
     * @return ：服务器配置信息
     */
    @GetMapping("/{key}")
    public Result<ServerConfig> findByKey(@PathVariable String key) {
        ServerConfig serverConfig = serverConfigService.findByKey(key);
        return Result.success(serverConfig);
    }

    /**
     * 分页查询服务器配置
     *
     * @param pageIndex        ：页索引
     * @param pageSize         ：页记录数
     * @param key              ：配置key
     * @param createdTimeStart ：数据变动建立时间开始
     * @param createdTimeEnd   ：数据变动建立时间结束
     * @return ：分页服务器配置信息结果
     */
    @GetMapping("/pagination")
    public Result<PaginationModel<ServerConfig>> queryPagination(Integer pageIndex, Integer pageSize, String key, LocalDate createdTimeStart, LocalDate createdTimeEnd) {
        PaginationModel<ServerConfig> paginationModel = serverConfigService.queryPagination(pageIndex, pageSize, key, createdTimeStart, createdTimeEnd);
        return Result.success(paginationModel);
    }

    /**
     * 按id删除服务器配置
     * rollbackFor = Exception.class : 所有异常都回滚
     * propagation = Propagation.REQUIRED ： 没有事务将开启新的事物，存在事务则加入
     *
     * @param id ：id
     * @return ：结果
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    @DeleteMapping(value = "/{id}")
    public Result<ServerConfig> deleteById(@PathVariable Integer id) {
        Integer count = serverConfigService.deleteById(id);
        if (count == 0) {
            return Result.error("0行服务器配置被删除");
        } else {
            return Result.success();
        }
    }
}
