package cn.com.cube.platform.barber.mysql.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public abstract class entity implements Serializable {

    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

}
