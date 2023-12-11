package com.android.ocrsystem.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.ocrsystem.R;
import com.android.ocrsystem.ui.fragments.CameraFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment_container, new CameraFragment())
                    .commit();
        }
    }
}