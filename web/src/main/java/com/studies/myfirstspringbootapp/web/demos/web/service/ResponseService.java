package com.studies.myfirstspringbootapp.web.demos.web.service;

import com.studies.myfirstspringbootapp.web.demos.web.models.Result;

/**
 * 响应服务
 */
public interface ResponseService {
    /**
     * 获得成功结果
     * @return ：成功结果
     */
    public Result<Object> SuccessResult();
}
