package com.cdut.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * 生成token和验证token
 */
public class JWTUtil {

    //有效时间
    private static final long EXP = 6*60*60*1000;

    //jwt的签发：token：用户名、每个用户有个自己的密钥（用户的秘密）
    //token是使用用户名+用户密码来生成

    public static String sign(String username,String secret){
        Date date = new Date(System.currentTimeMillis()+EXP);//过期时间
        Algorithm algorithm = Algorithm.HMAC384(secret);
        //附带username
        return JWT.create()
                .withClaim("username",username)
                .withExpiresAt(date)
                .sign(algorithm);

    }

    //验证当前token是否有效
    public static boolean verify(String token,String username,String secret){
        Algorithm algorithm = Algorithm.HMAC384(secret);
        JWTVerifier verifier = JWT.require(algorithm)
                .withClaim("username",username).build();

        //验证:验证不通过会抛出异常
        DecodedJWT verify = verifier.verify(token);
        return true;
    }

    //从token中能够提取出用户名
    public static String getUsername(String token){
        DecodedJWT decode = JWT.decode(token);
        return decode.getClaim("username").asString();
    }

    //能够判断当前token是否过期
    public static boolean isExpire(String token){
        DecodedJWT decode = JWT.decode(token);
        return System.currentTimeMillis() >= decode.getExpiresAt().getTime();
    }

    public static void main(String[] args) {
        String token = sign("admin","e10adc3949ba59abbe56e057f20f883e");
        System.out.println(token);
    }


}
