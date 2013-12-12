package com.elclcd.orientation;

import com.elclcd.orientation.R.id;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


/**
 * @Description 
 * 屏幕旋转测试
 *
 * @author elc_simayi
 * @date 2013-12-11 下午4:18:33 
 */
public class MainActivity extends Activity {
    private String TAG = "MainActivity";
    Button lan, por, reLan, rePor ,re;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lan = (Button) findViewById(id.bt_lan);
        por = (Button) findViewById(id.bt_por);
        reLan = (Button) findViewById(id.bt_re_lan);
        rePor = (Button) findViewById(id.bt_re_por);
        re = (Button) findViewById(id.bt_re);

        lan.setOnClickListener(clickListener);
        por.setOnClickListener(clickListener);
        reLan.setOnClickListener(clickListener);
        rePor.setOnClickListener(clickListener);
        re.setOnClickListener(clickListener);
    }

    OnClickListener clickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            int screenOrientattion = -1;
            if (v == lan) {
                screenOrientattion = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE; //横屏
            } else if (v == por) {
                screenOrientattion = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;  //竖屏
            } else if (v == reLan) {
                screenOrientattion = ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE; //横屏反转
            } else if (v == rePor) {
                screenOrientattion = ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT; //竖屏反转
            } else if (v == re) {
                screenOrientattion = OrientationService.RESTFLAG; // 重置
            }
            setParams(screenOrientattion);
        }
    };

    private void setParams(int rotation) {
        Intent intent = new Intent(this, OrientationService.class);
        intent.putExtra(OrientationService.FLAG_VALUE, rotation);
        startService(intent);
    }

}
