package com.spotify.data.api.retrofit.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.spotify.data.api.Constants;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by tecnosim on 1/15/2018.
 */

public class TracksDeserializer<T> implements ListDeserializer<T> {
    @Override
    public List<T> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement trackJsonArray = json.getAsJsonObject().get(Constants.Deserializer.TRACKS);
        return new Gson().fromJson(trackJsonArray,typeOfT);
    }
}
