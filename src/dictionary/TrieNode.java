package dictionary;

import com.sun.deploy.panel.ITreeNode;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Andrew on 31.03.2015.
 */
public class TrieNode implements ITrieNode {

    final private Map outgoingEdgeMap;
    final private ITrieNode parent;
    final private Comparable ingoingPartialKey;
    final private IMapFactory mapFactory;
    final private TrieReference iTrieReference;

    //Knoten
    public TrieNode(IMapFactory mapFactory, ITrieNode parent, Comparable ingoingPartialKey) {
        this.mapFactory = mapFactory;
        this.parent = parent;
        this.ingoingPartialKey = ingoingPartialKey;
        this.outgoingEdgeMap = this.mapFactory.create();
        this.iTrieReference = new TrieReference (this);
    }
    //Wurzel
    public TrieNode (IMapFactory mapFactory) {
        this.mapFactory = mapFactory;
        this.parent = null;
        this.ingoingPartialKey = null;
        this.outgoingEdgeMap = this.mapFactory.create();
        this.iTrieReference = new TrieReference (this);
    }

    @Override
    public ITrieReference recursiveInsert(Iterator k, IActionAtInsert a) {
        while (k.hasNext()) {
            Integer key = (Integer) k.next();
            //Schlüssel existiert bereits.
            if (outgoingEdgeMap.containsKey(key)) {
                TrieNode value = (TrieNode) outgoingEdgeMap.get(key);
                value.recursiveInsert(k, a);
            }
            //Schlüssel existiert noch nicht.
            else {
                outgoingEdgeMap.put(key, new TrieNode(mapFactory, this, key));
                TrieNode value = (TrieNode) outgoingEdgeMap.get(key);
                value.recursiveInsert(k, a);
            }
        }
        //Schlüsselknoten Ende
        if (iTrieReference.getFound()) {
            return iTrieReference;
        }
        //Kein Schlüsselknoten Ende
        else {
            this.iTrieReference.setAValue(a.actionAtKeyNotFound());
            this.iTrieReference.setFound(true);
        }
        return iTrieReference;
    }

    public String firstRec() {
        StringBuilder sb = new StringBuilder();
        for (Object key : outgoingEdgeMap.keySet()) {
            TrieNode trieString = (TrieNode) outgoingEdgeMap.get(key);
            trieString.recString(trieString, sb, 0);
        }
        return sb.toString();
    }

    public StringBuilder recString(TrieNode trieNode, StringBuilder sb, int level) {
        for (int i = 0; i < level; i++) {
            sb.append(".");
        }
        sb.append((char) Integer.parseInt(trieNode.getIngoingPartialKey().toString()));
        if (trieNode.getITrieReference().getFound()) {
            sb.append(trieNode.getITrieReference().getValue().toString() + "\n");
        }
        else {
            sb.append("\n");
        }
        for (Object key : trieNode.getOutgoingEdgeMap().keySet()) {
            TrieNode trieString = (TrieNode) trieNode.getOutgoingEdgeMap().get(key);
            trieNode.recString(trieString, sb, level + 1);
        }
        return sb;
    }

    public Comparable getIngoingPartialKey() {
        return ingoingPartialKey;
    }

    public Map getOutgoingEdgeMap() {
        return outgoingEdgeMap;
    }

    public ITrieReference getITrieReference () {
        return iTrieReference;
    }

}


