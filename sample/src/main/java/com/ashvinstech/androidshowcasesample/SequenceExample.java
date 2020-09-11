package com.ashvinstech.androidshowcasesample;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ashvinstech.androidshowcase.AndroidShowcaseSequence;
import com.ashvinstech.androidshowcase.AndroidShowcaseView;
import com.ashvinstech.androidshowcase.ShowcaseConfig;


public class SequenceExample extends AppCompatActivity implements View.OnClickListener {

    private Button mButtonOne;
    private Button mButtonTwo;
    private Button mButtonThree;

    private Button mButtonReset;

    private static final String SHOWCASE_ID = "sequence example";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sequence_example);
        mButtonOne = findViewById(R.id.btn_one);
        mButtonOne.setOnClickListener(this);

        mButtonTwo = findViewById(R.id.btn_two);
        mButtonTwo.setOnClickListener(this);

        mButtonThree = findViewById(R.id.btn_three);
        mButtonThree.setOnClickListener(this);

        mButtonReset = findViewById(R.id.btn_reset);
        mButtonReset.setOnClickListener(this);

        presentShowcaseSequence(); // one second delay
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_one || v.getId() == R.id.btn_two || v.getId() == R.id.btn_three) {

            presentShowcaseSequence();

        } else if (v.getId() == R.id.btn_reset) {

            AndroidShowcaseView.resetSingleUse(this, SHOWCASE_ID);
            Toast.makeText(this, "Showcase reset", Toast.LENGTH_SHORT).show();
        }

    }

    private void presentShowcaseSequence() {

        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(500); // half second between each showcase view

        AndroidShowcaseSequence sequence = new AndroidShowcaseSequence(this, SHOWCASE_ID);

        sequence.setOnItemShownListener(new AndroidShowcaseSequence.OnSequenceItemShownListener() {
            @Override
            public void onShow(AndroidShowcaseView itemView, int position) {
                Toast.makeText(itemView.getContext(), "Item #" + position, Toast.LENGTH_SHORT).show();
            }
        });

        sequence.setConfig(config);

        sequence.addSequenceItem(mButtonOne, "This is button one", "GOT IT");

        sequence.addSequenceItem(
                new AndroidShowcaseView.Builder(this)
                        .setSkipText("SKIP")
                        .setTarget(mButtonTwo)
                        .setDismissText("GOT IT")
                        .setContentText("This is button two")
                        .withRectangleShape(true)
                        .build()
        );

        sequence.addSequenceItem(
                new AndroidShowcaseView.Builder(this)
                        .setTarget(mButtonThree)
                        .setDismissText("GOT IT")
                        .setContentText("This is button three")
                        .withRectangleShape()
                        .build()
        );

        sequence.start();

    }

}
