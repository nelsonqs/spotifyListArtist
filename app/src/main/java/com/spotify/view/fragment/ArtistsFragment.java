package com.spotify.view.fragment;

import android.app.Fragment;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.spotify.R;
import com.spotify.data.api.client.SpotifyClient;
import com.spotify.data.model.Artist;
import com.spotify.interactor.ArtistsInteractor;
import com.spotify.presenter.ArtistsPresenter;
import com.spotify.view.adapter.ArtistsAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tecnosim on 1/13/2018.
 */

public class ArtistsFragment extends Fragment
        implements ArtistsPresenter.View, SearchView.OnQueryTextListener{
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.rv_artists) RecyclerView rv_artist;
    @BindView(R.id.pv_artists) ProgressBar pv_artists;
    @BindView(R.id.iv_artists) ImageView iv_artists;
    @BindView(R.id.txt_line_artists) TextView txt_line_artists;
    @BindView(R.id.txt_subline_artists) TextView txt_sub_line_artists;

    private ArtistsPresenter artistsPresenter;
    public ArtistsFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        artistsPresenter = new ArtistsPresenter(new ArtistsInteractor(new SpotifyClient()));
        artistsPresenter.setView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_artists, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setupToolbar();
        setupRecyclerView();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
      inflater.inflate(R.menu.menu_music,menu);
      setupSearchView(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override public boolean onQueryTextSubmit(String query) {
        artistsPresenter.onSearchArtistList(query);
        return true;
    }

    @Override public boolean onQueryTextChange(String newText) {
        return true;
    }

    @Override
    public void onDestroy() {
        artistsPresenter.terminate();
        super.onDestroy();
    }

    @Override public Context getContext() {
        return getActivity();
    }

    @Override
    public void showLoading() {
        pv_artists.setVisibility(View.VISIBLE);
        iv_artists.setVisibility(View.GONE);
        txt_line_artists.setVisibility(View.GONE);
        txt_sub_line_artists.setVisibility(View.GONE);
        rv_artist.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
     pv_artists.setVisibility(View.GONE);
     rv_artist.setVisibility(View.VISIBLE);
    }

    @Override
    public void showArtistNotFoundMessage() {
        pv_artists.setVisibility(View.GONE);
        txt_line_artists.setVisibility(View.VISIBLE);
        iv_artists.setVisibility(View.VISIBLE);
        txt_line_artists.setText(getString(R.string.error_artist_not_found));
        iv_artists.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.ic_not_found));
    }

    @Override
    public void renderArtists(List<Artist> artists) {
        ArtistsAdapter adapter = (ArtistsAdapter) rv_artist.getAdapter();
        adapter.setArtists(artists);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void launchArtistDetail(Artist artist) {

    }


    private void setupSearchView(Menu menu) {
        SearchManager searchManager =  (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setMaxWidth(toolbar.getWidth());
        searchView.setOnQueryTextListener(this);
    }


    private void setupToolbar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_action_navigation_menu);
        }
    }

    private void setupRecyclerView() {
        ArtistsAdapter adapter = new ArtistsAdapter();
        adapter.setItemClickListener((Artist artist, int position) -> artistsPresenter.launchArtistDetail(artist));
        rv_artist.setAdapter(adapter);
    }

    @Override
    public Context context() {
        return null;
    }


}
