package cn.com.cube.platform.barber.mysql.service.impl;

import cn.com.cube.platform.barber.mysql.entity.TBizBarber;
import cn.com.cube.platform.barber.mysql.entity.TSysDict;
import cn.com.cube.platform.barber.mysql.mapper.TBizBarberMapper;
import cn.com.cube.platform.barber.mysql.service.BaseServiceCom;
import cn.com.cube.platform.barber.mysql.service.ITBizBarberService;
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
public class TBizBarberServiceImpl extends ServiceImpl<TBizBarberMapper, TBizBarber> implements ITBizBarberService {


    @Override
    public PageParams<TBizBarber> listPage(PageParams<TBizBarber> pageParams) {
        QueryWrapper<TBizBarber> queryWrapper= BaseServiceCom.wrapper(pageParams);
        Page<TBizBarber> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        IPage<TBizBarber> iPage = this.page(page,queryWrapper);

        pageParams.setData(iPage.getRecords());
        int totalRows=(int)iPage.getTotal();
        int totalPage=(totalRows-1)/pageParams.getPageSize()+1;
        pageParams.setTotalRows(totalRows);
        pageParams.setTotalPage(totalPage);

        return pageParams;
    }
}
