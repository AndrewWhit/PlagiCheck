package dictionary;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

/**
 * Created by Andrew on 31.03.2015.
 */
public interface ITrie {

    public ItrieReference insert(Iterator k; IActionAtInsert a);
    public ItrieReference insert(String s; a1 IActionAtInsert);

}
