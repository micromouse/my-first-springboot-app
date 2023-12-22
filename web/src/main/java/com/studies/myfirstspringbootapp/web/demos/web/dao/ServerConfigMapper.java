package com.studies.myfirstspringbootapp.web.demos.web.dao;

import com.studies.myfirstspringbootapp.web.demos.web.models.ServerConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 服务器配置信息映射器
 */
@Mapper
public interface ServerConfigMapper {
    /**
     * 获得服务器配置信息集合
     * @return ：服务器配置信息集合
     */
    @Select("SELECT * FROM ServerConfig ORDER BY `key` ASC")
    List<ServerConfig> list();
}
