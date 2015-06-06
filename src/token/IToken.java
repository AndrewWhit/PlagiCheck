package token;

/**
 * Created by Andrew on 08.05.2015.
 */
public interface IToken {
    final int Identifier = 1;
    final int Intcons = 2;
    final int Date = 3;
    final int Pmark = 4;



    public int getClassCode();

    public int getRelativeCode();

    public String getTokenName();
}
