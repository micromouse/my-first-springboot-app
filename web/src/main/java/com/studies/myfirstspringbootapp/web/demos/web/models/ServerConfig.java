package com.studies.myfirstspringbootapp.web.demos.web.models;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 服务器配置实体
 */
@Data
public class ServerConfig {
    private String key;
    private String value;
    private String comment;
    private LocalDateTime dataChange_CreatedTime;
    private LocalDateTime dataChange_LastTime;
}
