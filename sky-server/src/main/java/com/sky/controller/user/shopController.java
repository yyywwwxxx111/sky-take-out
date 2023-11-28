 package com.sky.controller.user;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("usershopController")
@Slf4j
@RequestMapping("/user/shop")
@Api("店铺相关接口")
public class shopController {
    public static final String KEY = "SHOP_STATUS";
    @Autowired
    RedisTemplate redisTemplate;


    @GetMapping("/status")
    @ApiOperation("获取店铺的营业状态")
    public Result<Integer> getStatus(){
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);
        log.info("店铺营业状态为:{}", status == 1 ? "营业中" : "打样中");
        return Result.success(status);
    }


}
