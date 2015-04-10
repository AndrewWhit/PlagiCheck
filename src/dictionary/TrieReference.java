package dictionary;

import java.util.Objects;

/**
 * Created by Andrew on 31.03.2015.
 */
public class TrieReference implements ITrieReference {
    boolean found = false;
    Object value;
    ITrieNode iTrieNode;

    //Konstruktor
    public TrieReference (TrieNode trieNode) {
        this.iTrieNode = trieNode;
    }

    @Override
    public boolean getFound() {
        return found;
    }

    public void setFound (boolean result) {
        this.found = result;
    }

    @Override
    public Object getValue() {
        return value;
    }

    public void setAValue (Object object) {
        this.value = object;
    }

    @Override
    public ITrieNode getNode() {
        return iTrieNode;
    }
}
