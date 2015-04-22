package gameoflife;

/**
 * Created by Samuel on 4/22/2015.
 */
public class GOLObject {
    public int x1;
    public int y1;
    public int x2;
    public int y2;

    public GOLObject (int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public boolean pointAt (int x, int y){
        return (x >= x1 && x <= x2) && (y >= y1 && y <= y2);
    }

}
