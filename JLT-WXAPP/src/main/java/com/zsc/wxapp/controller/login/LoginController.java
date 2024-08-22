package com.zsc.wxapp.controller.login;

import com.zsc.wxapp.entity.Result;
import com.zsc.wxapp.entity.Userinfo;
import com.zsc.wxapp.entity.dto.UserLoginDTO;
import com.zsc.wxapp.entity.vo.UserLoginVO;
import com.zsc.wxapp.properties.JwtProperties;
import com.zsc.wxapp.services.UserinfoService;
import com.zsc.wxapp.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/wxapp")
@Api(tags = "用户登录")
@Slf4j
public class LoginController {

    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private UserinfoService userinfoService;

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("用户登录：{}", userLoginDTO);

        Userinfo user = userinfoService.login(userLoginDTO);

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getUserId());
        String token = JwtUtils.createJwt(jwtProperties.getSecretKey(), jwtProperties.getTtl(), claims);

        UserLoginVO userLoginVO = UserLoginVO.builder()
                .userId(user.getUserId())
                .phone(user.getPhone())
                .token(token)
                .build();

        return Result.success(userLoginVO);
    }
}
