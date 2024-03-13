package com.hphs.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hphs.dao.CategoryDao;
import com.hphs.info.PageInfo;
import com.hphs.model.Category;
import com.hphs.model.CategoryQuery;
import com.hphs.threadutil.LocalPageInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public List<Category> select(CategoryQuery query){
        if (query.getPageNum()!=null && query.getPageSize()!=null) {
            PageHelper.startPage(query.getPageNum(),query.getPageSize());
        }
        List<Category> categoryList = categoryDao.select(query);
        //转换为page类拿到我总条数
        if(categoryList instanceof Page){
            Page page= (Page) categoryList;
           long total = page.getTotal();
            //System.out.println(total);
            LocalPageInfoUtil.set(PageInfo.builder().total(total).build());
        }


        return  categoryList;
    }

}
