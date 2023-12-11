package com.android.ocrsystem.viewmodel;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.ocrsystem.model.Allergy;
import com.android.ocrsystem.model.UserInfo;
import com.android.ocrsystem.model.validator.AuthValidator;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AuthViewModel extends ViewModel {
    // 비동기
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    // 인증 상태 관찰자
    private MutableLiveData<Boolean> isAuthenticated = new MutableLiveData<>();

    private AuthValidator authValidator = new AuthValidator();

    // 사용자 입력 필드
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    private MutableLiveData<List<String>> allergies = new MutableLiveData<>();
    public void setAllergies(List<String> newAllergies) {
        allergies.setValue(newAllergies);
    }

    // 생성자
    public AuthViewModel() {
        isAuthenticated.setValue(false);
    }

    public void isSignIn(String email, String password) {
        // 사용자 입력 유효성 검사 (여기에 더 많은 유효성 검사 로직을 추가할 수 있음)

        boolean isAuthenticateSignIn = authValidator.authenticateSignIn(email, password);
        isAuthenticated.setValue(isAuthenticateSignIn);


    }

    public void isSignUp(){
        executor.submit(() -> {
            try {
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }


    public MutableLiveData<Boolean> getIsAuthenticated() {
        return isAuthenticated;
    }

    public void setIsAuthenticated(MutableLiveData<Boolean> isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

}
