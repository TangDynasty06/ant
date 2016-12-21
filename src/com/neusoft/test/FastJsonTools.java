package com.neusoft.test;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
/**
 * json工具类
 * @author songbin
 *
 */
public class FastJsonTools {

	/**
	 * 用fastjson 将json字符串解析为一个 JavaBean
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> T stringToJavaBean(String jsonString, Class<T> cls) {
		T t = null;
		try {
			t = JSON.parseObject(jsonString, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	public static <T> T JSONObjectToJavaBean(JSONObject jsonobj, Class<T> cls) {
		T t = null;
		try {
			t = JSON.toJavaObject(jsonobj, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	/**
	 * 用fastjson 将json字符串解析为一个 JavaBean
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static JSONObject stringToJSONObject(String jsonString) {
		JSONObject t = null;
		try {
			t = JSON.parseObject(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	public static<T> JSONObject javaBeanToJSONObject(T javaBean) {
		JSONObject t = null;
		try {
			t= (JSONObject) JSONObject.toJSON(javaBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
	/**
	 * 用fastjson 将json字符串 解析成为一个 List<JavaBean> 及 List<String>
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> List<T> stringToListJavaBean(String jsonString, Class<T> cls) {
		List<T> list = null;
		try {
			list = JSON.parseArray(jsonString, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 用fastjson 将jsonString 解析成 List<Map<String,Object>>
	 * 
	 * @param jsonString
	 * @return
	 */
	public static List<Map<String, Object>> stringToListMapJavaBean(String jsonString) {
		List<Map<String, Object>> list = null;
		try {
			list = JSON.parseObject(jsonString,
					new TypeReference<List<Map<String, Object>>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static String javaBeanToString(Object object){
		String jsonString = null;
		try {
			jsonString = JSON.toJSONString(object,SerializerFeature.DisableCircularReferenceDetect);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonString;
	}
	public static String javaBeanToStringWithClass(Object object){
		String jsonString = null;
		try {
			jsonString = JSON.toJSONString(object,SerializerFeature.WriteClassName,SerializerFeature.DisableCircularReferenceDetect);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonString;
	}
	public static String javaBeanToStringExclude(Object object,String... filename){
		String jsonString = null;
		try {
			SimplePropertyPreFilter filter = new SimplePropertyPreFilter(object.getClass());
			for(String s:filename){
				filter.getExcludes().add(s);
			}
			jsonString = JSON.toJSONString(object,filter,SerializerFeature.DisableCircularReferenceDetect);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonString;
	}
	public static String javaBeanToString2(Object object){
		String jsonString = null;
		try {
			jsonString = JSON.toJSONString(object,SerializerFeature.DisableCheckSpecialChar,SerializerFeature.DisableCircularReferenceDetect);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonString;
	}
}
