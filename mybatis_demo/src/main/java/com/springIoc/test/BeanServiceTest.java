package com.springIoc.test;

import com.springIoc.service.BeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Brian in 15:02 2018/3/25
 */
@Component
public class BeanServiceTest {

    @Qualifier("beanServiceImplOne")
    @Autowired
    private BeanService beanService;

    @Autowired
    private List<BeanService> list;

    @Autowired
    private Map<String, BeanService> map;

    public void listInfo(){

        if(list != null){
            System.out.println(Arrays.toString(list.toArray()));
        }else{
            System.out.println("list is null");
        }

    }

    public void mapInfo(){
        if(map != null && map.size() > 0){
            for(Map.Entry<String, BeanService> entry : map.entrySet()){
                System.out.println(entry.getKey()+"; "+entry.getValue());
            }
        }else {
            System.out.println("map is null");
        }
    }

    public void beanServiceInfo(){
        if(beanService != null){
            System.out.println("beanService = "+beanService);
        }
    }

}
