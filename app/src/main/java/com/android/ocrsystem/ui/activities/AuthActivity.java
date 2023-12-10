package com.android.ocrsystem.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.android.ocrsystem.R;
import com.android.ocrsystem.viewmodel.AuthViewModel;

public class AuthActivity extends AppCompatActivity {

    private NavController navController;
    private AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.auth_nav_host_fragment);

        navController = navHostFragment.getNavController();

        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
    }
}