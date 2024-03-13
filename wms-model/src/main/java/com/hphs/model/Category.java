package com.hphs.model;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Category {
    //实体里面写的属性名 应该和数据库一 一 对应
    @Alias("编号")
    private  Integer id;
    private String name;
    private String img;
    @Alias("排序")
    private Integer seq;
    @Alias("父ID")
    private Integer parentId;
    private Integer status;
    @Alias("最新修改人")
    private String lastUpdateBy;
    @Alias("最近修改时间")
    private LocalDateTime lastUpdateTime;

}
