package com.netlify.thelusina.acalc.presenter;

import com.netlify.thelusina.acalc.R;

import org.javia.arity.Symbols;
import org.javia.arity.SyntaxException;
import org.javia.arity.Util;

/**
 * Project: ACalc
 * Package: com.netlify.thelusina.acalc.presenter
 * Created by lusinabrian on 19/09/16 at 09:00
 */

public class ExpressionEvaluator {
    /**Maximum number of digits to display*/
    private static final int MAX_DIGITS= 12;

    /**a {@link Double} has at least 17 significant digits, we display the first {@link #MAX_DIGITS}
     * and use the remaining digits as guard digits to hide floating point precision errors */
    private static final int ROUNDING_DIGITS = Math.max(17 - MAX_DIGITS, 0);

    private final Symbols mSymbols;
    private final ExpressionTokenizer mTokenizer;

    public ExpressionEvaluator(ExpressionTokenizer tokenizer){
        mSymbols = new Symbols();
        mTokenizer = tokenizer;
    }
    public void evaluate(CharSequence expr, EvaluateCallback callback) {
        evaluate(expr.toString(), callback);
    }

    public void evaluate(String expr, EvaluateCallback callback) {
        expr = mTokenizer.getNormalizedExpression(expr);

        // remove any trailing operators
        while (expr.length() > 0 && "+-/*".indexOf(expr.charAt(expr.length() - 1)) != -1) {
            expr = expr.substring(0, expr.length() - 1);
        }

        try {
            if (expr.length() == 0 || Double.valueOf(expr) != null) {
                callback.onEvaluate(expr, null, Calculator.INVALID_RES_ID);
                return;
            }
        } catch (NumberFormatException e) {
            // expr is not a simple number
        }

        try {
            double result = mSymbols.eval(expr);
            if (Double.isNaN(result)) {
                callback.onEvaluate(expr, null, R.string.error_nan);
            } else {
                // The arity library uses floating point arithmetic when evaluating the expression
                // leading to precision errors in the result. The method doubleToString hides these
                // errors; rounding the result by dropping N digits of precision.
                final String resultString = mTokenizer.getLocalizedExpression(
                        Util.doubleToString(result, MAX_DIGITS, ROUNDING_DIGITS));
                callback.onEvaluate(expr, resultString, ACalculator.INVALID_RES_ID);
            }
        } catch (SyntaxException e) {
            callback.onEvaluate(expr, null, R.string.error_syntax);
        }
    }

    public interface EvaluateCallback {
        public void onEvaluate(String expr, String result, int errorResourceId);
    }
//END
}
