package cn.com.cube.platform.barber.mongo.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liang.Zhang on 2018/7/5.
 **/
@Document(collection = "User")
public class User extends BaseMongoDbModel{

    private String name;

    private String gengder;

    private String psd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGengder() {
        return gengder;
    }

    public void setGengder(String gengder) {
        this.gengder = gengder;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gengder='" + gengder + '\'' +
                ", psd='" + psd + '\'' +
                '}';
    }
}
