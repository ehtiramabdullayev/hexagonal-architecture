package org.example.adapter.common;

import com.google.gson.Gson;

public class JsonParser {
    public <T> T fromJSonToPOJO(String json, Class<T> classType) {
        return new Gson().fromJson(json, classType);
    }
    public String toJsonPOJO(Object data) {
        return new Gson().toJson(data);
    }
}
