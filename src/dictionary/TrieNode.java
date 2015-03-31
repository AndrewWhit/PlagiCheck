package dictionary;

import com.sun.deploy.panel.ITreeNode;

import java.util.Map;

/**
 * Created by Andrew on 31.03.2015.
 */
public class TrieNode {

    final private Map outgoingEdgeMap;
    final private ITreeNode parent;
    final private Comparable ingoingPartialKey;

    //Knoten
    public TrieNode(IMapFactory mapFactory, ITrieNode parent, Comparable ingoingPartialKey) {
        this.mapFactory = mapFactory;
        this.outgoingEdgeMap = this.mapFactory.create();
    }
    //Wurzel
    public TrieNode (IMapFactory mapFactory) {

    }
}
