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
public class VBizCustomer extends entity {

    private Integer accountId;

    private Integer departId;

    private Integer healthId;

    private String name;

    private String gender;

    private LocalDateTime birthday;

    private String height;

    private String phone;

    private String career;

    private String blood;

    private String weight;

    private String address;

    private String email;

    private String qq;

    private String food;

    private String foodLike;

    private String sleepTime;

    private String sleepQuality;

    private String sleepDrink;

    private String jobNature;

    private String loctation;

    private String mens;

    private String color;

    private String skinColor;

    private String skinType;

    private String head;

    private String eye;

    private String face;

    private String tspace;

    private LocalDateTime firstTime;

    private LocalDateTime lastTime;

    private String mouse;

    private String account;

    private String password;

    private String departName;

    private String departAddress;

    private String departPhoto;

    private String departIntroduce;


}
