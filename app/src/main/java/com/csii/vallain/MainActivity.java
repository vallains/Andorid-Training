package com.csii.vallain;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.muddzdev.styleabletoastlibrary.StyleableToast;
import com.nightonke.jellytogglebutton.JellyToggleButton;
import com.nightonke.jellytogglebutton.JellyTypes.Jelly;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.suke.widget.SwitchButton;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView animation_view;
    LottieAnimationView animation_view1;
    LottieAnimationView animation_view2;
    private String JSON_CONTENT = "{\"weatherinfo\":{\"city\":\"北京\",\"cityid\":\"101010100\"," +
            "\"temp\":\"18\",\"WD\":\"东南风\",\"WS\":\"1级\",\"SD\":\"17%\",\"WSE\":\"1\"," +
            "\"time\":\"17:05\",\"isRadar\":\"1\",\"Radar\":\"JC_RADAR_AZ9010_JB\"," +
            "\"njd\":\"暂无实况\",\"qy\":\"1011\",\"rain\":\"0\"}}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  //（可选）是否显示线程信息。 默认值为true
                .methodCount(2)         // （可选）要显示的方法行数。 默认2
                .methodOffset(5)        // （可选）隐藏内部方法调用到偏移量。 默认5
                .tag("wangpu")   //（可选）每个日志的全局标记。 默认PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
        Logger.json(JSON_CONTENT);
        Logger.d("debug");
        Logger.d("debug1");
        Logger.e("error");
        Logger.e("error1");
        Logger.e("error1");
        Logger.w("warning");
        Logger.d("debug1");
        Logger.d("debug1");
        Logger.d("debug12");
        Logger.v("verbose");
        Logger.i("information");
        Logger.i("information");
        Logger.wtf("wtf!!!!");
        Logger.wtf("wtf!!!!");
        animation_view = (LottieAnimationView)findViewById(R.id.animation_view);
        animation_view1 = (LottieAnimationView)findViewById(R.id.animation_view1);
        animation_view2 = (LottieAnimationView)findViewById(R.id.animation_view2);
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
                Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
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

        JellyToggleButton jellyToggleButton = (com.nightonke.jellytogglebutton.JellyToggleButton)
                findViewById(R.id.toggleButton);
        jellyToggleButton.setJelly(Jelly.LAZY_TREMBLE_HEAD_FATTY);
        SwitchButton switchButton = (SwitchButton) findViewById(R.id.switch_button);
        switchButton.setChecked(true);
        switchButton.isChecked();
        switchButton.toggle();     //switch state
        switchButton.toggle(true);//switch without animation
        switchButton.setShadowEffect(false);//disable shadow effect
        switchButton.setEnabled(true);//disable button
        switchButton.setEnableEffect(true);//disable the switch animation
        switchButton.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
            }
        });

        Button start_anim = (Button) findViewById(R.id.start_anim);
        start_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation_view.playAnimation();
                animation_view1.playAnimation();
                animation_view2.playAnimation();
            }
        });

        Button stop_anim = (Button) findViewById(R.id.stop_anim);
        stop_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation_view.cancelAnimation();
                animation_view1.cancelAnimation();
                animation_view2.cancelAnimation();
            }
        });

    }
}
