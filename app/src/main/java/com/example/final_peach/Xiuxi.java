package com.example.final_peach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Xiuxi extends AppCompatActivity implements View.OnClickListener{
    private Button btn_xx,btn_exit;
    private int count=0;//休息次数
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiuxi);
        init();
    }
    private void init() {
        btn_xx = findViewById(R.id.btn_xx);
        btn_exit = findViewById(R.id.btn_exit);
        btn_xx.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_xx)
        {
            count++;

            Toast.makeText(Xiuxi.this,"体力值+5",
                    Toast.LENGTH_LONG).show();

        }
        if(view.getId()==R.id.btn_exit)
        {
            Intent intent = new Intent();
            intent.putExtra("xx_tl",count);
            setResult(3,intent);
            Xiuxi.this.finish();
        }
    }
}