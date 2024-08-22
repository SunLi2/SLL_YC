package com.zsc.wxapp.utils;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

/**
 * @author aqi
 * DateTime: 2020/11/9 3:27 下午
 * Description: JWT工具类
 */
public class JwtUtils {

    /**
     * 设置Token过期时间，时间为一天
     */
    public static final long EXPIRE = 1000 * 60 * 60 * 24;

    /**
     * 秘钥
     */
    public static final String APP_SECRET = "ukc8BDaRigUDaY6pZffWhs2jZWLPHO";

    public static String createJwt(String secretKey, long ttlMills, Map<String, Object> claims){
        //设置加密方式，对密钥进行加密
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //生成JWT的的时间
        long expMails = System.currentTimeMillis() + ttlMills;
        Date exp = new Date(expMails);

        JwtBuilder builder = Jwts.builder()
                //设置JWT的头信息
                .setClaims(claims)
                //设置JWT的签名
                .signWith(signatureAlgorithm, secretKey.getBytes(StandardCharsets.UTF_8))
                //设置过期时间
                .setExpiration(exp);

        return builder.compact();
    }

    /**
     * 生成Token字符串(Token组成:头+荷载+签名)
     * @param userid 用户id
     * @param phone 用户
     * @return Token字符串
     */
    public static String getJwtToken(String userid, String phone){

        return Jwts.builder()
                // 设置JWT的头信息
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                // 设置Token过期时间
                // 主题
                .setSubject("jlt_wxapp_login")
                // 签发时间
                .setIssuedAt(new Date())
                // 过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))

                // 设置Token主体部分
                .claim("userid", userid)
                .claim("phone", phone)
                // 签名算法,秘钥

                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
    }

    /**
     * 判断token是否存在与有效
     * @param jwtToken token
     * @return 判断token是否存在与有效
     */
    public static boolean checkToken(String jwtToken) {
        if(StringUtils.isEmpty(jwtToken)) {
            return false;
        }
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据token获取会员id
     * @param  request
     * @return 会员id
     */
    public static String getMemberIdByJwtToken(String jwtToken, String Member) {
//        String jwtToken = request.getHeader("token");
        if(StringUtils.isEmpty(jwtToken)) {
            return "";
        }
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
//        return (String)claims.get("userid");
        return (String)claims.get(Member);
    }

//    public static void main(String[] args) {
//        String token = getJwtToken("123123", "asdasdasd");
//        System.out.println("Generated JWT Token: " + token);
//    }
}


