package com.jyx.service.impl;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.jyx.pojo.Stu;
import com.jyx.service.StuService;
import com.jyx.service.TestTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestTransServiceImpl implements TestTransService {

    @Autowired
    private StuService stuService;

    /**
     * 事务传播 - Propagation
     *      REQUIRED: 使用当前的事务，如果当前没有事务，则自己新建一个事务，子方法是必须运行在一个事务中的；
     *                  （父级有事务就跟随父级的事务，没有事务就自己创建）
     *                如果当前存在事务，则加入这个事务，成为一个整体。
     *                举例：领导没饭吃，我有钱，我会自己买了自己吃；领导有的吃，会分给你一起吃。
     *      SUPPORTS: 如果当前有事务，则使用事务；如果当前没有事务，则不使用事务。
     *                举例：领导没饭吃，我也没饭吃；领导有饭吃，我也有饭吃。
     *      MANDATORY: 该传播属性强制必须存在一个事务，如果不存在，则抛出异常
     *                 举例：领导必须管饭，不管饭没饭吃，我就不乐意了，就不干了（抛出异常）
     *      REQUIRES_NEW: 如果当前有事务，则挂起该事务，并且自己创建一个新的事务给自己使用；
     *                    如果当前没有事务，则同 REQUIRED
     *                    (其实无论父级有没有事务，我都是自己创建一个单独的事务，不受其他影响)
     *                    举例：领导有饭吃，我偏不要，我自己买了自己吃
     *      NOT_SUPPORTED: 如果当前有事务，则把事务挂起，自己不适用事务去运行数据库操作
     *                     (要是父级有事务，到这个方法就会挂起，所以总是非事务的执行)
     *                     举例：领导有饭吃，分一点给你，我太忙了，放一边，我不吃
     *      NEVER: 如果当前有事务存在，则抛出异常
     *             举例：领导有饭给你吃，我不想吃，我热爱工作，我抛出异常
     *      NESTED: 如果当前有事务，则开启子事务（嵌套事务），嵌套事务是独立提交或者回滚；
     *              如果当前没有事务，则同 REQUIRED。
     *              但是如果主事务提交，则会携带子事务一起提交。
     *              如果主事务回滚，则子事务会一起回滚。相反，子事务异常，则父事务可以回滚或不回滚。
     *              （外层事务失败会回滚内层，内层事务失败不会必然让外层回滚，外层如果捕获异常就不会回滚）
     *              （外层没有事务就跟REQUIRED一样）
     *              举例：领导决策不对，老板怪罪，领导带着小弟一同受罪。小弟出了差错，领导可以推卸责任。
     *
     *      MANDATORY ||  NEVER
     *      REQUIRED  ||  SUPPORTS
     *      REQUIRED_NEW  ||  NOT_SUPPORTED
     *      NESTED
     */

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testPropagationTrans() {
        stuService.saveParent();

        try {
            // save point
            stuService.saveChildren();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // delete
        // update
        stuService.saveParent();

//        int a = 1 / 0;
    }
}
