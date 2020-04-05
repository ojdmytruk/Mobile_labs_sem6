package com.example.mob_dev3;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

public class MainActivity extends FragmentActivity implements Question.OnFragmentInteractionListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(String link)
    {
        Result fragment = (Result) getSupportFragmentManager().findFragmentById(R.id.resultFragment);
        if (fragment != null && fragment.isInLayout()) {
            fragment.setText(link);
        }
    }
}
