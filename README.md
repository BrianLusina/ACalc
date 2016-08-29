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

### Handling Button click events

The calculator works by storing the user inputs in a String Builder and passing this information to the web view for evaluation. StringBuilders are used instead of strings because they are more efficient when you are constantly changing values.

We will use one button listener for all of the buttons. For most of the buttons, what we want to append to the string is exactly what the button is displaying. This makes the listener code fairly simple.

The overridden `onClick` method will handle all the click events. It will check if the button being clicked is a cancel(clear) button or a backspace button or any other button. If the cancel(clear) is clicked, the display will be cleared. If the backspace button is clicked the last character in the display will be cleared. The rest of the buttons will be handled with the following snippet@:

```java
default:
    output.append(((Button) v).getText());
```
> A switch and case is being used and the default case handles every other button in the calculator
