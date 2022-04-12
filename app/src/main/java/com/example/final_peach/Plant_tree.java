package com.example.final_peach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Plant_tree extends AppCompatActivity implements
        View.OnClickListener {
    private Button btn_kettle,btn_exit;
    private int count=0;//浇水次数
    private TextView tv_csd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_tree);
        init();
    }
    private void init() {
        btn_kettle = findViewById(R.id.btn_kettle);
        btn_exit = findViewById(R.id.btn_exit);
        tv_csd=findViewById(R.id.tv_csd);
        btn_kettle.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_kettle)
        {
            count++;
            if(count==10)count=1;
            Toast.makeText(Plant_tree.this,"桃树成熟度+10%",
                    Toast.LENGTH_LONG).show();
            tv_csd.setText("成熟度："+count*10+"%");
        }
        if(view.getId()==R.id.btn_exit)
        {
            Intent intent = new Intent();
            intent.putExtra("tl",count);
            setResult(2,intent);
            Plant_tree.this.finish();
        }
    }
}