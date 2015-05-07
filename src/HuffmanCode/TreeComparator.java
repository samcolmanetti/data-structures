package HuffmanCode;

import java.util.Comparator;

public class TreeComparator implements Comparator<HuffmanTree> {
    @Override
    public int compare(HuffmanTree t1, HuffmanTree t2) {
        return t1.compareTo(t2);
    }
}
