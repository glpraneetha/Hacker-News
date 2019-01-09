package com.example.praneethagangisetty.fragment_ex;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionsFragment extends Fragment {
    String fragment_text;
    TextView tv;

    public OptionsFragment() {

    }

    @SuppressLint("ValidFragment")
    public OptionsFragment(String s) {
        // Required empty public constructor
        fragment_text = s;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_options, container, false);
        getActivity().setTitle(fragment_text);
        tv = view.findViewById(R.id.fragment_tv);
        tv.setText(fragment_text);
        return view;
    }

}
