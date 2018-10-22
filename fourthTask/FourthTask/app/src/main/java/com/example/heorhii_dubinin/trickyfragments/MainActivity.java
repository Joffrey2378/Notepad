package com.example.heorhii_dubinin.trickyfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import static com.example.heorhii_dubinin.trickyfragments.FirstFrag.FRAGMENT2_BLUE;
import static com.example.heorhii_dubinin.trickyfragments.FirstFrag.FRAGMENT2_ORANGE;
import static com.example.heorhii_dubinin.trickyfragments.FirstFrag.FRAGMENT3_GREEN;
import static com.example.heorhii_dubinin.trickyfragments.FirstFrag.FRAGMENT3_PINK;

public class MainActivity extends AppCompatActivity {

    public Fragment secondFrag;
    public Fragment thirdFrag;
    boolean isColorClicked = false;
    boolean isSwapClicked = false;
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        secondFrag = BackgroundFrag.newInstance("fr2", FRAGMENT2_ORANGE);
        thirdFrag = BackgroundFrag.newInstance("fr3", FRAGMENT3_GREEN);

        transaction.add(R.id.placeholder_for_fragment_two, secondFrag);
        transaction.add(R.id.placeholder_for_fragment_three, thirdFrag);
        transaction.commit();
    }

    public void swapColor() {
        getSupportFragmentManager()
                .findFragmentById(R.id.placeholder_for_fragment_three)
                .getView()
                .setBackgroundColor(isColorClicked ? FRAGMENT3_GREEN : FRAGMENT3_PINK);
        getSupportFragmentManager()
                .findFragmentById(R.id.placeholder_for_fragment_two)
                .getView()
                .setBackgroundColor(isColorClicked ? FRAGMENT2_ORANGE : FRAGMENT2_BLUE);
        isColorClicked = !isColorClicked;
    }

    public void swapFragments() {
        getSupportFragmentManager().beginTransaction()
                .remove(secondFrag)
                .remove(thirdFrag)
                .commit();
        getSupportFragmentManager().executePendingTransactions();
        if (!isSwapClicked) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.placeholder_for_fragment_two, thirdFrag)
                    .replace(R.id.placeholder_for_fragment_three, secondFrag)
                    .commit();
            Toast.makeText(this, "first line " + isSwapClicked, Toast.LENGTH_SHORT).show();
            isSwapClicked = true;
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.placeholder_for_fragment_three, thirdFrag).
                    replace(R.id.placeholder_for_fragment_two, secondFrag).commit();
            Toast.makeText(this, "second line " + isSwapClicked, Toast.LENGTH_SHORT).show();
            isSwapClicked = false;
        }
    }
}

