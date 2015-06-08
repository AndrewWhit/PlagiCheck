 package lexer;

import DFA.SimpleDFA;
import actionsPackage.*;
import mapPackage.IMapFactory;
import mapPackage.TreeMapFactory;
import token.IToken;
import token.Token;
import triePackage.ITrie;
import triePackage.ITrieReference;
import triePackage.Trie;

import java.io.IOException;
import java.io.PushbackReader;

/**
 * Created by Andrew on 08.05.2015.
 */
public class BaseLexer implements ILexer {
    PushbackReader pushbackReader;
    SimpleDFA dfa = new SimpleDFA();
    final private IMapFactory mapFactory = new TreeMapFactory();
    private IActionAtInsert idAction = new StringCoding(4711);
    private IActionAtInsert intAction = new StringCoding(4711);
    private IActionAtInsert pmAction = new StringCoding(4711);
    private IActionAtInsert dateAction = new StringCoding(4711);
    private IActionAtInsert whiteSpaceAction = new StringCoding(4711);
    //Tries für Datenverwaltung
    Trie idTrie = new Trie(mapFactory);
    Trie intTrie = new Trie(mapFactory);
    Trie pmTrie = new Trie(mapFactory);
    Trie dateTrie = new Trie(mapFactory);
    Trie whiteSpaceTrie = new Trie(mapFactory);

    public BaseLexer (PushbackReader pushbackReader) {
        this.pushbackReader = pushbackReader;
    }

    @Override
    public IToken getNextToken() throws IOException {
        StringBuffer tokenBuffer = new StringBuffer();
        int currentState = 0;
        int lastFinalState = 0;
        int lastFinalPosition = 0;
        int tmpChar = pushbackReader.read();
        while (tmpChar != -1) {
            tokenBuffer.append((char) tmpChar);
            currentState = dfa.trans(currentState, tmpChar);
            if(dfa.isFinal(currentState)) {
                lastFinalState = currentState;
                lastFinalPosition = tokenBuffer.length();
            }
            if (dfa.isError(currentState)) {
                String tokenString = tokenBuffer.substring(0, lastFinalPosition - 1);
                ITrieReference trieReference = insertDictonary(tokenString, lastFinalState);
                pushbackReader.unread(tokenBuffer.substring(lastFinalPosition).toCharArray());
                return new Token(dfa.getTokenClass(lastFinalState), (Integer) trieReference.getValue());
            }
            tmpChar = pushbackReader.read();
            if (tmpChar == -1) {
                String tokenString = tokenBuffer.substring(0, tokenBuffer.toString().length());
                ITrieReference trieReference = insertDictonary(tokenString, lastFinalState);
                return new Token(dfa.getTokenClass(lastFinalState), (Integer) trieReference.getValue());
            }
        }
        return new Token(-1, -1);
    }

    @Override
    public String decode(IToken tk) {
        return new String("(" + tk.getClassCode() + " = " + tk.getTokenName() + "|" + tk.getRelativeCode() + ")");
    }

    private ITrieReference insertDictonary (String string, int lastFinalState) {
        switch (lastFinalState) {
            case 1:
                return idTrie.insert(string, idAction);
            case 2:
                return intTrie.insert(string, intAction);
            case 3:
                return pmTrie.insert(string, pmAction);
            case 4:
                return dateTrie.insert(string, dateAction);
            case 5:
                return intTrie.insert(string, intAction);
            case 6:
                return intTrie.insert(string, intAction);
            case 15:
                return whiteSpaceTrie.insert(string, whiteSpaceAction);
        }
        return null;
    }

}

