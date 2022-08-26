package test;


import com.cdut.pojo.User;
import com.cdut.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class test {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserService userService;

    @Test
    public void testSet() {
        redisTemplate.boundValueOps("name").set("zhangsaj");
    }

    @Test
    public void testGet(){
        redisTemplate.boundValueOps("name").get();
    }

    @Test
    public void testService(){
        System.out.println(userService.findByName("张三"));
    }
}
