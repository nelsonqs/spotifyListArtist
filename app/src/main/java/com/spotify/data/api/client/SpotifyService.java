package com.spotify.data.api.client;

import com.spotify.data.model.Artist;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by tecnosim on 1/15/2018.
 */

public interface SpotifyService {
    Observable<List<Artist>> search(String query);
}
