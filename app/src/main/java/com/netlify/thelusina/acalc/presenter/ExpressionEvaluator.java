package com.netlify.thelusina.acalc.presenter;

import org.javia.arity.Symbols;

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

    public ExpressionEvaluator(){
        mSymbols = new Symbols();

    }
//END
}
