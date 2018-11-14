package com.example.heorhii_dubinin.trickyfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import static com.example.heorhii_dubinin.trickyfragments.FirstFrag.FRAGMENT2_BLUE;
import static com.example.heorhii_dubinin.trickyfragments.FirstFrag.FRAGMENT2_ORANGE;
import static com.example.heorhii_dubinin.trickyfragments.FirstFrag.FRAGMENT3_GREEN;
import static com.example.heorhii_dubinin.trickyfragments.FirstFrag.FRAGMENT3_PINK;

public class MainActivity extends AppCompatActivity implements SwapBehavior {

    private BackgroundFrag secondFrag;
    private BackgroundFrag thirdFrag;
    private boolean isColorClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        secondFrag = BackgroundFrag.newInstance("fr2", FRAGMENT2_ORANGE);
        thirdFrag = BackgroundFrag.newInstance("fr3", FRAGMENT3_GREEN);

        getSupportFragmentManager().beginTransaction().add(R.id.placeholder_for_fragment_two, secondFrag)
                .add(R.id.placeholder_for_fragment_three, thirdFrag).commit();
    }

    public void swapColor() {
        secondFrag = (BackgroundFrag) getSupportFragmentManager().findFragmentById(R.id.placeholder_for_fragment_two);
        thirdFrag = (BackgroundFrag) getSupportFragmentManager().findFragmentById(R.id.placeholder_for_fragment_three);
        secondFrag.colors(isColorClicked ? FRAGMENT2_ORANGE : FRAGMENT2_BLUE);
        thirdFrag.colors(isColorClicked ? FRAGMENT3_GREEN : FRAGMENT3_PINK);
        isColorClicked = !isColorClicked;
    }

    public void swapFragments() {
        Fragment fragment2 = getSupportFragmentManager().findFragmentById(R.id.placeholder_for_fragment_two);
        Fragment fragment3 = getSupportFragmentManager().findFragmentById(R.id.placeholder_for_fragment_three);
        getSupportFragmentManager().beginTransaction()
                .remove(fragment2)
                .remove(fragment3)
                .commitNow();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.placeholder_for_fragment_two, fragment3)
                .replace(R.id.placeholder_for_fragment_three, fragment2)
                .commit();
    }
}