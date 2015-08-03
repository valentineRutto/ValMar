package com.valentine.valmar;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;

import fr.tvbarthel.cheerleader.library.client.CheerleaderClient;
import fr.tvbarthel.cheerleader.library.client.SoundCloudComment;
import fr.tvbarthel.cheerleader.library.client.SoundCloudTrack;
import fr.tvbarthel.cheerleader.library.client.SoundCloudUser;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class MainActivity extends ActionBarActivity {
    CheerleaderClient mCheerleaderClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCheerleaderClient = new CheerleaderClient.Builder()
                .from(this)
                .with("c9c5b7a0e880b985fddc4d3d42e75ac4")
                .supports("Sage Chemutai")
                .build();

    mCheerleaderClient.getArtistProfile()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<SoundCloudUser>() {
        @Override
        public void call(SoundCloudUser soundCloudUser) {

        }
    });

        mCheerleaderClient.getArtistTracks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ArrayList<SoundCloudTrack>>() {
                    @Override
                    public void call(ArrayList<SoundCloudTrack> soundCloudTracks) {

                    }
                });

        mCheerleaderClient.getTrackComments( track)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ArrayList<SoundCloudComment>>() {
                    @Override
                    public void call(ArrayList<SoundCloudComment> soundCloudComments) {

                    }
                });
            }
}