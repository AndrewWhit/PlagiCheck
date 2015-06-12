package framework;

/**
 * Created by Andrew on 27.03.2015.
 */

import java.io.*;

import Alignment.Aligner;
import Alignment.IAligner;
import Matrix.IAlignmentMatrix;
import Presenter.IPresenter;
import Presenter.Presenter;
import Region.IRegion;
import Scoring.IScoring;
import Scoring.SimpleScoring;
import Selector.ISelector;
import Selector.Selector;
import lexer.*;
import token.IToken;
import tokenSequences.ITokenSequence;
import tokenSequences.TokenSequence;


public class AlignmentController {
    String original;
    String suspect;
    ILexer lexer = new FilterLexer();

    public AlignmentController(String original, String plagi) {
            this.original = "C:\\Users\\Andrew\\Documents\\Studium\\4. Semester\\Algorithmen\\PlagiCheck\\Text.txt";
            this.suspect = plagi;
    }

    public void runAufgabe2 () throws FileNotFoundException, IOException {
        //Einlesen und Tokenizen vom Original
        InputStream istreamOriginal = new FileInputStream(new File(original));
        Reader readerOriginal = new InputStreamReader(istreamOriginal);
        PushbackReader inputOriginal = new PushbackReader(readerOriginal, 256);
        lexer.setPushbackReader(inputOriginal);
        IToken token = lexer.getNextToken();
        while (!token.getTokenName().matches("EOF")) {
            System.out.println(lexer.decodeAufgabe2(token));
            token = lexer.getNextToken();
        }
    }
    /*
    public void run() throws FileNotFoundException, IOException {
        ITokenSequence originalSequence = convertToSequences(original);
        ITokenSequence suspectSequence = convertToSequences(suspect);
        IScoring scoring = new SimpleScoring();
        ISelector selector = new Selector(originalSequence, suspectSequence);
        IRegion region = selector.getRegion();
        IAligner aligner = new Aligner(originalSequence, suspectSequence, scoring, region);
        IAlignmentMatrix matrix = aligner.forward();
        IPresenter presenter = new Presenter(matrix, lexer, originalSequence, suspectSequence);
        String presentation = presenter.threeColumnOutput();
        System.out.println(presentation);
    }
    */

    private ITokenSequence convertToSequences (String textFile) throws FileNotFoundException, IOException{
        ITokenSequence tokenSequence = new TokenSequence();
        InputStream istreamOriginal = new FileInputStream(new File(original));
        Reader readerOriginal = new InputStreamReader(istreamOriginal);
        PushbackReader inputOriginal = new PushbackReader(readerOriginal, 256);
        lexer.setPushbackReader(inputOriginal);
        IToken token = lexer.getNextToken();
        while (!token.getTokenName().matches("EOF")) {
            tokenSequence.add(token);
            token = lexer.getNextToken();
        }
        return tokenSequence;
    }
}

