package com.android.ocrsystem.viewmodel;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.ocrsystem.model.UserInfo;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AuthViewModel extends ViewModel {
    // 비동기
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    // 인증 상태 관찰자
    private MutableLiveData<Boolean> isAuthenticated = new MutableLiveData<>();

    // 사용자 입력 필드
    private MutableLiveData<String> name = new MutableLiveData<>();
    private MutableLiveData<String> email = new MutableLiveData<>();
    private MutableLiveData<String> password = new MutableLiveData<>();
    private MutableLiveData<List<String>> allergies = new MutableLiveData<>();

    // 생성자
    public AuthViewModel() {
        isAuthenticated.setValue(false);
    }

    // 로그인 인증을 수행하는 메서드
    public void authenticateSignIn() {
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

    public void authenticateSignUp() {
        String enteredName = name.getValue();
        String enteredEmail = email.getValue();
        String enteredPassword = password.getValue();

        if (isValidName(enteredName) && isValidEmail(enteredEmail) && isValidPassword(enteredPassword)) {

        }
    }

    public void signUp(){
        String enteredName = name.getValue();
        String enteredEmail = email.getValue();
        String enteredPassword = password.getValue();
//        List<String> enteredAllergies = (List<String>) allergies;

//        UserInfo userInfo1 = new UserInfo(enteredEmail, enteredPassword, enteredName);

        executor.submit(() -> {
            try {
                Log.d("회원가입1", String.valueOf(allergies.getValue()));
                Log.d("회원가입", allergies.getValue().toString());
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    private boolean isValidName(String name) {
        return name != null && !name.isEmpty();
    }

    // 입력된 이메일이 유효한지 확인하는 메서드
    private boolean isValidEmail(String email) {
        return email != null && !email.isEmpty();
    }

    // 입력된 비밀번호가 유효한지 확인하는 메서드
    private boolean isValidPassword(String password) {
        return password != null && password.length() >= 6; // 예: 최소 6자리 필요
    }

    public MutableLiveData<Boolean> getIsAuthenticated() {
        return isAuthenticated;
    }

    public void setIsAuthenticated(MutableLiveData<Boolean> isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public void setName(MutableLiveData<String> name) {
        this.name = name;
    }

    public MutableLiveData<String> getEmail() {
        return email;
    }

    public void setEmail(MutableLiveData<String> email) {
        this.email = email;
    }

    public MutableLiveData<String> getPassword() {
        return password;
    }

    public void setPassword(MutableLiveData<String> password) {
        this.password = password;
    }

    public void setAllergies(List<String> newAllergies) {
        allergies.setValue(newAllergies);
    }

    public MutableLiveData<List<String>> getAllergiesLiveData() {
        return allergies;
    }

}
