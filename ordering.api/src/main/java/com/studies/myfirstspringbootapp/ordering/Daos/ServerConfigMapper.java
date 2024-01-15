package com.studies.myfirstspringbootapp.ordering.Daos;

import com.studies.myfirstspringbootapp.ordering.Models.ServerConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 */
@Mapper
public interface ServerConfigMapper {
    /**
     * 获得所有服务器配置信息
     *
     * @return ：服务器配置信息集合
     */
    List<ServerConfig> list();
}
