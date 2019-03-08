package cn.com.cube.platform.barber.mysql.service.impl;


import cn.com.cube.platform.barber.mysql.entity.BaseEntity;
import cn.com.cube.platform.barber.mysql.entity.BaseExample;
import cn.com.cube.platform.barber.mysql.mapper.BaseMapper;
import cn.com.cube.platform.barber.mysql.service.BaseService;
import cn.com.cube.platform.barber.mysql.vo.PageParams;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BaseServiceImpl <P extends BaseEntity,Q extends BaseExample> implements BaseService<P,Q> {

    @Autowired
    private BaseMapper<P,Q> mapper;

    @Override
    public int countByExample(Q example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(Q example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(P record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(P record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<P> selectByExampleWithRowbounds(Q example, RowBounds rowBounds) {
        return mapper.selectByExampleWithRowbounds(example,rowBounds);
    }

    @Override
    public List<P> selectByExample(Q example) {
        return mapper.selectByExample(example);
    }

    @Override
    public P selectByPrimaryKey(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(P record, Q example) {
        return mapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(P record, Q example) {
        return mapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(P record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(P record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public PageParams<P> listPage(Q example, PageParams<P> pageParams) {
        int currentPage=pageParams.getPage(),pageSize=pageParams.getPageSize();
        RowBounds rowBounds=new RowBounds((currentPage-1)*pageSize,pageSize);
        List<P> list=mapper.selectByExampleWithRowbounds(example,rowBounds);
        pageParams.setData(list);
        int totalRows=mapper.countByExample(example);
        int totalPage=(totalRows-1)/pageSize+1;
        pageParams.setTotalPage(totalPage);
        pageParams.setTotalRows(totalRows);
        return pageParams;
    }
}



