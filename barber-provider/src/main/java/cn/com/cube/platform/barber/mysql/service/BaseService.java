package cn.com.cube.platform.barber.mysql.service;

import cn.com.cube.platform.barber.mysql.entity.BaseEntity;
import cn.com.cube.platform.barber.mysql.entity.BaseExample;
import cn.com.cube.platform.barber.mysql.vo.PageParams;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface BaseService<P extends BaseEntity,Q extends BaseExample> {

    int countByExample(Q example);

    int deleteByExample(Q example);

    int deleteByPrimaryKey(String id);

    int insert(P record);

    int insertSelective(P record);

    List<P> selectByExampleWithRowbounds(Q example, RowBounds rowBounds);

    List<P> selectByExample(Q example);

    P selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") P record, @Param("example") Q example);

    int updateByExample(@Param("record") P record, @Param("example") Q example);

    int updateByPrimaryKeySelective(P record);

    int updateByPrimaryKey(P record);

    PageParams<P> listPage(Q example, PageParams<P> pageParams);

}
