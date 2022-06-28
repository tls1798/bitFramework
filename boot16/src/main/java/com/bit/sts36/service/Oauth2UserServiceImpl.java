package com.bit.sts36.service;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class Oauth2UserServiceImpl extends DefaultOAuth2UserService {
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		System.out.println("oauth2 service run");
		OAuth2User user = super.loadUser(userRequest);
		System.out.println("1 : "+userRequest);
		System.out.println("2 : "+userRequest.getAccessToken());
//		sns 정보 , client id, secret id
		System.out.println("3 : "+userRequest.getClientRegistration());
//		token
		System.out.println("4 : "+userRequest.getAdditionalParameters());
//		user 객체 -> name, authorities, attributes 등..
		System.out.println("5 : "+user);
//		attributes 내부 id값, 계정 이름, 중간 이름, 프로필 사진, 이메일, 지역 등..
		System.out.println("6 : "+user.getAttributes());
		return user;
	}
}
