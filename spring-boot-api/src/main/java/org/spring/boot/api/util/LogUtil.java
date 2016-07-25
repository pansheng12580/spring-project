package org.spring.boot.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志帮助类
 * @author pantheon
 * @since 2016/7/25
 */
public class LogUtil {
	
	public static Logger getInstatce(Class<?> targetClass){
		return LoggerFactory.getLogger(targetClass);
	}
	
	public static void i(Class<?> targetClass,String msg){
		getInstatce(targetClass).info(msg);
	}
	
	public static void i(Class<?> targetClass,String msg,Throwable e){
		getInstatce(targetClass).info(msg, e);
	}
	
	public static void e(Class<?> targetClass,String msg){
		getInstatce(targetClass).error(msg);
	}
	
	public static void e(Class<?> targetClass,String msg,Throwable e){
		getInstatce(targetClass).error(msg, e);
	}
	
	public static void d(Class<?> targetClass,String msg){
		getInstatce(targetClass).debug(msg);
	}
	
	public static void d(Class<?> targetClass,String msg,Throwable e){
		getInstatce(targetClass).debug(msg, e);
	}

}
