package cn.com.cube.platform.barber.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class BeanTransUtils {

    public static <T> T transBean(Class<T> tClass,Object entity){
        if(entity==null) return null;
        try {
            T t = tClass.newInstance();
            BeanUtils.copyProperties(entity, t);
            return t;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    public static <T,U> List<T> transBeans(Class<T> tClass,List<U> entityList){
        if(entityList==null||entityList.isEmpty()){
            return null;
        }
        List<T> list=new ArrayList<>(10);
        entityList.forEach(p->{
            list.add(transBean(tClass,p));
        });
        return list;
    }

}
