package cn.com.cube.platform.barber.mysql.vo;

import cn.com.cube.platform.barber.mysql.entity.entity;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class PageParams<T extends entity> implements Serializable {
    //页码
    private Integer page=1;
    //每页记录数
    private Integer pageSize=10;
    //记录总数
    private Integer totalRows=0;
    //总页数
    private Integer totalPage=1;

    private List<T> data;
    //
    private T bean;
    //排序的参数
    private String orderBy="id";
    //排序方位 desc asc
    private String direction="desc";
    //查询参数放在这
    private Map<String,Object> filter=new HashMap<>(10);
    //临时变量
    private Map<String,Object> tempParams=new HashMap<>(10);
}
