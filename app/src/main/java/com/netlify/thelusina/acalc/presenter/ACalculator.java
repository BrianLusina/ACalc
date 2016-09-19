package com.netlify.thelusina.acalc.presenter;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.netlify.thelusina.acalc.widgets.ACalcEditText;

/**
 * Project: ACalc
 * Package: com.netlify.thelusina.acalc.presenter
 * Created by lusinabrian on 19/09/16 at 08:54
 * Description:
 */

public class ACalculator extends AppCompatActivity implements ACalcEditText.OnTextSizeChangeListener, View.OnLongClickListener{

    /**
     * Called when a view has been clicked and held.
     * @param v The view that was clicked and held.
     * @return true if the callback consumed the long click, false otherwise.
     */
    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    @Override
    public void onTextSizeChanged(TextView textView, float oldSize) {

    }

/*END*/
}
