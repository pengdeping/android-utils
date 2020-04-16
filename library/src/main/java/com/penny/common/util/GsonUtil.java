package com.penny.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GsonUtil {
  private static Gson gson = null;

  static {
    //当使用GsonBuilder方式时属性为空的时候输出来的json字符串是有键值key的,显示形式是"key":null，而直接new出来的就没有"key":null的
    gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
  }

  private GsonUtil() {
  }

  /**
   * 将对象转成json格式
   *
   * @return String
   */
  public static String gsonString(Object object) {
    String gsonString = null;
    if (gson != null) {
      gsonString = gson.toJson(object);
    }
    return gsonString;
  }

  /**
   * 将json转成特定的cls的对象， 一般的对象使用该方法
   */
  public static <T> T gsonToBean(String gsonString, Class<T> cls) {
    T t = null;
    if (gson != null) {
      t = gson.fromJson(gsonString, cls);
    }
    return t;
  }

  /**
   * 将json转成特定的cls的对象，泛型的对象传入时使用这个方法
   */
  public static <T> T gsonToBean(String gsonString, Type cls) {
    T t = null;
    if (gson != null) {
      t = gson.fromJson(gsonString, cls);
    }
    return t;
  }


  /**
   * json字符串转成list
   */
  public static <T> List<T> gsonToList(String gsonString, Class<T> cls) {
    List<T> list = new ArrayList<>();
    try {
      if (gson != null) {
        JsonArray arry = new JsonParser().parse(gsonString).getAsJsonArray();
        for (JsonElement jsonElement : arry) {
          list.add(gson.fromJson(jsonElement, cls));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  /**
   * json字符串转成list中有map的
   */
  public static <T> List<Map<String, T>> gsonToListMaps(String gsonString) {
    List<Map<String, T>> list = null;
    if (gson != null) {
      list = gson.fromJson(gsonString,
          new TypeToken<List<Map<String, T>>>() {
          }.getType());
    }
    return list;
  }

  /**
   * json字符串转成map的
   */
  public static <T> Map<String, T> gsonToMaps(String gsonString) {
    Map<String, T> map = null;
    if (gson != null) {
      Type listType = new TypeToken<Map<String,List<String>>>(){}.getType();
      map = gson.fromJson(gsonString, listType);
    }
    return map;
  }
}