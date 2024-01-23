package com.studies.myfirstspringbootapp.web.demos.web.service;

import com.studies.myfirstspringbootapp.web.demos.web.models.Result;

/**
 * 响应服务
 */
public interface ResponseService {
    /**
     * 获得成功结果
     *
     * @return ：成功结果
     */
    Result<Object> SuccessResult();

    /**
     * 默认错误结果
     *
     * @return : 错误结果
     */
    default Result<Object> ErrorResult() {
        return Result.error("default error result");
    }
}
