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
 * @since 2019-11-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class TSysDepart extends entity {

    private String name;

    private String address;

    private String photo;

    private String introduce;

    private String remark;


}
