package DFA;

/**
 * Created by Andrew on 08.05.2015.
 */
public interface IDFA {
    public int initialState();
    public int nextState(int state);
    public boolean isFinal (int state);
    public boolean isError (int state);
    public int getTokenClass (int state);
}
