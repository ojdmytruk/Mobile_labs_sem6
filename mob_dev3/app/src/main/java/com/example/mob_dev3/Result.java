package com.example.mob_dev3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Result  extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        return view;
    }

    public void setText(String item)
    {
        TextView view =  getView().findViewById(R.id.result);
        view.setText(item);
    }
}
