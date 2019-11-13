package cn.com.cube.platform.barber.mysql.service.impl;

import cn.com.cube.platform.barber.mysql.entity.TSysAccount;
import cn.com.cube.platform.barber.mysql.mapper.TSysAccountMapper;
import cn.com.cube.platform.barber.mysql.service.BaseServiceCom;
import cn.com.cube.platform.barber.mysql.service.ITSysAccountService;
import cn.com.cube.platform.barber.mysql.vo.PageParams;
import cn.com.cube.platform.barber.utils.ComEnum;
import cn.com.cube.platform.barber.utils.Tuple2;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jh
 * @since 2019-11-12
 */
@Service
public class TSysAccountServiceImpl extends ServiceImpl<TSysAccountMapper, TSysAccount> implements ITSysAccountService {



    @Override
    public PageParams<TSysAccount> listPage(PageParams<TSysAccount> pageParams) {
        QueryWrapper<TSysAccount> queryWrapper=BaseServiceCom.wrapper(pageParams);
        Page<TSysAccount> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        IPage<TSysAccount> iPage = this.page(page,queryWrapper);

        pageParams.setData(iPage.getRecords());
        int totalRows=this.count(queryWrapper);
        int totalPage=(totalRows-1)/pageParams.getPageSize()+1;
        pageParams.setTotalRows(totalRows);
        pageParams.setTotalPage(totalPage);

        return pageParams;
    }

    @Override
    public Long testCount() {
        return baseMapper.testCount();
    }
}
