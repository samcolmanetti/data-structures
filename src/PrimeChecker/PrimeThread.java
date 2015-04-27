package PrimeChecker;

public class PrimeThread extends Thread{
    private Thread t;
    private PrimeChecker pc;
    private int lower;
    private int upper;

    public PrimeThread (PrimeChecker p, int lower, int upper){
        pc = p;
        this.lower = lower;
        this.upper = upper;
    }
    public void run (){
        synchronized (pc) {
            pc.calculate(lower, upper);
        }
    }
}
