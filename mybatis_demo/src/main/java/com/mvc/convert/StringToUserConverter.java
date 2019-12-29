package com.mvc.convert;

import com.mvc.pojo.User;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Brian in 14:33 2018/10/30
 */
public class StringToUserConverter implements Converter<String, User> {

    /**
     * 假设参数以TOM-12的形式传入
     *
     * @param source
     * @return
     */
    @Override
    public User convert(String source) {
        User user = new User();
        String[] arr = source.split("-");

        if (arr != null && arr.length == 2){
            user.setName(arr[0]);
            user.setId(Integer.parseInt(arr[1]));
        }
        return user;
    }
}
