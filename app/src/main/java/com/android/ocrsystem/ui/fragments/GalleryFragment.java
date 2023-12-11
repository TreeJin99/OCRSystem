package com.android.ocrsystem.ui.fragments;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.ocrsystem.R;
import com.android.ocrsystem.ui.activities.ImagePickActivity;
import com.bumptech.glide.Glide;

public class GalleryFragment extends Fragment {
    private static final int IMAGE_PICK_CODE = 1003;
    private static final int PERMISSION_CODE = 1004;

    private ImageView galleryImageView;
    private Button imagePickButton;
    private TextView eatableTextView;
    private TextView allergyListTextView;

    public GalleryFragment() {
        // Required empty public constructor
    }

    private ActivityResultLauncher<PickVisualMediaRequest> launcher = registerForActivityResult(
            new ActivityResultContracts.PickVisualMedia(), result -> {
                if (result == null) {
                    Toast.makeText(requireContext(), "No image Selected", Toast.LENGTH_SHORT).show();
                } else {
                    // 여기에서 선택된 이미지를 처리하는 로직을 추가하세요.
                    // 예를 들어, 이미지뷰에 Glide로 이미지를 표시하는 등의 작업을 수행할 수 있습니다.
                    Glide.with(requireContext()).load(result).into(galleryImageView);
                }
            }
    );

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        galleryImageView = view.findViewById(R.id.gallery_Imageview);
        imagePickButton = view.findViewById(R.id.imagePickButton);

        imagePickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launcher.launch(new PickVisualMediaRequest.Builder()
                        .setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE)
                        .build());
            }
        });
    }


    private final ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent intent = result.getData();
                    if (intent != null) {
                        Uri uri = intent.getData();
                        // 이제 가져온 URI를 사용할 수 있습니다.
                        // 선택된 이미지를 처리하는 로직을 여기에 추가하세요.
                    }
                }
            }
    );



}
