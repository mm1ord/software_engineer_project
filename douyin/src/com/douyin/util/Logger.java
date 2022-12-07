package com.douyin.util;

/**
 * 日志打印机，通过工厂获取，权限是 default 防止在包外被直接 new 出来。
 */
public class Logger {

	private String className;
	private static long time = 0;
	private static long initTime = System.currentTimeMillis();
	public static boolean disabled = false;

	Logger(Class<?> className) {
		this.className = className.getSimpleName();
	}

	public final void DEBUG(Object str) {
		if (disabled) return;
		updateTime();
		System.out.printf("[DEBUG]\t%-20s\t | %sms -- %s\n", className, time, str);
	}

	public final void INFO(Object str) {
		if (disabled) return;
		updateTime();
		System.out.printf("[INFO]\t%-20s\t | %sms -- %s\n", className, time, str);
	}

	public final void WARN(Object str) {
		if (disabled) return;
		updateTime();
		System.out.printf("[WARN]\t%-20s\t | %sms -- %s\n", className, time, str);
	}

	public final void ERROR(Object str) {
		if (disabled) return;
		updateTime();
		System.out.printf("[ERROR]\t%-20s\t | %sms -- %s\n", className, time, str);
	}

	private final static void updateTime() {
		time = System.currentTimeMillis() - initTime;
	}
}