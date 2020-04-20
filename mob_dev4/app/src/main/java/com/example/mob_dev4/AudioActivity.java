package com.example.mob_dev4;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AudioActivity extends AppCompatActivity {

    MediaPlayer song1, song2;
    Button button_song1, button_song2, pause1, pause2, stop1, stop2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        button_song1 = findViewById(R.id.button_song1);
        button_song2 = findViewById(R.id.button_song2);
        pause1 = findViewById(R.id.pause1);
        pause2 = findViewById(R.id.pause2);
        stop1 = findViewById(R.id.stop1);
        stop2 = findViewById(R.id.stop2);

        song1 = MediaPlayer.create(this, R.raw.song1);
        song2 = MediaPlayer.create(this, R.raw.song2);

        play();
        pause();
        stop();
    }


    public void play() {
        button_song1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay(song1);
                    }
                }
        );
        button_song2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay(song2);
                    }
                }
        );
    }

    public void soundPlay(MediaPlayer sound){
        sound.start();
    }

    public void pause() {
        pause1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPause(song1);
                    }
                }
        );
        pause2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPause(song2);
                    }
                }
        );
    }

    public void soundPause(MediaPlayer sound){
        sound.pause();
    }

    public void stop(){
        stop1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundStop(song1);
                    }
                }
        );
        stop2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundStop(song2);
                    }
                }
        );
    }

    public void soundStop(MediaPlayer sound){
        sound.stop();
    }

}
