package cn.com.cube.platform.barber.mysql.service;

import cn.com.cube.platform.barber.mysql.entity.TSysAccount;
import cn.com.cube.platform.barber.mysql.entity.entity;
import cn.com.cube.platform.barber.mysql.vo.PageParams;
import cn.com.cube.platform.barber.utils.ComEnum;
import cn.com.cube.platform.barber.utils.Tuple2;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.HashMap;
import java.util.Map;

public class BaseServiceCom {


    /**
     * eq_ 等于
     * lk_ like查询
     *
     * b0_ between
     * b1_
     *
     * gt_
     * ge_
     *
     * lt_
     * le_
     *
     * @param pageParams
     * @return
     */
    public static <T extends entity>QueryWrapper<T> wrapper(PageParams<T> pageParams) {
        Map<String,Object> map = pageParams.getFilter();

        QueryWrapper<T> queryWrapper =  new QueryWrapper<>();
        //排序
        if(pageParams.getDirection().equals("desc")){
            queryWrapper.orderByDesc(pageParams.getOrderBy());
        }
        else {
            queryWrapper.orderByAsc(pageParams.getOrderBy());
        }
        //对map进行便利，各种条件查询
        if(map!=null&&!map.isEmpty()) {
            Map<String, Tuple2<Object,Object>> betweenMap=new HashMap<>();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                ComEnum.SearchOp op=ComEnum.SearchOp.getOp(entry.getKey().substring(0,3));
                String key=entry.getKey().substring(3);
                switch (op){
                    case eq_:{
                        queryWrapper.eq(key,entry.getValue());
                        break;
                    }
                    case lk_:{
                        queryWrapper.like(key,entry.getValue());
                        break;
                    }
                    case gt_:{
                        queryWrapper.gt(key,entry.getValue());
                        break;
                    }
                    case ge_:{
                        queryWrapper.ge(key,entry.getValue());
                        break;
                    }
                    case lt_:{
                        queryWrapper.lt(key,entry.getValue());
                        break;
                    }
                    case le_:{
                        queryWrapper.le(key,entry.getValue());
                        break;
                    }
                    case b0_:{
                        if(betweenMap.get(key)==null){
                            betweenMap.put(key,new Tuple2<>(entry.getValue(),null));
                        }
                        else {
                            betweenMap.get(key)._1(entry.getValue());
                        }
                        break;
                    }
                    case b1_:{
                        if(betweenMap.get(key)==null){
                            betweenMap.put(key,new Tuple2<>(null,entry.getValue()));
                        }
                        else {
                            betweenMap.get(key)._2(entry.getValue());
                        }
                        break;
                    }
                    default:break;
                }
            }

            if(!betweenMap.isEmpty()){
                for (Map.Entry<String, Tuple2<Object,Object>> entry : betweenMap.entrySet()) {
                    Tuple2<Object,Object> tmpT=entry.getValue();
                    if(tmpT._1().orElse(null)!=null&&tmpT._2().orElse(null)!=null){
                        queryWrapper.between(entry.getKey(),tmpT._1(),tmpT._2());
                    }
                    else if(tmpT._1().orElse(null)==null&&tmpT._2().orElse(null)!=null){
                        queryWrapper.le(entry.getKey(),tmpT._2().get());
                    }
                    else if(tmpT._1().orElse(null)!=null&&tmpT._2().orElse(null)==null){
                        queryWrapper.ge(entry.getKey(),tmpT._1().get());
                    }
                }
            }
        }

        return queryWrapper;
    }

}
