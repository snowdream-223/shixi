package com.hphs.model;

import lombok.Data;

@Data
public class CategoryQuery {
    private Integer id; // where id=192
    private Integer[] ids; //where id in (177,192,145)
    private String name; // where name like %肉%
    private Integer status; //where status = 1
    private Integer parentId;
     // 分页查询
    private Integer pageNum; //第几页
    private Integer pageSize; //每页显示多少条数据


}
