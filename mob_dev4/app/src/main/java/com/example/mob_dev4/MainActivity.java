package com.example.mob_dev4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Intent intentAudio;
    private Intent intentVideo;
    private Intent intentDownload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void audioActivity(View view) {
        if(intentAudio == null)
            intentAudio = new Intent(this, AudioActivity.class);

        startActivity(intentAudio);

    }

    public void videoActivity(View view) {
        if(intentVideo == null)
            intentVideo = new Intent(this, VideoActivity.class);

        startActivity(intentVideo);
    }

    public void downloadActivity(View view) {
        if(intentDownload == null)
            intentDownload = new Intent(this, DownloadActivity.class);

        startActivity(intentDownload);
    }
}
