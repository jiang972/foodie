package com.jyx.service;

import com.jyx.pojo.Stu;
import org.springframework.stereotype.Service;


public interface StuService {

    Stu getStuInfo(int id);

    void saveStu();

    void updateStu(int id);

    void deleteStu(int id);

    /**
     * 测试方法
     */
    public void saveParent();
    public void saveChildren();
}
