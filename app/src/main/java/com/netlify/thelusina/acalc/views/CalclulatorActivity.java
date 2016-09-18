package com.netlify.thelusina.acalc.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.netlify.thelusina.acalc.R;

public class CalclulatorActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String CALCULATORACTIVITY_TAG = CalclulatorActivity.class.getSimpleName();
    private WebView display;
    private StringBuilder output;
    private Button settingsBtn, backspaceBtn,cancelBtn, divideBtn,percentBtn,righBrackbtn,leftBrackbtn,multiplyBtn,sevenBtn,eightBtn,nineBtn,subtractBtn,fourBtn,fiveBtn,six6Btn,plusBtn,oneBtn,twoBtn,threeBtn,equalsBtn,negPosBtn,zeroBtn,periodBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);
        initViews();

        output = new StringBuilder();

        /*enable JavaScript to WebView*/
        display.getSettings().setJavaScriptEnabled(true);
    }

    /**Initialize UI views*/
    private void initViews() {
        display = (WebView)findViewById(R.id.calc_display_id);
        settingsBtn = (Button)findViewById(R.id.settings_btn_id);
        backspaceBtn = (Button)findViewById(R.id.backspace_id);
        cancelBtn = (Button)findViewById(R.id.cancel_btn_id);
        divideBtn= (Button)findViewById(R.id.divide_btn_id);
        percentBtn= (Button)findViewById(R.id.percent_btn_id);
        righBrackbtn= (Button)findViewById(R.id.right_brackets_btn_id);
        leftBrackbtn= (Button)findViewById(R.id.left_brackets_btn_id);
        multiplyBtn= (Button)findViewById(R.id.multiply_id);
        sevenBtn= (Button)findViewById(R.id.seven_btn_id);
        eightBtn= (Button)findViewById(R.id.eight_btn_id);
        nineBtn= (Button)findViewById(R.id.nine_btn_id);
        subtractBtn= (Button)findViewById(R.id.subtract_btn_id);
        fourBtn= (Button)findViewById(R.id.four_btn_id);
        fiveBtn= (Button)findViewById(R.id.five_btn_id);
        six6Btn= (Button)findViewById(R.id.six_btn_id);
        plusBtn= (Button)findViewById(R.id.plus_btn_id);
        oneBtn= (Button)findViewById(R.id.one_btn_id);
        twoBtn= (Button)findViewById(R.id.two_btn_id);
        threeBtn= (Button)findViewById(R.id.three_btn_id);
        equalsBtn= (Button)findViewById(R.id.equals_btn_id);
        negPosBtn= (Button)findViewById(R.id.negative_positive_btn_id);
        zeroBtn= (Button)findViewById(R.id.zero_btn_id);
        periodBtn= (Button)findViewById(R.id.period_btn_id);

        //set the click listener for all buttons
        Button[] button_array = new Button[]{settingsBtn, backspaceBtn,cancelBtn, divideBtn,percentBtn,righBrackbtn,leftBrackbtn,multiplyBtn,sevenBtn,eightBtn,nineBtn,subtractBtn,fourBtn,fiveBtn,six6Btn,plusBtn,oneBtn,twoBtn,threeBtn,equalsBtn,negPosBtn,zeroBtn,periodBtn};
        /*set the click listeners for all buttons*/
        for(Button btn: button_array){
            btn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backspace_id:
                if(output.length() > 0){
                    output.deleteCharAt(output.length() - 1);
                }
                break;
            case R.id.cancel_btn_id:
                if(output.length() > 0){
                    output.delete(0, output.length());
                }
                break;

            default:
                output.append(((Button) v).getText());
                Log.d(CALCULATORACTIVITY_TAG, output.toString());
        }
        updateWebView();
    }
    /**Updates the webview per click event of the calculator buttons*/
    private void updateWebView() {
        StringBuilder builder = new StringBuilder();
        builder.append("<html><body style='color:black'>");
        builder.append("<script type=\"text/javascript\">document.write('");
        builder.append(output.toString());
        builder.append("');");
        builder.append("document.write('<br />=' + eval(\"");
        builder.append(output.toString());
        builder.append("\"));</script>");
        builder.append("</body></html>");
        Log.d(CALCULATORACTIVITY_TAG, builder.toString());
        display.loadData(builder.toString(), "application/xhtml", "UTF-8");
    }
}


/**
 *
 public class CalculatorActivity extends Activity {
 private WebView mWebView;
 private StringBuilder mMathString;
 private ButtonClickListener mClickListener;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    // Create the math string
    mMathString = new StringBuilder();

    // Enable javascript for the view
    mWebView = (WebView) findViewById(R.id.webview);
    mWebView.getSettings().setJavaScriptEnabled(true);

    // Set the listener for all the buttons
    mClickListener = new ButtonClickListener();
    int idList[] = { R.id.button0, R.id.button1, R.id.button2,
            R.id.button3, R.id.button4, R.id.button5, R.id.button6,
            R.id.button7, R.id.button8, R.id.button9, R.id.buttonLeftParen,
            R.id.buttonRightParen, R.id.buttonPlus, R.id.buttonPlus,
            R.id.buttonMinus, R.id.buttonDivide, R.id.buttonTimes,
            R.id.buttonDecimal, R.id.buttonBackspace, R.id.buttonClear };

    for(int id : idList) {
        View v = findViewById(id);
        v.setOnClickListener(mClickListener);
    }

}

    private void updateWebView() {

        StringBuilder builder = new StringBuilder();

        builder.append("<html><body>");
        builder.append("<script type=\"text/javascript\">document.write('");
        builder.append(mMathString.toString());
        builder.append("');");
        builder.append("document.write('<br />=' + eval(\"");
        builder.append(mMathString.toString());
        builder.append("\"));</script>");
        builder.append("</body></html>");

        mWebView.loadData(builder.toString(), "application/xhtml", "UTF-8");
    }

private class ButtonClickListener implements OnClickListener {

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonBackspace:
                if(mMathString.length() > 0)
                    mMathString.deleteCharAt(mMathString.length()-1);
                break;
            case R.id.buttonClear:
                if(mMathString.length() > 0)
                    mMathString.delete(0, mMathString.length());
                break;
            default:
                mMathString.append(((Button) v).getText());
        }

        updateWebView();
    }
}

* */