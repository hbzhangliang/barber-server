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

    private String account;

    private String password;

    private String stype;

    private String phone;

    private String remark;



}
