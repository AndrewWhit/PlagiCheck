package framework;

/**
 * Created by Andrew on 27.03.2015.
 */

import lexer.*;

import java.io.FileNotFoundException;
import java.io.IOException;


public class AlignmentController {


    public AlignmentController() {

    }


    public void run() throws FileNotFoundException, IOException {
        /* Erstes File lesen */
        /*InputStream istStreamOriginal = new FileInputStream(original);
        Reader readerOriginal = new InputStreamReader(istStreamOriginal);
        BufferedReader inputOriginal = new BufferedReader(readerOriginal);
        */
        /* später: hier zweites File */

        lexer.ILexer lexer = new SimpleLexer();
        String recString = lexer.toString();
        System.out.println(recString);
        /*IToken token = lexer.getNextToken();
        while (token != null) {
            System.out.println("Gelesen: "+token);
            token = lexer.getNextToken();
        }

        /* später: hier Lexer an zweiten Input binden; Leseschleife */
    }
}
