package com.softtron.pinmaovideo.aspects;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerAspect {
	@Around(value = "within(com.softtron.pinmaovideo.controllers.*)")
	public Object around(ProceedingJoinPoint jp) {
		// 返回值
		HashMap resultMap = new HashMap();
		try {
			Object ob =jp.proceed();
			resultMap.put("code", 200);
			resultMap.put("message", "操作成功!");
			if(ob instanceof Map) {
				resultMap.putAll((Map)ob);
			}
			
		} catch (Throwable e) {
			e.printStackTrace();
			resultMap.put("code", 500);
			resultMap.put("message", "操作失败!");
		}
		return resultMap;
	}
}
