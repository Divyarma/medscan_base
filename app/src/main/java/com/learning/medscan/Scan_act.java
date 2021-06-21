package com.learning.medscan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class Scan_act extends AppCompatActivity {

    String tag;
    ImageView v_up;
    Button b_scan,b_up;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_act);

        tag=getIntent().getStringExtra("scan_tag");
        v_up=findViewById(R.id.v_scan);
        b_scan=findViewById(R.id.bt_scan);
        b_up=findViewById(R.id.bt_upload);

        b_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose_p();
        }
        });
}

    private void choose_p() {
        Intent p=new Intent();
        p.setType("image/*");
        p.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(p,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            uri=data.getData();
            v_up.setVisibility(View.VISIBLE);
            v_up.setImageURI(uri);
        }
    }
}

