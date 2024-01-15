package com.studies.myfirstspringbootapp.ordering.Controlers;

import com.studies.myfirstspringbootapp.ordering.Daos.ServerConfigMapper;
import com.studies.myfirstspringbootapp.ordering.Models.ServerConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 服务器配置控制器
 */
@RestController
@RequestMapping("/serverConfig")
public class ServerConfigController {
    private final ServerConfigMapper serverConfigMapper;

    /**
     * 初始化服务器配置控制器
     *
     * @param serverConfigMapper ：服务器配置映射器
     */
    public ServerConfigController(ServerConfigMapper serverConfigMapper) {
        this.serverConfigMapper = serverConfigMapper;
    }

    /**
     * 新服务器配置
     *
     * @return ：新服务器配置
     */
    @RequestMapping("/new")
    public ServerConfig newServerConfig() {
        ServerConfig serverConfig = new ServerConfig();
        serverConfig.setId(100);
        serverConfig.setKey("new key");
        return serverConfig;
    }

    /**
     * 获得所有服务器配置信息
     *
     * @return ：服务器配置信息集合
     */
    @RequestMapping("/all")
    public List<ServerConfig> list() {
        return serverConfigMapper.list();
    }
}
