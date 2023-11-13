package PRO.Lektion11_StrategyPattern.Exercise4.EvaluatorStudent;

import Utility.ValidationUtil;

public class NumberEvaluator implements Evaluator {

    /**
     * Returns true, if s contains a valid integer or decimal number.
     */
    @Override
    public boolean isValid(String s) {

        return ValidationUtil.validateInt(s) || ValidationUtil.validateDouble(s);
    }

}
