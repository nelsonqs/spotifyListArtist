package com.spotify.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static com.spotify.data.api.Constants.Serialized.IMAGES;
import static com.spotify.data.api.Constants.Serialized.NAME;

/**
 * Created by tecnosim on 1/15/2018.
 */

public class Album {
    @SerializedName(NAME) public String albumName;
    @SerializedName(IMAGES) public List<ArtistImages> trackImages;
}
