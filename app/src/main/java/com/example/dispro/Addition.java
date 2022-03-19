package com.example.dispro;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.security.AccessController;

public class Addition extends AppCompatActivity {

    public static final int CAM_PERMISSION_CODE = 101;
    public static final int CAM_REQUEST_CODE = 102;
    ImageView img;
    Button cam_btn,gal_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        img=findViewById(R.id.Capure_imageView);
        cam_btn=findViewById(R.id.Capture);
        gal_btn=findViewById(R.id.Gallery);
        cam_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camPermission();
            }
        });
        gal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void camPermission() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA}, CAM_PERMISSION_CODE);
        }
        else{
            OpenCamera();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] Permissions,@NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, Permissions, grantResults);
        if(requestCode==CAM_PERMISSION_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                OpenCamera();
            }else{
                Toast.makeText(this,"permisson denied",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void OpenCamera() {
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera, CAM_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAM_REQUEST_CODE) {
            Bitmap img_b=(Bitmap) data.getExtras().get("data");
            img.setImageBitmap(img_b);
        }
    }
}