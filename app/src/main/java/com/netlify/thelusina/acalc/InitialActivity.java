package com.netlify.thelusina.acalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.netlify.thelusina.acalc.views.CalculatorGB;
import com.netlify.thelusina.acalc.views.CalculatorLol;

/**
 * Project: ACalc
 * Package: com.netlify.thelusina.acalc
 * Created by lusinabrian on 19/09/16 at 08:42
 * Description: The initial Activity to start, checks the version of the phone and starts the appropriate Activity
 */

public class InitialActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // If the device is Lollipop, start the lollipop activity
        if(Utils.hasLollipop()){
            startActivity(new Intent(this, CalculatorLol.class));
        }else{
            startActivity(new Intent(this, CalculatorGB.class));
        }
        finish();
    }
}
