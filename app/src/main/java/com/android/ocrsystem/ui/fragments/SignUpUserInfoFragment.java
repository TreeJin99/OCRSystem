package com.android.ocrsystem.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.android.ocrsystem.R;
import com.android.ocrsystem.databinding.FragmentSignUpUserinfoBinding;
import com.android.ocrsystem.model.validator.AuthValidator;
import com.android.ocrsystem.viewmodel.AuthViewModel;

public class SignUpUserInfoFragment extends Fragment {
    private FragmentSignUpUserinfoBinding binding;

    private AuthValidator authValidator = new AuthValidator();
    private AuthViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSignUpUserinfoBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(AuthViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initButton();
    }

    private void initButton() {
        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity() != null) {
                    getActivity().onBackPressed();
                }
            }
        });

        binding.signUpNameDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.signUpNameEditText.getText().toString();
                String email = binding.signUpEmailEditText.getText().toString();
                String password = binding.signUpPasswordEditView.getText().toString();

                if (authValidator.authenticateSignUp(name, email, password)){
                    viewModel.name.setValue(name);
                    viewModel.email.setValue(email);
                    viewModel.password.setValue(password);

                    SignUpAllergyFragment signUpAllergyFragment = new SignUpAllergyFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.auth_fragment_container, signUpAllergyFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }else{
                    Toast.makeText(requireContext(), "값이 비어있거나, 비밀번호가 6자 미만 입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
