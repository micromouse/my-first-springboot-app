package com.studies.myfirstspringbootapp.web.demos.web.dao;

import com.studies.myfirstspringbootapp.web.demos.web.models.ServerConfig;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 服务器配置信息映射器
 * Mapper注解需要下列依赖
 * <dependency>
 * <groupId>org.mybatis.spring.boot</groupId>
 * <artifactId>mybatis-spring-boot-starter</artifactId>
 * <version>2.3.1</version>
 * </dependency>
 * <dependency>
 * <groupId>com.mysql</groupId>
 * <artifactId>mysql-connector-j</artifactId>
 * <version>8.2.0</version>
 * <scope>runtime</scope>
 * </dependency>
 */
@Mapper
public interface ServerConfigMapper {
    /**
     * 获得服务器配置信息集合
     *
     * @return ：服务器配置信息集合
     */
    @Select("SELECT * FROM ServerConfig ORDER BY `key` ASC")
    List<ServerConfig> list();

    /**
     * 由key查找服务器配置
     *
     * @param key : 服务器配置key
     * @return ：服务器配置对象
     */
    @Select("SELECT * FROM ServerConfig WHERE `key` = #{key}")
    ServerConfig findByKey(@Param("key") String key);

    /**
     * 按id删除服务器配置
     *
     * @param id ：id
     * @return ：删除行数
     */
    @Delete("DELETE FROM ServerConfig WHERE id=#{id}")
    Integer DeleteById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into ServerConfig(`Key`,Cluster,Value,Comment,IsDeleted,DeletedAt,DataChange_CreatedBy,DataChange_CreatedTime,DataChange_LastModifiedBy,DataChange_LastTime) " +
            "values(#{key},#{cluster},#{value},#{comment},#{isDeleted},#{deletedAt},#{dataChangeCreatedBy},#{dataChangeCreatedTime},#{dataChangeLastModifiedBy},#{dataChangeLastTime})")
    void Insert(ServerConfig serverConfig);
}
