package cn.com.cube.platform.barber.mysql.service.impl;

import cn.com.cube.platform.barber.mysql.entity.TBizCustomer;
import cn.com.cube.platform.barber.mysql.mapper.TBizCustomerMapper;
import cn.com.cube.platform.barber.mysql.service.BaseServiceCom;
import cn.com.cube.platform.barber.mysql.service.ITBizCustomerService;
import cn.com.cube.platform.barber.mysql.vo.PageParams;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jh
 * @since 2019-11-20
 */
@Service
public class TBizCustomerServiceImpl extends ServiceImpl<TBizCustomerMapper, TBizCustomer> implements ITBizCustomerService {

    @Override
    public PageParams<TBizCustomer> listPage(PageParams<TBizCustomer> pageParams) {
        QueryWrapper<TBizCustomer> queryWrapper= BaseServiceCom.wrapper(pageParams);
        Page<TBizCustomer> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        IPage<TBizCustomer> iPage = this.page(page,queryWrapper);

        pageParams.setData(iPage.getRecords());
        int totalRows=(int)iPage.getTotal();
        int totalPage=(totalRows-1)/pageParams.getPageSize()+1;
        pageParams.setTotalRows(totalRows);
        pageParams.setTotalPage(totalPage);

        return pageParams;
    }
}
