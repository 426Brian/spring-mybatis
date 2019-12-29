package com.springIoc.service.impl;

import com.springIoc.service.OneInterface;

/**
 * Created by Brian in 16:56 2018/3/9
 */
public class OneImpl implements OneInterface{
    @Override
    public String sayHello(String word) {
        return "Word from interface: \'OneInterface\' " +word;
    }
}
