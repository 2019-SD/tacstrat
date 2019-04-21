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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Sets display to menu on initialization
        setContentView(R.layout.activity_main);

        // Initialize start button
        Button start = findViewById(R.id.button);






        // Listener for start button to switch to GameView and locks game to fullscreen
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    setContentView( (R.layout.level_selector) );
                    //Initialize level buttons
                    Button load = findViewById(R.id.button14);
                    load.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //Initialize edit text
                            final EditText mEdit = findViewById(R.id.editText3);
                            String level = mEdit.getText().toString();
                            int levelActual = Integer.parseInt(level);
                            if (levelActual  <= 5) {
                                setContentView(new Game(v.getContext(), levelActual));
                            }
                        }
                    });

            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

            }
        });

    }
}
