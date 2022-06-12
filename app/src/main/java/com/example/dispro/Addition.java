package com.example.dispro;

import static com.example.dispro.ui.poll.PollViewModel.CAM_REQUEST_CODE;

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
import android.util.Base64;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.security.AccessController;

public class Addition extends AppCompatActivity {

    public static final int CAM_PERMISSION_CODE = 101;
    public static final int CAM_REQUEST_CODE = 102;
    ImageView img;
    Button cam_btn,gal_btn,add_btn;
    Bitmap img_b;
    String JSON_STRING;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        img=findViewById(R.id.Capure_imageView);
        cam_btn=findViewById(R.id.Capture);
        gal_btn=findViewById(R.id.Gallery);
        add_btn=findViewById(R.id.Add);
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
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (img_b.getHeight()>0){
                    JSON_STRING = "{\"img_data\":\"\",\"ending\":1}";
                    try {
                        JSONObject obj = new JSONObject(JSON_STRING);

                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        img_b.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                        byte[] byteArray = stream.toByteArray();
                        String result = Base64.encodeToString(byteArray, Base64.DEFAULT);
//                        result="parth";
                        obj.put("img_data", result);
                        String msg="Working";
                        msg=new Communicate().communicate(obj);
                        Snackbar.make(view, Integer.toString(result.length()), Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Spinner foodname = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, getResources().getStringArray(R.array.itemname));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        foodname.setAdapter(myAdapter);
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
            try {
                img_b = (Bitmap) data.getExtras().get("data");
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
}