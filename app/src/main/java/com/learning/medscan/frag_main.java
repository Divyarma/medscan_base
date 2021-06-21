package com.learning.medscan;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class frag_main extends Fragment{

    Button b,e,c;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout=inflater.inflate(R.layout.fragment_frag_main, container, false);
        b= layout.findViewById(R.id.b_b);
        e= layout.findViewById(R.id.b_e);
        c= layout.findViewById(R.id.b_c);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCk(b.getTag().toString());
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCk(e.getTag().toString());
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCk(c.getTag().toString());
            }
        });
        return layout;
    }

    public void onCk(String tagg) {
        Intent t=new Intent(getContext(),Scan_act.class);
        t.putExtra("Tag",tagg);
        startActivity(t);
    }
}