package com.studies.myfirstspringbootapp.web.demos.web.dao;

import com.studies.myfirstspringbootapp.web.demos.web.models.ServerConfig;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
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
    List<ServerConfig> list();

    /**
     * 由key查找服务器配置
     *
     * @param key : 服务器配置key
     * @return ：服务器配置对象
     */
    @Results({
            @Result(column = "datachange_createdby", property = "dataChangeCreatedBy"),
            @Result(column = "datachange_createdtime", property = "dataChangeCreatedTime")
    })
    @Select("SELECT * FROM ServerConfig WHERE `key` = #{key}")
    ServerConfig findByKey(@Param("key") String key);

    /**
     * 按key集合查找服务器配置
     *
     * @param keys ：key集合
     * @return ：服务器配置集合
     */
    List<ServerConfig> findByKeys(List<String> keys);

    /**
     * 查询符合条件的服务器配置
     * -- 可以使用下列方式拼接字符串，这样预编译无效[key like '%#{key}%']
     * select * from serverconfig where key like '%${key}%'
     *
     * @param key              ：配置key
     * @param createdTimeStart ：数据变动建立时间开始
     * @param createdTimeEnd   ：数据变动建立时间结束
     * @return ：服务器配置信息集合
     */
    @Select("SELECT * " +
            "FROM   serverconfig " +
            "WHERE  datachange_createdtime>=#{createdTimeStart} AND " +
            "       datachange_createdtime<#{createdTimeEnd} AND " +
            "       `key` LIKE CONCAT('%',#{key},'%')")
    List<ServerConfig> query(String key, LocalDate createdTimeStart, LocalDate createdTimeEnd);

    /**
     * 按mybatis xml配置映射方式查询服务器配置
     *
     * @param key              ：配置key
     * @param createdTimeStart ：数据变动建立时间开始
     * @param createdTimeEnd   ：数据变动建立时间结束
     * @return ：服务器配置信息集合
     */
    List<ServerConfig> queryByXml(String key, LocalDate createdTimeStart, LocalDate createdTimeEnd);

    /**
     * 按mybatis xml配置映射方式分页查询服务器配置
     * @param key ：配置key
     * @param createdTimeStart ：数据变动建立时间开始
     * @param createdTimeEnd ：数据变动建立时间结束
     * @return ：分页服务器配置信息
     */
    List<ServerConfig> queryPaginationByXml(String key, LocalDate createdTimeStart, LocalDate createdTimeEnd);

    /**
     * 按id删除服务器配置
     *
     * @param id ：id
     * @return ：删除行数
     */
    @Delete("DELETE FROM ServerConfig WHERE id=#{id}")
    Integer DeleteById(Integer id);

    /**
     * 添加服务器配置
     * @param serverConfig ：要添加的服务器配置
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void Insert(ServerConfig serverConfig);
}
