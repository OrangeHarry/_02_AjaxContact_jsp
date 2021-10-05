package com.ajaxstudy.contact.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.google.gson.Gson;

public class Converter {
	private static Gson gson;

	// static block gson 객체 초기화 (static으로 초기화 (이런 방법이 있네))
	static {
		gson = new Gson();
	}

	// 메소드
	// JAVA 객체 -> Json 문자열로 변환
	public static String convertToJson(Object obj) {
		return gson.toJson(obj); // 자바객체를 Json으로 리턴
	}

	// Json 문자열 -> (해당 클래스 타입의)JAVA 객체로 변환
	public static <T> T convertFromJson(String json, Class<T> type) {
		return gson.fromJson(json, type);
	}

	// 브라우저와 연결된 스트림에서 전송된 Json 문자열 -> (해당 클래스 타입의)JAVA 객체로 변환
	public static <T> T convertFromJsonStream(InputStream is, Class<T> type) {
		try {
			Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			return gson.fromJson(reader, type);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
