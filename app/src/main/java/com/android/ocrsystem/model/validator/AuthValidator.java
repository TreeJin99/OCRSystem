package com.android.ocrsystem.model.validator;

public class AuthValidator {

    // 로그인 인증을 수행하는 메서드
    public boolean authenticateSignIn(String email, String password) {
        boolean isAuthenticated = false;

        if (isValidEmail(email) && isValidPassword(password)) {
            // 인증 로직 수행 (예: 백엔드와 통신하여 자격 증명 확인)
            // 단순성을 위해 인증이 성공했다고 가정
            isAuthenticated = true;
            // isAuthenticated.setValue(true);
        } else {
            // 인증 실패
            isAuthenticated = false;
            // isAuthenticated.setValue(false);
        }

        return isAuthenticated;
    }


    public boolean authenticateSignUp(String name, String email, String password) {
        boolean isAuthenticated = false;

        if (isValidName(name) && isValidEmail(email) && isValidPassword(password)) {
            isAuthenticated = true;
        } else {
            isAuthenticated = false;
        }

        return isAuthenticated;
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
}


