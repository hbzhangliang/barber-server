package cn.com.cube.platform.barber.mysql.vo;

import cn.com.cube.platform.barber.mysql.entity.TBizBarber;
import cn.com.cube.platform.barber.mysql.entity.TBizCustomer;
import cn.com.cube.platform.barber.mysql.entity.TSysAccount;
import cn.com.cube.platform.barber.mysql.entity.TSysDepart;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AccountVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private TSysAccount account;
    private TSysDepart depart;
    private TBizBarber barber;
    private TBizCustomer customer;

    private List<TSysDepart> departList;
}
