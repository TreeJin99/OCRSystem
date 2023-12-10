package com.android.ocrsystem.viewmodel;

import android.os.AsyncTask;

import java.util.concurrent.CompletableFuture;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AuthViewModel extends ViewModel {
    // 인증 상태 관찰자
    private MutableLiveData<Boolean> isAuthenticated = new MutableLiveData<>();

    // 사용자 입력 필드
    private MutableLiveData<String> email = new MutableLiveData<>();
    private MutableLiveData<String> password = new MutableLiveData<>();

    // 생성자
    public AuthViewModel() {
        isAuthenticated.setValue(false);
    }

    // 사용자 인증을 수행하는 메서드
    public void authenticateUser() {
        // 사용자 입력 유효성 검사 (여기에 더 많은 유효성 검사 로직을 추가할 수 있음)

        String enteredEmail = email.getValue();
        String enteredPassword = password.getValue();

        if (isValidEmail(enteredEmail) && isValidPassword(enteredPassword)) {
            // 인증 로직 수행 (예: 백엔드와 통신하여 자격 증명 확인)
            // 단순성을 위해 인증이 성공했다고 가정
            isAuthenticated.setValue(true);
        } else {
            // 인증 실패
            isAuthenticated.setValue(false);
        }
    }

    // 입력된 이메일이 유효한지 확인하는 메서드
    private boolean isValidEmail(String email) {
        // 여기에 이메일 유효성 검사 로직 추가 (예: 정규 표현식 사용)
        return email != null && !email.isEmpty();
    }

    // 입력된 비밀번호가 유효한지 확인하는 메서드
    private boolean isValidPassword(String password) {
        // 여기에 비밀번호 유효성 검사 로직 추가
        return password != null && password.length() >= 6; // 예: 최소 6자리 필요
    }


    // LiveData의 Getter
    public MutableLiveData<Boolean> getIsAuthenticated() {
        return isAuthenticated;
    }

    // email LiveData의 Getter
    public MutableLiveData<String> getEmail() {
        return email;
    }

    // email LiveData의 Setter
    public void setEmail(String emailValue) {
        email.setValue(emailValue);
    }

    // password LiveData의 Getter
    public MutableLiveData<String> getPassword() {
        return password;
    }

    // password LiveData의 Setter
    public void setPassword(String passwordValue) {
        password.setValue(passwordValue);
    }

}
