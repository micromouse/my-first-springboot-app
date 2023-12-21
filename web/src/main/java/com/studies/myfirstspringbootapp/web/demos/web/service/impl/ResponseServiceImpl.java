package com.studies.myfirstspringbootapp.web.demos.web.service.impl;

import com.studies.myfirstspringbootapp.web.demos.web.models.Result;
import com.studies.myfirstspringbootapp.web.demos.web.service.ResponseService;
import org.springframework.stereotype.Service;

/**
 * 响应服务接口实现
 */
@Service
public class ResponseServiceImpl implements ResponseService {
    /**
     * 获得成功结果
     * @return ：成功结果
     */
    @Override
    public Result<Object> SuccessResult() {
        return Result.success();
    }
}
