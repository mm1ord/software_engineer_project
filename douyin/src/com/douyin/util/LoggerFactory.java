package com.douyin.util;

/**
 * 日志工厂
 */
public class LoggerFactory {
	
	public static Logger getLogger(Class<?> className) {
		return new Logger(className);
	}

	public static Logger getLogger() {
		return new Logger(Object.class);
	}
}