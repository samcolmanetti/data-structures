package PrimeChecker;

public class ThreadTester {
    public static void main (String args[]) throws InterruptedException {
        PrimeChecker pc = new PrimeChecker();
        PrimeThread pt1 = new PrimeThread(pc, 1000000, 1250000);
        PrimeThread pt2 = new PrimeThread(pc, 1250001, 1500000);
        PrimeThread pt3 = new PrimeThread(pc, 1500001, 1750000);
        PrimeThread pt4 = new PrimeThread(pc, 1750001, 2000000);

        pt1.start();
        pt2.start();
        pt3.start();
        pt4.start();

        try {
            pt1.join();
            pt2.join();
            pt3.join();
            pt4.join();
        } catch (Exception e) {
            System.out.println ("Thread interrupted ");
        }
        System.out.println ("Sum: " + pc.getSum());
    }
}
