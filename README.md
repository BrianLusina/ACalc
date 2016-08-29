# ACalc

This is a basic Android calculator.

## The Layout

The layout uses a **GridLayout** which will hold all the buttons of the calculator. The Calculator display will use a WebView. The reason I use a webview instead of a TextView, is because it gives extra formatting options, and also allows us to leverage the power of JavaScript. JavaScript has a built in *eval* function that will take a string as an argument and run that string as JavaScript code. Our string will just be a bunch of math that we want to compute, and JavaScript will handle all the work for us.

### Enabling JavaScript for the WebView

It is important to note that the WebView by default does not have javascript enabled. Use the code below to enable JavaScript in the WebView.

```java
display = (WebView) findViewById(R.id.calculator_display);
display.getSettings().setJavaScriptEnabled(true);
```