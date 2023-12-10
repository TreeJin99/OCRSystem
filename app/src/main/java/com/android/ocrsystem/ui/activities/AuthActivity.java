package com.android.ocrsystem.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.ocrsystem.R;
import com.android.ocrsystem.ui.fragments.SignInFragment;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.auth_fragment_container, new SignInFragment())
                    .commit();
        }
    }
}
