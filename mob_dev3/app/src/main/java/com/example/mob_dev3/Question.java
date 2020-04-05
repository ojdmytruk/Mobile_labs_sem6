package com.example.mob_dev3;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.fragment.app.Fragment;

public class Question extends Fragment {
    private OnFragmentInteractionListener mListener;
    Activity activity;
    DBhelper db_results;

    @Override
    public void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        db_results = new DBhelper(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.fragment_question, container, false);
        Button button_ok =  view.findViewById(R.id.button_ok);
        Button button_open = view.findViewById(R.id.button_open);
        final SQLiteDatabase database = db_results.getWritableDatabase();
        final ContentValues contentValues = new ContentValues();


        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cbox_lattitude = view.findViewById(R.id.cbox_lattitude);
                CheckBox cbox_hight = view.findViewById(R.id.cbox_hight);
                CheckBox cbox_angle = view.findViewById(R.id.cbox_angle);
                CheckBox cbox_pressure = view.findViewById(R.id.cbox_pressure);

                String result = "";
                if (!(cbox_angle.isChecked()) && (!cbox_lattitude.isChecked())
                        && (!cbox_hight.isChecked()) && (!cbox_pressure.isChecked()))
                    result += "не обрано\n";
                if (cbox_pressure.isChecked())
                    result += cbox_pressure.getText() + "\n";
                if (cbox_hight.isChecked())
                    result += cbox_hight.getText() + "\n";
                if (cbox_lattitude.isChecked())
                    result += cbox_lattitude.getText() + "\n";
                if (cbox_angle.isChecked())
                    result += cbox_angle.getText() + "\n";
                updateTextBox(result);
                contentValues.put(db_results.KEY_ANSWER, result);
                database.insert(db_results.TABLE_RESULTS, null, contentValues);
            }
        });

        button_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ShowDbActivity.class);
                startActivity(intent);
            }
        });

        return view;

    }

    interface OnFragmentInteractionListener
    {
        void onFragmentInteraction(String link);
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString());
        }
    }

    private void updateTextBox(String result)
    {
        mListener.onFragmentInteraction(result);
    }
}
