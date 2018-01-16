package com.spotify.interactor;

import com.spotify.data.api.client.SpotifyService;
import com.spotify.data.model.Artist;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by tecnosim on 1/15/2018.
 */

public class ArtistsInteractor {
    private SpotifyService spotifyService;

    public ArtistsInteractor(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    public Observable<List<Artist>> searchArtist(String query) {
        return spotifyService.search(query);
    }
}
