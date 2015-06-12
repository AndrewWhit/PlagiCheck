package Region;

import tokenSequences.ITokenSequence;

/**
 * Created by Andrew on 08.06.2015.
 */
public class Region implements IRegion {
    int x;
    int y;
    int z;
    int q;
    public  Region (int x, int y, int z, int q) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.q = q;
    }
}
