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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Andrew on 08.05.2015.
 */
public class BaseLexer implements ILexer {
    PushbackReader pushbackReader;
    SimpleDFA dfa = new SimpleDFA();
    final private IMapFactory mapFactory = new TreeMapFactory(); //DIC
    private IActionAtInsert idAction = new StringCoding(4711);
    private IActionAtInsert intAction = new StringCoding(4711);
    private IActionAtInsert pmAction = new StringCoding(4711);
    private IActionAtInsert dateAction = new StringCoding(4711);
    //Tries für Datenverwaltung
    Trie idTrie = new Trie(mapFactory);
    Trie intTrie = new Trie(mapFactory);
    Trie pmTrie = new Trie(mapFactory);
    Trie dateTrie = new Trie(mapFactory);

    public BaseLexer (PushbackReader pushbackReader) {
        this.pushbackReader = pushbackReader;
    }

    @Override
    public Token getNextToken() throws IOException {
        StringBuffer tokenBuffer = new StringBuffer();
        int currentState = 0;
        int lastFinalPosition = 0;
        int lastFinalState = 0;
        int tmpChar = pushbackReader.read();
        char symbol;
        while (tmpChar != -1) {
            tokenBuffer.append((char) tmpChar);
            currentState = dfa.trans(currentState, tmpChar);
            if(dfa.isFinal(currentState)) {
                lastFinalState = currentState;
                lastFinalPosition = tmpChar;
            }
            if (dfa.isError(currentState)) {
                String tokenString = tokenBuffer.substring(0, tokenBuffer.toString().lastIndexOf((char) tmpChar));
                ITrieReference trieReference = insertDictonary(tokenString, lastFinalState);
                pushbackReader.unread(tokenBuffer.substring(tokenBuffer.toString().lastIndexOf((char) tmpChar)).toCharArray());
                return new Token(dfa.getTokenClass(lastFinalState), (Integer) trieReference.getValue());
            }
            tmpChar = pushbackReader.read();
            if (tmpChar == -1) {
                String tokenString = tokenBuffer.substring(0, tokenBuffer.toString().length());
                ITrieReference trieReference = insertDictonary(tokenString, lastFinalState);
                return new Token(dfa.getTokenClass(lastFinalState), (Integer) trieReference.getValue());
            }
        }
        /*
        while (!dfa.isError(currentState)) {
            if (dfa.isFinal(currentState)) {
                lastFinalState = currentState;
                lastFinalPosition = tmpChar;
            }
            tmpChar = pushbackReader.read();
            if (tmpChar != -1) {
                symbol = (char) tmpChar;
                currentState = dfa.trans(currentState, symbol);
                tokenBuffer.append((char) tmpChar);
            }
        }
        if (lastFinalPosition > -1) {
            String tokenString = tokenBuffer.substring(0, tokenBuffer.toString().lastIndexOf((char) tmpChar));
            ITrieReference trieReference = insertDictonary(tokenString, lastFinalState);
            pushbackReader.unread(tokenBuffer.substring(tokenBuffer.toString().lastIndexOf((char) tmpChar)).toCharArray());
            return new Token(dfa.getTokenClass(lastFinalState), (Integer) trieReference.getValue());
        } else if (lastFinalPosition == -1) {
            return new Token(-1, -1);
        }
        */
        return null;
    }

    @Override
    public String decode(IToken tk) {
        return new String("(" + tk.getClassCode() + "|" + tk.getRelativeCode() + ") -->" + tk.getTokenName() + " --> + searchString(tk)");
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
        }
        return null;
    }

    private String searchString (IToken tk) {
        switch (tk.getClassCode()) {
            case 1:
                return idTrie.searchString(tk.getRelativeCode());
            case 2:
                return intTrie.searchString(tk.getRelativeCode());
            case 3:
                return pmTrie.searchString(tk.getRelativeCode());
        }
        return dateTrie.searchString(tk.getRelativeCode());
    }
}

