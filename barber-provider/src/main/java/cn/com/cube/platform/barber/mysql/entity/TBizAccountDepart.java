package cn.com.cube.platform.barber.mysql.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jh
 * @since 2019-11-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class TBizAccountDepart extends entity1 {

    private Integer accountId;

    private Integer departId;


}
