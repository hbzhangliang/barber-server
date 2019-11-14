package cn.com.cube.platform.barber.mysql.service.impl;

import cn.com.cube.platform.barber.mysql.entity.TSysAccount;
import cn.com.cube.platform.barber.mysql.entity.TSysDepart;
import cn.com.cube.platform.barber.mysql.mapper.TSysDepartMapper;
import cn.com.cube.platform.barber.mysql.service.BaseServiceCom;
import cn.com.cube.platform.barber.mysql.service.ITSysDepartService;
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
 * @since 2019-11-14
 */
@Service
public class TSysDepartServiceImpl extends ServiceImpl<TSysDepartMapper, TSysDepart> implements ITSysDepartService {

    @Override
    public PageParams<TSysDepart> listPage(PageParams<TSysDepart> pageParams) {
        QueryWrapper<TSysDepart> queryWrapper= BaseServiceCom.wrapper(pageParams);
        Page<TSysDepart> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        IPage<TSysDepart> iPage = this.page(page,queryWrapper);

        pageParams.setData(iPage.getRecords());
        int totalRows=this.count(queryWrapper);
        int totalPage=(totalRows-1)/pageParams.getPageSize()+1;
        pageParams.setTotalRows(totalRows);
        pageParams.setTotalPage(totalPage);

        return pageParams;
    }
}
