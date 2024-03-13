package com.hphs.test;

import com.hphs.model.Category;
import com.hphs.model.CategoryQuery;
import com.hphs.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CateTest {

    @Autowired
    private CategoryService service;
    @Test
    public void Test(){
        CategoryQuery query=new CategoryQuery();
       query.setName("肉");
        Integer[] arr={145,177,192};
        query.setIds(arr);
        List<Category> select = service.select(query);
        for (Category category : select) {
            System.out.println(category);
        }
    }
}
