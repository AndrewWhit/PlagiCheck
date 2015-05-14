package token;

/**
 * Created by Andrew on 09.04.2015.
 */
public class Token implements IToken {
    int classCode;
    int relativeCode;
    public Token (int classCode, int relativeCode) {
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
}
