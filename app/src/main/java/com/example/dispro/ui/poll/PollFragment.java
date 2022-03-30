package com.example.dispro.ui.poll;

import static com.example.dispro.ui.poll.PollViewModel.CAM_PERMISSION_CODE;
import static com.example.dispro.ui.poll.PollViewModel.CAM_REQUEST_CODE;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dispro.databinding.FragmentContactBinding;
import com.example.dispro.databinding.FragmentPollBinding;
import com.example.dispro.ui.contacts.ContactViewModel;

public class PollFragment extends Fragment {

    private FragmentPollBinding binding;
    private PollViewModel pollViewModel;


    ImageView img;
    Button cam_btn,gal_btn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PollViewModel pollViewModel =
                new ViewModelProvider(this).get(PollViewModel.class);

        binding = FragmentPollBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        img=binding.pollImageView;
        cam_btn=binding.pollCapture;
        gal_btn=binding.pollGallery;

        cam_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenCamera();
            }
        });
        gal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
//        cam_btn.performClick();
        final TextView textView = binding.textPoll;
        pollViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] Permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, Permissions, grantResults);
        if(requestCode==CAM_PERMISSION_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                OpenCamera();
            }else{
//                Toast.makeText(this,"permisson denied",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAM_REQUEST_CODE) {
            try {
                Bitmap img_b = (Bitmap) data.getExtras().get("data");
                if (img_b.getHeight()>0){
                    img.setImageBitmap(img_b);
                }
                else{
                    Bitmap err = null;
                    img.setImageBitmap((Bitmap) err);
                }
            }catch (Exception e){}
        }
    }

//    private void camPermission() {
//        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA}, CAM_PERMISSION_CODE);
//        }
//        else{
//            OpenCamera();
//        }
//    }

    private void OpenCamera() {
        try {
            Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(camera, CAM_REQUEST_CODE);
        }catch (Exception e){}
    }

}