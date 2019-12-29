package com.springIoc.service.impl;

import com.springIoc.service.BeanService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Brian in 15:01 2018/3/25
 */
@Order(1)
@Component
public class BeanServiceImplOne implements BeanService{
}
