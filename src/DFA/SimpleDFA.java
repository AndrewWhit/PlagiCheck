package DFA;

/**
 * Created by Andrew on 08.05.2015.
 */
public class SimpleDFA implements IDFA{
    boolean isFinal = false;
    //States of the DFA
    final int START_STATE = 0;
    final int ID_STATE = 1;
    final int PM_STATE = 2;
    final int WS_STATE = 3;
    final int INTCONS_STATE = 4;
    final int FIRST_OF_DAY_STATE = 5;
    final int SECOND_OF_DAY_STATE = 6;
    final int DAY_STATE = 7;
    final int FIRST_OF_MONTH_STATE = 8;
    final int SECOND_OF_MONTH_STATE = 9;
    final int MONTH_STATE = 10;
    final int FIRST_OF_YEAR_STATE = 11;
    final int SECOND_OF_YEAR_STATE = 12;
    final int THIRD_OF_YEAR_STATE = 13;
    final int FOURTH_OF_YEAR_STATE = 14;
    final int DateState = 15;
    final int EOF_STATE = 16;
    final int FAILURE_STATE = 17;
    //Regulär Expressions
    String idPattern = "[A-Z]|[a-z]";
    String whiteSpace = "[ ]";
    String intPattern = "[0-9]";
    String pmPattern = "[!]|[?]|[,]|[.]";

    @Override
    public int initialState() {
        return 0;
    }

    @Override
    public int nextState(int state) {
        return 0;
    }

    @Override
    public boolean isFinal(int state) {
        return isFinal;
    }

    @Override
    public boolean isError(int state) {
        return false;
    }

    @Override
    public int getTokenClass(int state) {
        return 0;
    }

    public int trans (int state, String symbol) {
        switch (state) {
            case START_STATE:
                if (whiteSpace.matches(symbol)) {
                    return WS_STATE;
                }
                else if (idPattern.matches(symbol)) {
                    return ID_STATE;
                }
                else if (intPattern.matches(symbol)) {
                    return FIRST_OF_DAY_STATE;
                }
                else {
                    return FAILURE_STATE;
                }
            case ID_STATE:
                if (idPattern.matches(symbol)) {
                    return ID_STATE;
                }
                else {
                    return FAILURE_STATE;
                }
            case PM_STATE:
                return FAILURE_STATE;
            case INTCONS_STATE:
                if (intPattern.matches(symbol)) {
                    return INTCONS_STATE;
                }
                else {
                    return FAILURE_STATE;
                }
            case FIRST_OF_DAY_STATE:
                if (intPattern.matches(symbol)) {
                    return SECOND_OF_DAY_STATE;
                }
                else if (pmPattern.matches(symbol))  {
                    return DAY_STATE;
                }
                else {
                    return FAILURE_STATE;
                }
            case SECOND_OF_DAY_STATE:
                if (intPattern.matches(symbol)) {
                    return INTCONS_STATE;
                }
                else if (pmPattern.matches(symbol)) {
                    return DAY_STATE;
                }
                else {
                    return FAILURE_STATE;
                }
            case DAY_STATE:
                if (intPattern.matches(symbol)) {
                    return FIRST_OF_MONTH_STATE;
                }
                else {
                    return FAILURE_STATE;
                }
            case FIRST_OF_MONTH_STATE:
                if (intPattern.matches(symbol)) {
                    return SECOND_OF_MONTH_STATE;
                }
                else if (pmPattern.matches(symbol)) {
                    return MONTH_STATE;
                }
                else {
                    return FAILURE_STATE;
                }
            case MONTH_STATE:
                if (intPattern.matches(symbol)) {
                    return FIRST_OF_YEAR_STATE;
                }
                else {
                    return FAILURE_STATE;
                }
            case FIRST_OF_YEAR_STATE:
                if (intPattern.matches(symbol)) {
                    return SECOND_OF_YEAR_STATE;
                }
                else {
                    return FAILURE_STATE;
                }
            case SECOND_OF_YEAR_STATE:
                if (intPattern.matches(symbol)) {
                    return THIRD_OF_YEAR_STATE;
                }
                if (whiteSpace.matches(symbol)) {
                    return DateState;
                }
            case THIRD_OF_YEAR_STATE:
                if (intPattern.matches(symbol)) {
                    return FOURTH_OF_YEAR_STATE;
                }
                else {
                    return FAILURE_STATE;
                }
            case FOURTH_OF_YEAR_STATE:
                if (whiteSpace.matches(symbol)) {
                    return DateState;
                }
        }
        return FAILURE_STATE;
    }
}
