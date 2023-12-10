package com.android.ocrsystem.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.android.ocrsystem.databinding.FragmentSignUpUserinfoBinding;

public class SignUpUserInfoFragment extends Fragment {

    private FragmentSignUpUserinfoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Data Binding을 사용하여 레이아웃과 연결
        binding = FragmentSignUpUserinfoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // 여기에 XML에서 참조한 뷰들에 대한 이벤트 처리 코드 등을 추가

        // 예시: "다음" 버튼 클릭 이벤트 처리
        binding.signUpNameDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 여기에 다음으로 이동하는 로직 추가
            }
        });

        return view;
    }
}
