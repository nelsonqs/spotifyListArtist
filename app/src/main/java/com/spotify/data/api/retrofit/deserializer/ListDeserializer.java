package com.spotify.data.api.retrofit.deserializer;

import com.google.gson.JsonDeserializer;
import java.util.List;

/**
 * Created by tecnosim on 1/15/2018.
 */
interface ListDeserializer<T> extends JsonDeserializer<List<T>> {

}
