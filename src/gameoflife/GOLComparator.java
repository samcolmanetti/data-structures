package gameoflife;

import java.util.Comparator;

/**
 * Created by samso_000 on 4/22/2015.
 */
public class GOLComparator implements Comparator<GOLBoard> {

    @Override
    public int compare(GOLBoard left, GOLBoard right) {
        return left.compareTo(right);
    }
}
