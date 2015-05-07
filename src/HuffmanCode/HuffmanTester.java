package HuffmanCode;

public class HuffmanTester {
    public static void main (String args[]){
        HuffmanCode h1 = new HuffmanCode("just as fire tempers iron into fine steel so does adversity temper ones character into firmness tolerance and determination");
        System.out.println (h1.text);
        System.out.println (h1.encode());
        System.out.println (h1.decode(h1.encode()));
        System.out.println ();

        HuffmanCode h2 = new HuffmanCode("someone is sitting in the shade today because someone planted a tree a long time ago");
        System.out.println (h2.text);
        System.out.println (h2.encode());
        System.out.println (h2.decode(h2.encode()));
    }
}