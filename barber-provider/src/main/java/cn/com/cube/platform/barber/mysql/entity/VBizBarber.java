package cn.com.cube.platform.barber.mysql.entity;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author jh
 * @since 2019-11-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class VBizBarber extends entity {

    private Integer accountId;

    private Integer departId;

    private String name;

    private String gender;

    private LocalDateTime birthday;

    private String phone;

    private String address;

    private String email;

    private String qq;

    private String contact;

    private String contactNum;

    private LocalDateTime joinDate;

    private LocalDateTime leaveDate;

    private String skill;

    private String account;

    private String password;

    private String departName;

    private String departAddress;

    private String departPhoto;

    private String departIntroduce;


}
