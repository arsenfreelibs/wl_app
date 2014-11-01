package com.hackathon.workoutlogger.utils;

/**
 * Created by AAR on 11/1/14.
 */
import java.lang.reflect.Type;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;


public class Converter {

    private static Gson jsonConverter;

    static {
        jsonConverter = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                        //.registerTypeAdapter(T.class, new Adapter())
                .create();
    }

    public static String toJSON(Object o) {
        return jsonConverter.toJson(o);
    }

    public static JsonElement toJsonElement(Object obj) {
        return jsonConverter.toJsonTree(obj);
    }

    public static <T> T fromJSON(Class<T> cl, String json) {
        return jsonConverter.fromJson(json, cl);
    }

    public static <T> T fromJSON(Class<T> cl, JsonElement element) {
        return jsonConverter.fromJson(element, cl);
    }

    public static <T> Collection<T> collectionFromJSON(Class<T> tClass, String json) {
        Type collectionsType = new TypeToken<Collection<T>>() {
        }.getType();
        return jsonConverter.fromJson(json, collectionsType);
    }
}
