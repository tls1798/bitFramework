package com.bit.sts05.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class UserBefore {

	@Before(value = "execution(* com.bit.sts05.service.MyModule.*(..))")
	public void beforeTargetMethod(JoinPoint thisJoinPoint) {
		Class cls = thisJoinPoint.getSignature().getDeclaringType();
		String n = thisJoinPoint.getSignature().getName();
		Object[] args=thisJoinPoint.getArgs();
		System.out.println("method before run");
		System.out.println("class : "+cls);
		System.out.println("name : "+n);
		System.out.println("args : "+Arrays.toString(args));
		
	}
}
