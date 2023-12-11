package com.android.ocrsystem.ui.fragments;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Matrix;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.ocrsystem.R;
import com.bumptech.glide.Glide;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.korean.KoreanTextRecognizerOptions;

import java.io.IOException;

public class GalleryFragment extends Fragment {
    private static final int IMAGE_PICK_CODE = 1003;
    private static final int PERMISSION_CODE = 1004;

    private ImageView galleryImageView;
    private Button imagePickButton;
    private TextView eatableTextView;
    private TextView allergyListTextView;

    // When using Korean script library
    TextRecognizer recognizer =
            TextRecognition.getClient(new KoreanTextRecognizerOptions.Builder().build());


    public GalleryFragment() {
        // Required empty public constructor
    }

    private ActivityResultLauncher<PickVisualMediaRequest> launcher = registerForActivityResult(
            new ActivityResultContracts.PickVisualMedia(), result -> {
                if (result == null) {
                    Toast.makeText(requireContext(), "No image Selected", Toast.LENGTH_SHORT).show();
                } else {
                    Glide.with(requireContext()).load(result).into(galleryImageView);
                    processSelectedImage(result);
                }
            }
    );

    private void processSelectedImage(Uri selectedImageUri) {
        // 선택된 이미지 URI를 사용하여 필요한 작업을 수행하세요.
        // 예: ML Kit Vision API로 이미지 처리
        InputImage image;
        try {
            image = InputImage.fromFilePath(requireContext(), selectedImageUri);
            recognizer.process(image)
                    .addOnSuccessListener(visionText -> {
                        // 추출된 텍스트에 대한 작업을 수행하세요.
                        // visionText에서 추출된 텍스트 정보를 가져올 수 있습니다.

                        // 전체 추출된 텍스트
                        String fullText = visionText.getText();
                        Log.d("전체 텍스트", fullText);
                    })
                    .addOnFailureListener(e -> {
                        // 오류가 발생하면 처리하세요.
                        e.printStackTrace();
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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
                    }
                }
            }
    );
}
