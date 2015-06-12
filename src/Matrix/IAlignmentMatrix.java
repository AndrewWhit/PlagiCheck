package Matrix;

import AlignmentContent.IAlignmentContent;

/**
 * Created by Andrew on 08.06.2015.
 */
public interface IAlignmentMatrix {
    public void set(int i, int j, IAlignmentContent content);
    public IAlignmentContent get (int i, int j);
}
