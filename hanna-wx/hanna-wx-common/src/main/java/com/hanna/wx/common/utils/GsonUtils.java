package com.hanna.wx.common.utils;

import java.io.IOException;
import java.lang.reflect.Type;

import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/**
 * gson工具类
 * @author wuxj
 *
 */
public class GsonUtils {

    private static Gson gson;

    private static Gson getInstants() {
        if (null == gson) {
            gson = new GsonBuilder().serializeNulls().registerTypeAdapter(String.class, new StringConverter()).setDateFormat("yyyy-MM-dd").create();
        }
        return gson;
    }

    /**
     * 对象转换成json
     * 
     * @param bean
     * @param type
     * @return
     */
    public static String toJson(Object bean, Type type) {
        Gson gson = getInstants();
        return gson.toJson(bean, type);
    }

    /**
     * 转换成json对象
     * @Title: fromJson
     * @param <T>
     * @param json
     * @param type
     * @return T 返回类型
     * @throws：
     */
    public static <T> T fromJson(String json, Type type) {
        Gson gson = getInstants();
        return gson.fromJson(json, type);
    }

    /**
     *  转换成json对象
     * @Title: fromJson
     * @param <T>
     * @param json
     * @param classOfT
     * @return T 返回类型
     * @throws：
     */
    public static <T> T fromJson(String json, Class<T> classOfT) {
        Gson gson = getInstants();
        return gson.fromJson(json, classOfT);
    }

    /**
     * Null Adapter
     * 
     * @author melodymao
     * @version $Id: GsonUtils.java, v 0.1 2015年6月18日 上午11:10:32  Exp $
     */
    @SuppressWarnings("unchecked")
    private static class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {
        @SuppressWarnings("hiding")
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

            Class<T> rawType = (Class<T>) type.getRawType();
            if (rawType != String.class) {
                return null;
            }
            return (TypeAdapter<T>) new StringAdapter();
        }
    }

    private static class StringAdapter extends TypeAdapter<String> {
        public String read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return "";
            }
            return reader.nextString();
        }

        public void write(JsonWriter writer, String value) throws IOException {
            if (value == null) {
                writer.nullValue();
                return;
            }
            writer.value(value);
        }
    }

    private static class StringConverter implements JsonSerializer<String>, JsonDeserializer<String> {
        public JsonElement serialize(String src, Type typeOfSrc, JsonSerializationContext context) {
            if (StringUtils.isEmpty(src)) {
                return new JsonPrimitive("");
            } else {
                return new JsonPrimitive(src.toString());
            }
        }

        public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                                                                                                     throws JsonParseException {
            return json.getAsJsonPrimitive().getAsString();
        }
    }
    
}
