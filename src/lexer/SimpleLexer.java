package lexer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;


/**
 * Created by Andrew on 27.03.2015.
 */
public class SimpleLexer implements ILexer {
    final private BufferedReader reader;
    final private IMapFactory mapFactory = new TreeMapFactory(); //DIC
    final private IActionAtInsert = new StringCoding(4711); //DIC
    final private ITrie trie; // DIC
    private String line;
    private StringTokenizer tk = null;

    public SimpleLexer (BufferedReader reader) throws IOException {
        this.reader = reader;
        line = reader.readLine();
        if (line != null) {
            tk = new StringTokenizer(line);
        }
        System.out.print("hallo");
        this.trie = new Trie (mapFactory); //DIC
    }

    public IToken getNextToken () throws IOException {
        Log.println(Log.Urgent, "--> next token");
        IToken result = null;
        boolean fountToken = false;
        boolean noMoreToken = false;
        do {
            result = null;
            if (tk != null) {
                if (tk.hasMoreTokens()) {
                    String intermediate = tk.nextToken();
                    Log.println(Log.Urgent, "--- next token:" + intermediate);
                    //später: result =
                    // trie.insert(intermediate, action);
                    //DIC
                    result = new Token(-1, 1); //ein dummy!!
                    fountToken = true;
                } else {
                    //neue Zeile lesen
                    tk = null;
                    line = reader.readLine();
                    if (line != null) {
                        tk = new StringTokenizer(line);
                    }
                }
            }
            else {
                noMoreToken = true;
            }
        }
        while (! fountToken && !noMoreToken);
        Log.println(Log.Urgent, "<-- result token: "+result);
        return result;
        }

    public String decode(IToken tk) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("noch nicht implementiert");
    }
    public String toString() {
        return "\nResult Trie \n"+trie;
    }
}

