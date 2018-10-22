package com.example.heorhii_dubinin.trickyfragments;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BackgroundFrag extends Fragment {
    public static final String KEY_TEXT = "KEY_TEXT";
    public static final String KEY_COLOR = "KEY_COLOR";

    public static BackgroundFrag newInstance(String text, int color) {
        BackgroundFrag backgroundFrag = new BackgroundFrag();
        Bundle attributes = new Bundle();
        attributes.putString(KEY_TEXT, text);
        attributes.putInt(KEY_COLOR, color);
        backgroundFrag.setArguments(attributes);
        return backgroundFrag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.background_fragment_apearence, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        TextView textView = view.findViewById(R.id.textV_in_fragment);
        textView.setText(arguments.getString(KEY_TEXT));
        View backgroundView = view.findViewById(R.id.container_view);
        int backgroundColor = arguments.getInt(KEY_COLOR);
        backgroundView.setBackgroundColor(backgroundColor);
    }

    @Override
    public void onPause() {
        super.onPause();
        Bundle arguments = this.getArguments();
        arguments.putInt(KEY_COLOR, ((ColorDrawable) this.getView().getBackground()).getColor());
    }
}
