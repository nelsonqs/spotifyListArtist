package com.spotify.presenter;

import com.spotify.data.model.Artist;
import com.spotify.interactor.ArtistsInteractor;

import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by tecnosim on 1/15/2018.
 */

public class ArtistsPresenter  extends Presenter<ArtistsPresenter.View>{

    private ArtistsInteractor interactor;

    public ArtistsPresenter(ArtistsInteractor interactor) {
        this.interactor = interactor;
    }

    public  void onSearchArtistList (String name) {
        getView().showLoading();
        Disposable disposable = interactor.searchArtist(name).subscribe( artists -> {
            if (!artists.isEmpty() && artists.size() >0){
                getView().hideLoading();
                getView().renderArtists(artists);
            }else {
                getView().showArtistNotFoundMessage();
            }

                }, Throwable::printStackTrace);
        addDisposableObserver(disposable);
    }
    public void launchArtistDetail(Artist artist) {
        getView().launchArtistDetail(artist);
    }

    @Override public void terminate() {
        super.terminate();
        setView(null);
    }

    public interface View extends Presenter.View{
        void showLoading();
        void hideLoading();
        void showArtistNotFoundMessage();
        void renderArtists(List<Artist> artists);
        void launchArtistDetail(Artist artist);

    }

}
