package framework;

/**
 * Created by Andrew on 27.03.2015.
 */

import com.sun.xml.internal.bind.v2.TODO;
import lexer.*;
import token.IToken;

import java.io.*;
import java.util.Scanner;


public class AlignmentController {
    String original;
    String plagi;

    public AlignmentController(String original, String plagi) {
            this.original = "C:\\Users\\Andrew\\Documents\\Studium\\4. Semester\\Algorithmen\\PlagiCheck\\Text.txt";
            this.plagi = plagi;
    }

    public void run() throws FileNotFoundException, IOException {
        InputStream istreamOriginal = new FileInputStream(new File(original));
        Reader readerOriginal = new InputStreamReader(istreamOriginal);
        PushbackReader inputOriginal = new PushbackReader(readerOriginal, 256);
        ILexer lexer = new FilterLexer(inputOriginal);
        IToken token = lexer.getNextToken();
        while (!token.getTokenName().matches("EOF")) {
            System.out.println(lexer.decode(token));
            token = lexer.getNextToken();
        }
    }
}

