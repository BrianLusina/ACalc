package com.netlify.thelusina.acalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class CalclulatorActivity extends AppCompatActivity implements View.OnClickListener{
    private WebView display;
    private StringBuilder output;
    private Button settingsBtn, backspaceBtn,cancelBtn, divideBtn,percentBtn,righBrackbtn,leftBrackbtn,multiplyBtn,sevenBtn,eightBtn,nineBtn,subtractBtn,fourBtn,fiveBtn,six6Btn,plusBtn,oneBtn,twoBtn,threeBtn,equalsBtn,negPosBtn,zeroBtn,periodBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);
        initViews();

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
        }
        updateWebView();
    }
    /**Updates the webview per click event of the calculator buttons*/
    private void updateWebView() {
        StringBuilder builder = new StringBuilder();
        builder.append("<html><body>");
        builder.append("<script type=\"text/javascript\">document.write('");
        builder.append(output.toString());
        builder.append("');");
        builder.append("document.write('<br />=' + eval(\"");
        builder.append(output.toString());
        builder.append("\"));</script>");
        builder.append("</body></html>");

        display.loadData(builder.toString(), "application/xhtml", "UTF-8");
    }
}
