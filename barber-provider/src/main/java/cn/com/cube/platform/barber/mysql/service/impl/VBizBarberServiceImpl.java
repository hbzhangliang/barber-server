package cn.com.cube.platform.barber.mysql.service.impl;

import cn.com.cube.platform.barber.mysql.entity.TBizCustomer;
import cn.com.cube.platform.barber.mysql.entity.VBizBarber;
import cn.com.cube.platform.barber.mysql.mapper.VBizBarberMapper;
import cn.com.cube.platform.barber.mysql.service.BaseServiceCom;
import cn.com.cube.platform.barber.mysql.service.IVBizBarberService;
import cn.com.cube.platform.barber.mysql.vo.PageParams;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author jh
 * @since 2019-11-28
 */
@Service
public class VBizBarberServiceImpl extends ServiceImpl<VBizBarberMapper, VBizBarber> implements IVBizBarberService {

    @Override
    public PageParams<VBizBarber> listPage(PageParams<VBizBarber> pageParams) {
        QueryWrapper<VBizBarber> queryWrapper= BaseServiceCom.wrapper(pageParams);
        Page<VBizBarber> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        IPage<VBizBarber> iPage = this.page(page,queryWrapper);

        pageParams.setData(iPage.getRecords());
        int totalRows=(int)iPage.getTotal();
        int totalPage=(totalRows-1)/pageParams.getPageSize()+1;
        pageParams.setTotalRows(totalRows);
        pageParams.setTotalPage(totalPage);

        return pageParams;
    }
}
