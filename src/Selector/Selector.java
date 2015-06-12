package Selector;
import Region.IRegion;
import Region.Region;
import tokenSequences.ITokenSequence;

/**
 * Created by Andrew on 08.06.2015.
 */
public class Selector implements ISelector {
    ITokenSequence original;
    ITokenSequence suspect;

    public Selector (ITokenSequence original, ITokenSequence suspect) {
        this.original = original;
        this.suspect = suspect;
    }

    @Override
    public IRegion getRegion() {
        return new Region(0, this.original.length() - 1, 0, this.suspect.length() - 1);
    }
}
