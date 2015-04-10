package dictionary;

import java.util.Iterator;

/**
 * Created by Andrew on 03.04.2015.
 */
public interface ITrieNode {

    public ITrieReference recursiveInsert(Iterator k, IActionAtInsert a);

}
