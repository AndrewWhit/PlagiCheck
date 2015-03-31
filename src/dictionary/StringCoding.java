package dictionary;

/**
 * Created by Andrew on 31.03.2015.
 */
public class StringCoding implements IActionAtInsert {

    @Override
    public Object actionAtKeyFound(Object previous) {
        return null;
    }

    @Override
    public Object actionAtKeyNotFound() {
        return null;
    }
}
