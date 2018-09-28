package com.example.android.musicplayerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PlayingListActivity extends AppCompatActivity {

    public static final String KEY_SONG = "KEY_SONG";
    public static final String KEY_ARTIST = "KEY_ARTIST";
    public static final String KEY_ALBUM = "KEY_ALBUM";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_list);


        // Create a list of words
        ArrayList<Song> words = new ArrayList<Song>();


        words.add(new Song(getString(R.string.artist_1), getString(R.string.song_1)));
        words.add(new Song(getString(R.string.artist_2), getString(R.string.song_2)));
        words.add(new Song(getString(R.string.artist_3), getString(R.string.song_3)));
        words.add(new Song(getString(R.string.artist_4), getString(R.string.song_4)));
        words.add(new Song(getString(R.string.artist_5), getString(R.string.song_5)));
        words.add(new Song(getString(R.string.artist_6), getString(R.string.song_6)));
        words.add(new Song(getString(R.string.artist_7), getString(R.string.song_7)));
        words.add(new Song(getString(R.string.artist_8), getString(R.string.song_8)));
        words.add(new Song(getString(R.string.artist_9), getString(R.string.song_9)));
        words.add(new Song(getString(R.string.artist_10), getString(R.string.song_10)));

        final SongAdapter adapter = new SongAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);


        // When listView item is clicked, item data is sent to new activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song item = (Song) adapter.getItem(position);
                Intent nowPlaying = new Intent(getApplicationContext(), NowPlayingActivity.class);
                nowPlaying.putExtra(KEY_SONG, item.getMiwokTranslation());
                nowPlaying.putExtra(KEY_ARTIST, item.getDefaultTranslation());
                startActivity(nowPlaying);
            }
        });

    }
}
