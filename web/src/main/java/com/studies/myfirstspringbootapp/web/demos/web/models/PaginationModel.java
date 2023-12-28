package com.studies.myfirstspringbootapp.web.demos.web.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页模型
 *
 * @param <TData> ：数据类型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationModel<TData> {
    /**
     * 总记录数
     */
    private long total;
    /**
     * 数据集合
     */
    private List<TData> datas;
}
