package mapPackage;

import mapPackage.IMapFactory;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Andrew on 31.03.2015.
 */
public class TreeMapFactory implements IMapFactory {

    @Override
    public Map create() {
        return new TreeMap();
    }
}
