package token;

import actionsPackage.*;

import java.util.Objects;

/**
 * Created by Andrew on 09.04.2015.
 */
public class Token implements IToken {
    int classCode;
    int relativeCode;

    public Token (int classCode, int relativeCode) {
        if (classCode == 5 || classCode == 6) {
            this.classCode = 2;
        }
        this.classCode = classCode;
        this.relativeCode = relativeCode;
    }

    @Override
    public int getClassCode() {
        return classCode;
    }

    @Override
    public int getRelativeCode() {
        return relativeCode;
    }

    @Override
    public String getTokenName() {
        switch (classCode) {
            case 1:
                return "IDENTIFIER";
            case 2:
                return "INTEGER";
            case 3:
                return "Punctuation Mark";
            case 4:
                return "DATE";
            case 5:
                return "INTEGER";
            case 6:
                return "INTEGER";
        }
        return null;
    }
}
