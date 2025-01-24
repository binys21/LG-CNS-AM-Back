package ex03;

public class MainforCalculator {
    public static void main(String[] args) {
        final long num=1000L;

        ImpCalculator imp =new ImpCalculator();
        long start1=System.nanoTime();
        imp.factorial(num);
        long end1=System.nanoTime();
        System.out.printf("ImpCalculator.factorial(%d) 실행시간 = %d\n", num, (end1-start1));

        RecCalculator rec =new RecCalculator();
        long start2=System.nanoTime();
        rec.factorial(num);
        long end2=System.nanoTime();
        System.out.printf("RecCalculator.factorial(%d) 실행시간 = %d\n", num, (end2-start2));

    }
}
