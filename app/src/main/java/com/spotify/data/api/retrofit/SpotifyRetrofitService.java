package com.spotify.data.api.retrofit;

import com.spotify.data.api.Constants;
import com.spotify.data.model.Artist;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tecnosim on 1/15/2018.
 */

public interface SpotifyRetrofitService {

    @GET(Constants.Endpoint.ARTIST_SEARCH)
    Observable<List<Artist>> searchList(@Query(Constants.Params.QUERY_SEARCH) String artist);
}
