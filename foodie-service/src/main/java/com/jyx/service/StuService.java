package com.jyx.service;

import com.jyx.pojo.Stu;
import org.springframework.stereotype.Service;


public interface StuService {

    Stu getStuInfo(int id);

    void saveStu();

    void uodateStu(int id);

    void deleteStu(int id);
}
