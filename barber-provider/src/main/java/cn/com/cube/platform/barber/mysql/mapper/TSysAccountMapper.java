package cn.com.cube.platform.barber.mysql.mapper;

import cn.com.cube.platform.barber.mysql.entity.TSysAccount;
import cn.com.cube.platform.barber.mysql.entity.TSysAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TSysAccountMapper extends BaseMapper<TSysAccount,TSysAccountExample> {
}