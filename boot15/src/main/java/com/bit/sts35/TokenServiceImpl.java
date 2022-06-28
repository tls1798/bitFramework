package com.bit.sts35;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

@Service
public class TokenServiceImpl {
	String secretKey="afsdklafsljksafjkldoiwrgssglsgdg;gs;lsagnsgad;ljsdf";
	
	public String createToken(String name, long limit) {
		try {
		    Algorithm algorithm = Algorithm.HMAC256(secretKey);
		    String token = JWT.create()
		    	//.withClaim("result", true)
		    	.withClaim("username", name)
		    	.withExpiresAt(new Date(limit))
		        .sign(algorithm);
		    return token;
		} catch (JWTCreationException exception){
		}
		return null;
	}
	
	public String getTokenUser(String token) {
		try {
		    Algorithm algorithm = Algorithm.HMAC256(secretKey);
		    JWTVerifier verifier = JWT.require(algorithm).build();
		    DecodedJWT jwt = verifier.verify(token);
		    return jwt.getClaim("username").toString();
		} catch (JWTVerificationException exception){
		}
		return "err";
	}
	
}
