package cn.com.cube.platform.barber.mongo.repo.support;

import cn.com.cube.platform.barber.mongo.models.User;
import cn.com.cube.platform.barber.mongo.repo.UserRepo;
import org.springframework.stereotype.Service;


@Service
public class UserRepoSupport extends BaseMongoDbRepoSupport<User> implements UserRepo {
}
