package com.android.ocrsystem.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.android.ocrsystem.R;
import com.android.ocrsystem.databinding.FragmentSignInBinding;
import com.android.ocrsystem.viewmodel.AuthViewModel;

public class SignInFragment extends Fragment {

    private FragmentSignInBinding binding;
    private AuthViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_in, container, false);

        // AuthViewModel 초기화
        viewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SignInButtonEvent();
        SignUpButtonEvent();
    }

    private void SignUpButtonEvent() {
        binding.goToSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpUserInfoFragment signUpUserInfoFragment = new SignUpUserInfoFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.auth_fragment_container, signUpUserInfoFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }



    private void SignInButtonEvent() {
        // 로그인 버튼 클릭 이벤트 처리
        binding.signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 사용자의 입력을 기반으로 로그인 시도
                viewModel.authenticateUser();

                // 인증 결과를 observe하여 처리
                viewModel.getIsAuthenticated().observe(getViewLifecycleOwner(), isAuthenticated -> {
                    if (isAuthenticated) {
                        // 인증 성공
                        Toast.makeText(requireContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
                        // TODO: 로그인 성공 후 수행할 동작 추가
                    } else {
                        // 인증 실패
                        Toast.makeText(requireContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}
