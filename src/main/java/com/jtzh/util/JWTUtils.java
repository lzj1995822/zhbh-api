     package com.jtzh.util;
     
     import com.auth0.jwt.JWT;
     import com.auth0.jwt.JWTCreator.Builder;
     import com.auth0.jwt.JWTVerifier;
     import com.auth0.jwt.algorithms.Algorithm;
     import com.auth0.jwt.interfaces.DecodedJWT;
     import com.auth0.jwt.interfaces.Verification;
     import java.io.UnsupportedEncodingException;
     import java.util.Calendar;
     import java.util.Date;
     import java.util.HashMap;
     import java.util.Map;
     
     
     
     
     
     
     
     public class JWTUtils
     {
       private static final String SECRET = "msmis_gbt";
       
       public static String createToken(Long userid, String username)
         throws UnsupportedEncodingException
       {
      Date iatDate = new Date();
         
      Calendar nowTime = Calendar.getInstance();
      nowTime.add(5, 1);
      Date expiresDate = nowTime.getTime();
         
      Map map = new HashMap();
      map.put("alg", "HS256");
      map.put("typ", "JWT");
         
     
     
     
     
     
      String token = JWT.create().withHeader(map).withClaim("userid", userid).withClaim("username", username).withExpiresAt(expiresDate).withIssuedAt(iatDate).sign(Algorithm.HMAC256("msmis_gbt"));
         
      return token;
       }
       
     
     
     
     
     
       public static Map verifyToken(String token)
         throws UnsupportedEncodingException
       {
      JWTVerifier verifier = JWT.require(Algorithm.HMAC256("msmis_gbt")).build();
      DecodedJWT jwt = null;
         try {
         jwt = verifier.verify(token);
        return jwt.getClaims();
        } catch (Exception e) {}
       return null;
       }
     }
