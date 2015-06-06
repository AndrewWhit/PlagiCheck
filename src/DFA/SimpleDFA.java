package DFA;

/**
 * Created by Andrew on 08.05.2015.
 */
public class SimpleDFA implements IDFA {
    //final states
    final int startState = 0;
    final int idState = 1;
    final int intState = 2;
    final int pmState = 3;
    final int dateState = 4;
    final int failureState = 99;
    final int eofState = -1;
    //not final states
    final int dayState = 14;
    final int firstOfdayState = 5;
    final int secondDayState = 6;
    final int firstOfMonthState = 7;
    final int secondofMonthState = 8;
    final int monthState = 9;
    final int firstOfYearState = 10;
    final int secondOfYearState = 11;
    final int thirdOfYearState = 12;
    final int fourthOfYearState = 13;
    @Override
    public int initialState() {
        return 0;
    }

    @Override
    public int nextState(int state) {
        return 0;
    }

    /**
     * gives the information what will be the next transaction.
     * @param state
     * @param
     * @return
     */
    public int trans (int state, int intSymbol) {
        //Startzustand
        char symbol = (char) intSymbol;
        switch (state) {
            case startState:
                if (Character.isLetter(symbol)) {
                    return idState;
                }
                else if (Character.isDigit(symbol)) {
                    return firstOfdayState;
                }
                else if (intSymbol == eofState) {
                    return eofState;
                }
                else if (checkPM(symbol)) {
                    return pmState;
                }
            case idState:
                if (Character.isLetter(symbol)) {
                    return idState;
                }
                return failureState;
            case firstOfdayState:
                if (Character.isDigit(symbol)) {
                    return secondDayState;
                }
                return failureState;
            case secondDayState:
                if (checkDot(symbol)) {
                    return dayState;
                }
                else if (Character.isDigit(symbol)) {
                    return intState;
                }
                return failureState;
            case intState:
                if (Character.isDigit(symbol)) {
                    return intState;
                }
                return failureState;
            case dayState:
                if (Character.isDigit(symbol)) {
                    return firstOfMonthState;
                }
                return failureState;
            case firstOfMonthState:
                if (Character.isDigit(symbol)) {
                    return secondofMonthState;
                }
                return failureState;
            case secondofMonthState:
                if (checkDot(symbol)) {
                    return monthState;
                }
                return failureState;
            case monthState:
                if (Character.isDigit(symbol)) {
                    return firstOfYearState;
                }
                return failureState;
            case firstOfYearState:
                if (Character.isDigit(symbol)) {
                    return secondOfYearState;
                }
                return failureState;
            case secondOfYearState:
                if (Character.isDigit(symbol)) {
                    return thirdOfYearState;
                }
                return failureState;
            case thirdOfYearState:
                if (Character.isDigit(symbol)) {
                    return dateState;
                }
                return failureState;
            case pmState:
                return failureState;
            case dateState:
                return failureState;
            case eofState:
                return eofState;
            default:
                return failureState;
        }
    }

    @Override
    public boolean isFinal(int state) {
        switch (state) {
            case idState:
                return true;
            case intState:
                return true;
            case pmState:
                return true;
            case dateState:
                return true;
            case firstOfdayState:
                return true;
            case secondDayState:
                return true;
        }
        return false;
    }

    @Override
    public boolean isError(int state) {
        if (state == failureState || state == eofState) {
            return true;
        }
        return false;
    }

    @Override
    public int getTokenClass(int state) {
        switch (state) {
            case idState:
                return idState;
            case intState:
                return intState;
            case pmState:
                return pmState;
            case dateState:
                return dateState;
            case firstOfdayState:
                return intState;
            case secondDayState:
                return intState;
        }
        return 0;
    }

    private boolean checkDot(char symbol) {
        if (".".matches(symbol + "")) {
            return true;
        }
        return false;
    }

    private boolean checkPM (char symbol) {
        if(",".matches(symbol + "")) {
            return true;
        }
        else if ("!".matches(symbol + "")) {
            return true;
        }
        else if ("?".matches(symbol + "")) {
            return true;
        }
        else {
            return checkDot(symbol);
        }
    }
}