package com.csii.vallain;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonXml = (Button) findViewById(R.id.button);
        buttonXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StyleableToast.makeText(MainActivity.this, "Hello World!",
                        Toast.LENGTH_LONG, R.style.MyToast).show();

            }

        });
        Button buttonJava = (Button) findViewById(R.id.button1);
        buttonJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StyleableToast st = new StyleableToast.Builder(MainActivity.this).text("Hello world!")
                        .textColor(Color.WHITE).backgroundColor(Color.BLUE)
                        .alpha(100).cornerRadius(10)
                        .spinIcon().build();
                st.show();
            }
        });

        Button normal = (Button) findViewById(R.id.normal);
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.normal(MainActivity.this, "普通Toasty").show();
            }
        });
        Button info = (Button) findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(MainActivity.this, "信息Toasty").show();
            }
        });
        Button error = (Button) findViewById(R.id.error);
        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.error(MainActivity.this, "错误Toasty").show();
            }
        });
        Button success = (Button) findViewById(R.id.success);
        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.success(MainActivity.this, "成功Toasty").show();
            }
        });
        Button warning = (Button) findViewById(R.id.warning);
        warning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.warning(MainActivity.this, "警告Toasty").show();
            }
        });
    }
}
