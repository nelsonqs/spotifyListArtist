/**
 * Copyright 2015 Erik Jhordan Rey.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.spotify.data.api;

import static com.spotify.data.api.Constants.Params.ARTIST_ID;

public class Constants {

  public static final String API_KEY = "Authorization";
  public static final String SPOTIFY_API = "https://api.spotify.com";

  //This access token shouldn't be exposed, use it like a professional developer
  public static final String ACCESS_TOKEN = "Bearer BQDFmV_S6nZDvQL1f9mksL1MZ61-MLudHhAgXrSCtC29oGAR6cVKIzjhi0sZuw5L1CGNYmxbPQH1yQilmCL_0Zhi6yz_n6bYXPahf5flySlYEwcPnpESwUei7OQUC6pDINAzmYNxle6-NLNwVLLJUSugONak4r1DAw";


  public static final class Endpoint {

    public static final String ARTIST_SEARCH = "/v1/search?type=artist";
    public static final String ARTIST_TRACKS =
        "v1/artists/{" + ARTIST_ID + "}/top-tracks?country=SE";
  }

  public static final class Params {
    public static final String QUERY_SEARCH = "q";
    public static final String ARTIST_ID = "artistId";
  }

  public static final class Serialized {

    public static final String NAME = "name";
    public static final String IMAGES = "images";
    public static final String FOLLOWERS = "followers";
    public static final String HREF = "href";
    public static final String ID = "id";
    public static final String POPULARITY = "popularity";
    public static final String HEIGHT = "height";
    public static final String URL = "url";
    public static final String WIDTH = "width";
    public static final String TOTAL = "total";
    public static final String PREVIEW_URL = "preview_url";
    public static final String TRACK_NUMBER = "track_number";
    public static final String ALBUM = "album";


  }

  public static final class Deserializer {

    public static final String ARTISTS = "artists";
    public static final String ITEMS = "items";
    public static final String TRACKS = "tracks";
  }
}
