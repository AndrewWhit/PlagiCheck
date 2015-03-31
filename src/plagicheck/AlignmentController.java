package plagicheck;

/**
 * Created by Andrew on 27.03.2015.
 */

import java.io.*;


public class AlignmentController {
    final private String original;
    final private String suspect;

    public AlignmentController(String original, String suspect) {
        this.original = original;
        this.suspect = suspect;
    }

    String string = new String("dkfad");

    public void run() throws FileNotFoundException, IOException {
        /* Erstes File lesen */
        InputStream istStreamOriginal = new FileInputStream(original);
        Reader readerOriginal = new InputStreamReader(istStreamOriginal);

        /* später: hier zweites File */

        Ilexer lexer = new SimpleLexer(inputOriginal);
        IToken token = lexer.getNextToken();
        while (token != null) {
            System.out.println("Gelesen: "+token);
            token = lexer.getNextToken();
        }
        /* später: hier Lexer an zweiten Input binden; Leseschleife */
    }
}
