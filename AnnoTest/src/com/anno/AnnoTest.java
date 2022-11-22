package com.anno;

import java.lang.reflect.Method;

public class AnnoTest {

	@MyAnnotation(count = 10)
	public static void print() {
		System.out.println("프린트 입니다.");
	}

	public static void main(String[] args) throws Exception {

		// AnnoTest at = new AnnoTest();
		// at.getClass();

		Method m = AnnoTest.class.getMethod("print");

		// 메소드가 해당 어노테이션의 클래스를 소유중인지 확인함

		if (m.isAnnotationPresent(MyAnnotation.class)) {
			MyAnnotation method = m.getAnnotation(MyAnnotation.class);
			for(int i =0; i < method.count(); i++) {
				print();
			}
		} else {
			print();
		}
	}

}
