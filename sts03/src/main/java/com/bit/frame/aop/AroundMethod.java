package com.bit.frame.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;


public class AroundMethod implements MethodInterceptor {
	Logger log = Logger.getLogger(this.getClass());
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		
//		try {
//			System.out.println("around b");
//			return invocation.proceed();			
//		} finally {
//			System.out.println("around a");			
//		}
		
		Object obj=null;
		log.debug("around b");
		try {
			obj = invocation.proceed();			
		} catch (Exception e) {
		}
		log.debug("around a");		
		return obj;
		
	}

}
