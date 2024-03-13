package com.hphs.dao;

import com.hphs.model.Category;
import com.hphs.model.CategoryQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper  //告诉springboot容器 我把dao交给你来管理
public interface CategoryDao {

    public List<Category> select(CategoryQuery query);
}
