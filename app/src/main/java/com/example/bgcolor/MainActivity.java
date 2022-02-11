package com.example.bgcolor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout layout;
    AppCompatButton bgSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bgSwitch = findViewById(R.id.bgSwitch);
        layout = findViewById(R.id.layout);

        ColorViewModel model = new ViewModelProvider(this).get(ColorViewModel.class);

        model.currentState.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    layout.setBackgroundColor(getColor(R.color.black));
                    bgSwitch.setText("Black Color");
                } else {
                    layout.setBackgroundColor(getColor(R.color.teal_200));
                    bgSwitch.setText("Teal Color");
                }
            }
        });

        bgSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (model.currentState.getValue() == null) {
                    model.currentState.setValue(true);
                }
                model.currentState.setValue(!model.currentState.getValue());
            }
        });
    }
}
