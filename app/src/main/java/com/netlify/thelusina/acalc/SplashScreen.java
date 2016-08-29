package com.netlify.thelusina.acalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Project: ACalc
 * Package: com.netlify.thelusina.acalc
 * Created by lusinabrian on 29/08/16 at 08:53
 * <p/>
 * Description:
 */
public class SplashScreen extends AppCompatActivity {
    public static final String SPLASHSCREEN_TAG = SplashScreen.class.getSimpleName();
    private TextView appName;
    private ImageView appIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splashscreen_layout);
        /*todo: add animations*/
        initViews();
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    sleep(3000);
                    Intent openCalc = new Intent(SplashScreen.this, CalclulatorActivity.class);
                    startActivity(openCalc);
                    finish();
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                    Log.d(SPLASHSCREEN_TAG, ie.getMessage());
                }
            }
        };
        thread.start();
    }

    /**initialize the UI controls*/
    private void initViews() {
        appName = (TextView)findViewById(R.id.app_name_id);
        appIcon = (ImageView)findViewById(R.id.app_icon_id);
    }


}
