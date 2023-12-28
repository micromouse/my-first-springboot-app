package com.studies.myfirstspringbootapp.web.demos.web.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.studies.myfirstspringbootapp.web.demos.web.dao.ServerConfigMapper;
import com.studies.myfirstspringbootapp.web.demos.web.models.PaginationModel;
import com.studies.myfirstspringbootapp.web.demos.web.models.ServerConfig;
import com.studies.myfirstspringbootapp.web.demos.web.service.ServerConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务器配置服务接口实现
 */
@Service
@Slf4j
public class ServerConfigServiceImpl implements ServerConfigService {
    private final ServerConfigMapper serverConfigMapper;

    /**
     * 初始化服务器配置服务接口实现
     *
     * @param serverConfigMapper ：服务器配置映射器
     */
    public ServerConfigServiceImpl(ServerConfigMapper serverConfigMapper) {
        this.serverConfigMapper = serverConfigMapper;
    }

    /**
     * 按配置key查找服务器配置信息
     *
     * @param key ：配置key
     * @return ：服务器配置信息
     */
    @Override
    public ServerConfig findByKey(String key) {
        return serverConfigMapper.findByKey(key);
    }

    /**
     * 获得所有服务器配置集合
     *
     * @return ：服务配置集合
     */
    @Override
    public List<ServerConfig> getServerConfigs() {
        return serverConfigMapper.list();
    }

    /**
     * 分页查询服务器配置
     *
     * @param pageIndex        : 页索引
     * @param pageSize         : 页记录数
     * @param key              ：配置key
     * @param createdTimeStart ：数据变动建立时间开始
     * @param createdTimeEnd   ：数据变动建立时间结束
     * @return ：分页服务器配置信息
     */
    @Override
    public PaginationModel<ServerConfig> queryPagination(Integer pageIndex, Integer pageSize, String key, LocalDate createdTimeStart, LocalDate createdTimeEnd) {
        //请求日志
        HashMap<String, Object> request = new HashMap<>();
        request.put("pageIndex", pageIndex);
        request.put("pageSize", pageSize);
        request.put("key", key);
        request.put("createdTimeStart", createdTimeStart);
        request.put("createdTimeEnd", createdTimeEnd);
        log.info("正在执行查询，请求参数：{}", request);

        //分页查询服务器配置
        Page<ServerConfig> page = PageHelper
                .startPage(pageIndex, pageSize)
                .doSelectPage(() -> {
                    serverConfigMapper.queryPaginationByXml(key, createdTimeStart, createdTimeEnd);
                });
        return new PaginationModel<>(page.getTotal(), page.getResult());
    }

    /**
     * 删除服务器配置
     *
     * @param id ：配置id
     * @return ：受影响记录行数
     */
    @Override
    public Integer deleteById(Integer id) {
        return serverConfigMapper.DeleteById(id);
    }
}
