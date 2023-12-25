package com.studies.myfirstspringbootapp.web.demos.web.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 服务器配置实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerConfig {
    private String key;
    private String value;
    private String comment;
    private LocalDateTime dataChange_CreatedTime;
    private LocalDateTime dataChange_LastTime;
}
