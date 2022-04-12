package com.example.final_peach;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn_peach,btn_tree,btn_xxx;
    private TextView tv_count,tv_tl;
    private int totalCount = 0;
    private int tl=100;//体力值
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        btn_peach = findViewById(R.id.btn_peach);
        tv_count = findViewById(R.id.tv_count);
        btn_tree = findViewById(R.id.btn_tree);
        btn_xxx =findViewById(R.id.btn_xxx);
        tv_tl =findViewById(R.id.tv_tl);
        btn_peach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PeachActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        btn_tree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Plant_tree.class);
                startActivityForResult(intent, 1);
            }
        });
        btn_xxx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Xiuxi.class);
                startActivityForResult(intent, 1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int zt_tl=0,zs_tl=0,xx_tl=0;
        if (requestCode == 1&&resultCode==1) {
            int count = data.getIntExtra("count", 0); //获取回传的数据
            zt_tl=count;
            totalCount = totalCount + count;
            tv_count.setText("摘到" + totalCount + "个");
        }
        if(requestCode==1&&resultCode==2)
        {
             zs_tl=data.getIntExtra("tl",0);
        }
        if(requestCode==1&&resultCode==3)
        {
            xx_tl=data.getIntExtra("xx_tl",0);
        }
        tl=tl-zt_tl-zs_tl+xx_tl*5;
        if(tl>100)tl=100;
        tv_tl.setText("体力值："+tl);
    }
}

