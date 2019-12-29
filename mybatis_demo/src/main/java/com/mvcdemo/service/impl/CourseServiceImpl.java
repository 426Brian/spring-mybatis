package com.mvcdemo.service.impl;

import com.mvcdemo.service.CourseService;
import org.springframework.stereotype.Service;

/**
 * Created by Brian in 15:33 2018/1/2
 */

@Service("courseService")
public class CourseServiceImpl implements CourseService{
    @Override
    public void test() {
        System.out.println("=== this is test() in CourseServiceImpl ===");
    }
}
