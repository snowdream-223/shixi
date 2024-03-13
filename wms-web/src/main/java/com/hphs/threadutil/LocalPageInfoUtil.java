package com.hphs.threadutil;

import com.hphs.info.PageInfo;

public class LocalPageInfoUtil {

    //创建线程对象 把需要共享的数据放到实例对象上面
    private static ThreadLocal<PageInfo> localPageInfoThreadLocal=
            new ThreadLocal<>();

    //往线程上设置标签格式定义 {k,v}
    public static void set(PageInfo pageInfo){
        localPageInfoThreadLocal.set(pageInfo);
    }
    //从线程上获取标签数据，只是只读的模式 他没有删除
    public static PageInfo get(){
        return localPageInfoThreadLocal.get();
    }
    //从线程上把绑定的对象的标签删除掉  如果不删除就是出现内存泄露
    public static  void remove(){
        localPageInfoThreadLocal.remove();
    }

}
