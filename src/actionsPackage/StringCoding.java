package actionsPackage;

import actionsPackage.IActionAtInsert;

/**
 * Created by Andrew on 31.03.2015.
 */
public class StringCoding implements IActionAtInsert {

    private int counter = 0;

    public StringCoding (int start) {
        this.counter = start;
    }

    public void setActualValue (int updateValue) {
        this.counter = updateValue;
    }

    @Override
    public Object actionAtKeyFound(Object previous) {
        return previous;
    }

    @Override
    public Object actionAtKeyNotFound() {
        return new Integer(counter++);
    }

    public String toString () {
        return "Counter = "+counter;
    }
}
