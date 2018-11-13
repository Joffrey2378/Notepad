package com.example.heorhii_dubinin.trickyfragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FirstFrag extends Fragment implements View.OnClickListener {

    public static final int FRAGMENT2_ORANGE = 0xffff8800;
    public static final int FRAGMENT2_BLUE = 0xff00ddff;
    public static final int FRAGMENT3_GREEN = 0xffc6ff00;
    public static final int FRAGMENT3_PINK = 0xffff4081;

    private Button btnColor;
    private Button btnSwap;

    private SwapBehavior swapBehavior;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first_farag, container, false);
        btnColor = view.findViewById(R.id.btn_color);
        btnSwap = view.findViewById(R.id.btn_swap);

        btnColor.setOnClickListener(this);
        btnSwap.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SwapBehavior) {
            swapBehavior = (SwapBehavior) getActivity();
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_color:
                swapBehavior.swapColor();
                break;
            case R.id.btn_swap:
                swapBehavior.swapFragments();
                break;
        }
    }
}
