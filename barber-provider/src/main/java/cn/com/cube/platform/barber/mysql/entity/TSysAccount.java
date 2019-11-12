package cn.com.cube.platform.barber.mysql.entity;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jh
 * @since 2019-11-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class TSysAccount extends entity {

    private static final long serialVersionUID = 1L;

    private String account;

    private String password;

    private String stype;

    private String phone;

    private String remark;

    private String status;

    private Integer flag;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String createBy;

    private String updateBy;


}
