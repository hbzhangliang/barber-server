package cn.com.cube.platform.barber.utils.global;

import cn.com.cube.platform.barber.mysql.vo.AccountVo;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Liang.Zhang on 2018/8/13.
 **/

public class GlobalHolder {

    private static final ThreadLocal<AccountVo> requestHolder = new ThreadLocal<>();

    public static AccountVo get(){
        return requestHolder.get();
    }

    public static void set(AccountVo bean){
        requestHolder.set(bean);
    }

    public static void remove(){
        requestHolder.remove();
    }
}
