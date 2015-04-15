package triePackage;

import actionsPackage.IActionAtInsert;
import mapPackage.IMapFactory;

import java.util.*;

/**
 * Created by Andrew on 03.04.2015.
 */
public class Trie implements ITrie {
    private IMapFactory mapFactory;
    private TrieNode root;

    //nur Extra zur Ausgabe
    int lineLength;

    public Trie(IMapFactory mapFactory) {
        root = new TrieNode(mapFactory);
        this.lineLength = lineLength;
    }

    @Override
    /**
     * Beginn der Rekursiven Inserts.
     */
    public ITrieReference insert (Iterator k, IActionAtInsert a) {
        return root.recursiveInsert(k, a);
    }

    @Override
    public ITrieReference insert (String s, IActionAtInsert a1) {
        return insert(stringToIterator(s), a1);
    }

    /**
     * Wandelt den String erst in ein Char Array um.
     * Anschließend werden die einzelnen Chars in Integers umgewandelt und ein Integer List gespeichert.
     * Die Integer List wird dann in einen Iterator umgewandelt.
     * @param s String der eingelesen wird.
     * @return einen Iterator
     */
    private Iterator stringToIterator (String s) {
        char[] chars = s.toCharArray();
        List<Integer> intList = new ArrayList<Integer>();
        for (int i = 0; i < chars.length; i++) {
            intList.add((int) chars[i]);
        }

        Iterator iterator = intList.iterator();
        return iterator;
    }

    /**
     * Die Rekursive toString Methode.
     * @param lineLength länge des eingelesenen Strings, nicht wichtig nur zur Verschönerung.
     * @return siehe Ausgabe.
     */
    public String myRecursiveToString(int lineLength) {
        return root.firstRec(lineLength);
    }



}
