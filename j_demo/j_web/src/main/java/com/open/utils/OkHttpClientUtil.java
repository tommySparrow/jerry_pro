package com.open.utils;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

public class OkHttpClientUtil {

	public static OkHttpClient client = new OkHttpClient();

	public static void doPost(String url, String json) {
		MediaType JSON = MediaType.parse("application/json; charset=utf-8");

		RequestBody body = RequestBody.create(JSON, json);
		Request request = new Request.Builder().url(url).post(body).build();
		try {
			Response response = client.newCall(request).execute();
			System.out.println(response.body().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String doGet(String url) {

		Request request = new Request.Builder().url(url).build();
		String result = null;
		try {
			result = client.newCall(request).execute().body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void doPut() {

	}

	public static void doDelete() {

	}

	public static Map doHttpPost(String url, String json) {
		MediaType JSON = MediaType.parse("application/json; charset=utf-8");

		RequestBody body = RequestBody.create(JSON, json);
		Request request = new Request.Builder().url(url).post(body).build();
		try {
			Response response = client.newCall(request).execute();
			String str = response.body().string();
			System.out.println(str);
			Map maps = (Map) JSONObject.parse(str);
			return maps;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String  doPostJson(String url, String json) {
		MediaType JSON = MediaType.parse("application/json; charset=utf-8");

		RequestBody body = RequestBody.create(JSON, json);
		Request request = new Request.Builder().url(url).post(body).build();
		try {
			Response response = client.newCall(request).execute();
			String str = response.body().string();
			System.out.println(str);

			return str;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {

		System.out.println(doGet("https://www.baidu.com/"));
	}
}
