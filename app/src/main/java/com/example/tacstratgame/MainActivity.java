/*
  Class will be tested with an instrumented test.
 */

package com.example.tacstratgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    MainActivity ref;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ref = this;
        ref.buildMainMenu();
    }

    public void buildMainMenu() {
        // Sets display to menu on initialization
        setContentView(R.layout.activity_main);

        // Initialize start button
        start = findViewById(R.id.button);

        // Listener for start button to switch to GameView and locks game to fullscreen
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView((R.layout.level_selector));
                //Initialize level buttons
                Button load = findViewById(R.id.button14);
                load.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Initialize edit text
                        final EditText mEdit = findViewById(R.id.editText3);
                        String level = mEdit.getText().toString();
                        if (!level.isEmpty()) {
                            int levelActual = Integer.parseInt(level);
                            if (levelActual <= 5) {
                                setContentView(new Game(v.getContext(), ref, levelActual));
                            } else {
                                levelActual = 5;
                                setContentView(new Game(v.getContext(), ref, levelActual));
                            }
                        } else {
                            int levelActual = 1;
                            setContentView(new Game(v.getContext(), ref, levelActual));
                        }
                    }
                });

                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

            }
        });
    }

    public void onGameEnd( int team ) {
        if ( team == 1 ) {
            setContentView(R.layout.team1victory);
            Button exit = findViewById( R.id.exit1 );
            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buildMainMenu();                }
            });
        } else {
            setContentView(R.layout.team2victory);
            Button exit = findViewById( R.id.exit2 );
            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buildMainMenu();
                }
            });
        }
    }
}