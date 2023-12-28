package com.studies.myfirstspringbootapp.web.demos.web.service;

import com.studies.myfirstspringbootapp.web.demos.web.models.PaginationModel;
import com.studies.myfirstspringbootapp.web.demos.web.models.ServerConfig;

import java.time.LocalDate;
import java.util.List;

/**
 * 服务器配置服务接口
 */
public interface ServerConfigService {
    /**
     * 按配置key查找服务器配置信息
     * @param key ：配置key
     * @return ：服务器配置信息
     */
    ServerConfig findByKey(String key);

    /**
     * 获得所有服务器配置集合
     * @return ：服务配置集合
     */
    List<ServerConfig> getServerConfigs();

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
    PaginationModel<ServerConfig> queryPagination(Integer pageIndex, Integer pageSize, String key, LocalDate createdTimeStart, LocalDate createdTimeEnd);

    /**
     * 删除服务器配置
     * @param id ：配置id
     * @return ：受影响记录行数
     */
    Integer deleteById(Integer id);
}
