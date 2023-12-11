package com.android.ocrsystem.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.android.ocrsystem.database.AppDatabase;
import com.android.ocrsystem.model.UserInfo;
import com.android.ocrsystem.model.dao.AuthDao;
import com.android.ocrsystem.util.validator.AuthValidator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AuthViewModel extends AndroidViewModel {
    private AuthDao authDao;

    public AuthViewModel(Application application) {
        super(application);
        AppDatabase db = AppDatabase.getInstance(application);
        authDao = db.userInfoDao();
        isAuthenticated.setValue(false);
    }

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

    public void isSignIn(String email, String password) {
        // 테스트용 계정
        UserInfo testInfo = new UserInfo("테스트", "test", "12345678", null);

        executor.submit(() -> {
            if (authDao == null) {
                // authDao가 null인 경우 다시 초기화
                AppDatabase db = AppDatabase.getInstance(getApplication());
                authDao = db.userInfoDao();
            }
            authDao.createUser(testInfo);


            UserInfo userInfo = authDao.getSignIn(email, password);
            boolean isAuthenticateSignIn = userInfo != null;
            isAuthenticated.postValue(isAuthenticateSignIn);
        });
    }

    public void isSignUp() {
        executor.submit(() -> {
            try {
                List<String> allergiesList = allergies.getValue();
                UserInfo userInfo = new UserInfo(name.getValue(), email.getValue(), password.getValue(), allergiesList);
                Log.d("회원가입", allergies.getValue().toString());
                Log.d("회원가입", userInfo.toString());
                if (authDao == null) {
                    // authDao가 null인 경우 다시 초기화
                    AppDatabase db = AppDatabase.getInstance(getApplication());
                    authDao = db.userInfoDao();
                }

                authDao.createUser(userInfo);
            } catch (Exception e) {
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
