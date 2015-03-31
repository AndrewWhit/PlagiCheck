package dictionary;

/**
 * Created by Andrew on 31.03.2015.
 */
public interface IActionAtInsert {

    public Object actionAtKeyNotFound ();

    public Object actionAtKeyFound (Object previous);
}
