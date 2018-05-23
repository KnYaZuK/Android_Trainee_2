package com.example.knyazuk.traenee_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button minusButton;
    private Button plusButton;

    private int ladderDepth = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        textView = findViewById(R.id.text);
        minusButton = findViewById(R.id.minus);
        plusButton = findViewById(R.id.plus);

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ladderDepth > 1) {
                    ladderDepth--;
                } else {
                    Toast.makeText(MainActivity.this, "Too small value", Toast.LENGTH_SHORT)
                            .show();
                }

                textView.setText(String.format("%s", getNumberLadder(ladderDepth)));
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ladderDepth <= 10) {
                    ladderDepth++;
                } else {
                    Toast.makeText(MainActivity.this, "Too big value", Toast.LENGTH_SHORT)
                            .show();
                }

                textView.setText(String.format("%s", getNumberLadder(ladderDepth)));
            }
        });
    }

    private String getNumberLadder(int depth) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < i; j++) {
                stringBuilder.append(j);
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
