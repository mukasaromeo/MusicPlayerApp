package com.example.android.musicplayerapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.android.musicplayerapp.PlayingListActivity.KEY_ALBUM;
import static com.example.android.musicplayerapp.PlayingListActivity.KEY_ARTIST;
import static com.example.android.musicplayerapp.PlayingListActivity.KEY_SONG;


public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        String playingSong = "";
        String playingArtist = "";
        String playingAlbum = "";

        // Gets intent and ListView item data from MainActivity
        Intent intent = getIntent();
        if (null != intent) {
            playingSong = intent.getStringExtra(KEY_SONG);
            playingArtist = intent.getStringExtra(KEY_ARTIST);
            playingAlbum = intent.getStringExtra(KEY_ALBUM);
        }

        // Sets data to appropriate TextViews
        TextView playingSongText = (TextView) findViewById(R.id.playing_song);
        playingSongText.setText(playingSong);

        TextView playingAlbumText = (TextView) findViewById(R.id.playing_album);
        playingAlbumText.setText(playingAlbum);

        TextView playingArtistText = (TextView) findViewById(R.id.playing_artist);
        playingArtistText.setText(playingArtist);

        final ImageView playButton = (ImageView) findViewById(R.id.play_button);

        playButton.setTag(1);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playButton.getTag().equals(1)) {
                    playButton.setImageResource(R.drawable.baseline_pause_black_48);
                    playButton.setTag(2);
                } else {
                    playButton.setImageResource(R.drawable.baseline_play_arrow_black_48);
                    playButton.setTag(1);
                }

            }
        });
        // End reference
    }
}
