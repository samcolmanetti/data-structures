package PrimeChecker;

public class PrimeChecker {
    public int sum;


    public PrimeChecker (){
        sum = 0;
    }
    public void calculate (int lower, int upper){
    for (int i = lower; i < upper; i++)
        if (isPrime(i))
            sum++;
    }
    public static boolean isPrime (int num){
        boolean result = true;
        if (num % 2 == 0 && num > 2)
            result =  false;
        else {
            for (int i = 3; i * i <= num; i+= 2)
                if (num % i == 0) {
                    result = false;
                    break;
                }
        }
        return result;
    }
    public int getSum (){
        return sum;
    }
}
