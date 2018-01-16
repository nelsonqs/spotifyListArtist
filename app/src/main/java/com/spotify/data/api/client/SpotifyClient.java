package com.spotify.data.api.client;

import com.spotify.data.api.retrofit.SpotifyRetrofitClient;
import com.spotify.data.model.Artist;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tecnosim on 1/15/2018.
 */

public class SpotifyClient extends SpotifyRetrofitClient implements SpotifyService {
    @Override
    public Observable<List<Artist>> search(String query) {
        return getSpotifyService().searchList(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
