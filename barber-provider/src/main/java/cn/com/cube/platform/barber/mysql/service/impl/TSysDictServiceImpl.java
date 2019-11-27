package cn.com.cube.platform.barber.mysql.service.impl;

import cn.com.cube.platform.barber.mysql.entity.TSysDepart;
import cn.com.cube.platform.barber.mysql.entity.TSysDict;
import cn.com.cube.platform.barber.mysql.mapper.TSysDictMapper;
import cn.com.cube.platform.barber.mysql.service.BaseServiceCom;
import cn.com.cube.platform.barber.mysql.service.ITSysDictService;
import cn.com.cube.platform.barber.mysql.vo.PageParams;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jh
 * @since 2019-11-27
 */
@Service
public class TSysDictServiceImpl extends ServiceImpl<TSysDictMapper, TSysDict> implements ITSysDictService {

    @Override
    public PageParams<TSysDict> listPage(PageParams<TSysDict> pageParams) {
        QueryWrapper<TSysDict> queryWrapper= BaseServiceCom.wrapper(pageParams);
        Page<TSysDict> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        IPage<TSysDict> iPage = this.page(page,queryWrapper);

        pageParams.setData(iPage.getRecords());
        int totalRows=(int)iPage.getTotal();
        int totalPage=(totalRows-1)/pageParams.getPageSize()+1;
        pageParams.setTotalRows(totalRows);
        pageParams.setTotalPage(totalPage);

        return pageParams;
    }


    @Override
    public Boolean del(List<Integer> ids) {
        String str= StringUtils.join(ids,",");
        String strSql=String.format("delete from t_sys_dict where id in (%s) or parent_id in (%s) ",str,str);
        jdbcTemplate.update(strSql);
        return true;
    }

    @Override
    public List<TSysDict> listChildren(String code) {
        QueryWrapper<TSysDict> queryWrapper= new QueryWrapper<>();
        queryWrapper.lambda().eq(TSysDict::getCode,code).eq(TSysDict::getParentId,-1);

        QueryWrapper<TSysDict> queryWrapper1= new QueryWrapper<>();
        queryWrapper1.lambda().eq(TSysDict::getParentId,this.getOne(queryWrapper).getId());
        return this.list(queryWrapper1);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;
}
