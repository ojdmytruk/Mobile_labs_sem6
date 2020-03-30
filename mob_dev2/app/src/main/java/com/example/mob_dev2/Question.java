package com.example.mob_dev2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Question extends Fragment {
    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.fragment_question, container, false);
        Button button =  view.findViewById(R.id.button_ok);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                CheckBox cbox_lattitude = view.findViewById(R.id.cbox_lattitude);
                CheckBox cbox_hight = view.findViewById(R.id.cbox_hight);
                CheckBox cbox_angle = view.findViewById(R.id.cbox_angle);
                CheckBox cbox_pressure = view.findViewById(R.id.cbox_pressure);

                String result = "Температура: \n";
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