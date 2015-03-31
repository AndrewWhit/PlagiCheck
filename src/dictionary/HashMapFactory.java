package dictionary;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrew on 31.03.2015.
 */
public class HashMapFactory implements IMapFactory {

    @Override
    public Map create() {
        return new HashMap();
    }
}
