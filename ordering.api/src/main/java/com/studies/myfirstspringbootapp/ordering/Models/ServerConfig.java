package com.studies.myfirstspringbootapp.ordering.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 服务器配置模型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerConfig {
    private Integer id;
    private String key;
    private String cluster;
    private String value;
    private String comment;
    private boolean isDeleted;
    private Integer deletedAt;
    private String dataChangeCreatedBy;
    private LocalDateTime dataChangeCreatedTime;
    private String dataChangeLastModifiedBy;
    private LocalDateTime dataChangeLastTime;
}
