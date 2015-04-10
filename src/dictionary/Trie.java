package dictionary;

import java.util.*;

/**
 * Created by Andrew on 03.04.2015.
 */
public class Trie implements ITrie {
    private IMapFactory mapFactory;
    private TrieNode root;

    public Trie(IMapFactory mapFactory) {
        root = new TrieNode(mapFactory);
    }

    @Override
    public ITrieReference insert (Iterator k, IActionAtInsert a) {
        return root.recursiveInsert(k, a);
    }

    @Override
    public ITrieReference insert (String s, IActionAtInsert a1) {
        return insert(stringToIterator(s), a1);
    }

    private Iterator stringToIterator (String s) {
        char[] chars = s.toCharArray();
        List<Integer> intList = new ArrayList<Integer>();
        for (int i = 0; i < chars.length; i++) {
            intList.add((int) chars[i]);
        }
        Iterator iterator = intList.iterator();
        return iterator;
    }

    public String myRecursiveToString() {
        return root.firstRec();
    }



}
