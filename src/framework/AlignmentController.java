package framework;

/**
 * Created by Andrew on 27.03.2015.
 */

import lexer.*;
import token.IToken;

import java.io.*;


public class AlignmentController {
    String original;

    public AlignmentController(String original) {
        this.original = original;
    }


    public void run() throws FileNotFoundException, IOException {
        /* Erstes File lesen */
        InputStream istStreamOriginal = new FileInputStream(original);
        Reader readerOriginal = new InputStreamReader(istStreamOriginal);
        BufferedReader inputOriginal = new BufferedReader(readerOriginal);



        /* später: hier zweites File */

        ///lexer.ILexer lexer = new SimpleLexer();
        ILexer lexer = new BaseLexer(new PushbackReader(readerOriginal));
        //String recString = lexer.toString();
        //System.out.println(recString);
        IToken token = lexer.getNextToken();
        //Token Loop
        while (token != null) {
            System.out.println("Gelesen: "+token);
            token = lexer.getNextToken();
        }

        /* später: hier Lexer an zweiten Input binden; Leseschleife */
    }
}
