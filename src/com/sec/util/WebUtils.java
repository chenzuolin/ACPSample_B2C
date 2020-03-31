package com.sec.util;

import java.util.Enumeration;
import java.util.UUID;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.http.HttpServletRequest;

public class WebUtils {
	/**
	* 将request对象转换成T对象
	* @param request
	* @param clazz
	* @return
	*/
	public static <T> T requestBean(HttpServletRequest request,Class<T> clazz){
	try{
	T bean = clazz.newInstance();
	Enumeration<String> e = request.getParameterNames();
	while(e.hasMoreElements()){
	String name = (String) e.nextElement();
	String value = request.getParameter(name);
	BeanUtils.setProperty(bean, name, value);
	}
	return bean;
	}catch (Exception e) {
	throw new RuntimeException(e);
	}
	}
	/**
	* 生成UUID
	* @return
	*/
	public static String makeId(){
	return UUID.randomUUID().toString();
	}

}
