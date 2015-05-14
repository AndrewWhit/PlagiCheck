package lexer;

import actionsPackage.*;
import token.Token;
import triePackage.*;
import mapPackage.IMapFactory;
import mapPackage.TreeMapFactory;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;



/**
 * Created by Andrew on 27.03.2015.
 */
public class SimpleLexer implements ILexer {
    final private IMapFactory mapFactory = new TreeMapFactory(); //DIC
    final private IActionAtInsert action = new StringCoding(4711);
    final private Trie trie;
    private String line;
    private StringTokenizer tk = null;
    //nur Extra für die Aufgabe
    int lineLenth;
    //Scanner klasse zum Einlesen.
    Scanner scanner = new Scanner(System.in);

    //tries für Tokens
    final private Trie identiefier = new Trie(mapFactory);
    final private Trie intCons = new Trie(mapFactory);
    final private Trie wsClass = new Trie(mapFactory);
    final private Trie pMarkClass = new Trie(mapFactory);

    public SimpleLexer () throws IOException {

        line = scanner.nextLine();
        if (line != null) {
            tk = new StringTokenizer(line);
            lineLenth = line.length();
        }


        this.trie = new Trie (mapFactory);
        while (tk.hasMoreTokens()) {
            String buffString = tk.nextToken();
            this.trie.insert(buffString, action);

        }

    }


    public Token getNextToken () throws IOException {
        //Log.println(Log.Urgent, "--> next token");
        Token result = null;
        boolean fountToken = false;
        boolean noMoreToken = false;
        do {
            result = null;
            if (tk != null) {
                if (tk.hasMoreTokens()) {
                    String intermediate = tk.nextToken();
          //          Log.println(Log.Urgent, "--- next token:" + intermediate);
                    //später: result =
                    // trie.insert(intermediate, action);
                    //DIC
            //        result = new Token(-1, 1); //ein dummy!!
                    fountToken = true;
                } else {
                    //neue Zeile lesen
                    tk = null;
                    line = scanner.nextLine();
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
        //Log.println(Log.Urgent, "<-- result token: "+result);
        return result;
        }



    public String decode(Token tk) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("noch nicht implementiert");
    }
    public String toString() {
        return trie.myRecursiveToString(lineLenth);
    }

}

