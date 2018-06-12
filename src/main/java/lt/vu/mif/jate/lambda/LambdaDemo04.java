package lt.vu.mif.jate.lambda;

import java.util.function.DoubleUnaryOperator;

public class LambdaDemo04 {

    private static double integrate(DoubleUnaryOperator function, double a, double b, int num){
        
        if (num < 1) {
            num = 1;
        }
        
        double delta = (b - a) / num;
        double start = a + delta / 2;
        double sum = 0;
        
        for (int i = 0; i < num; i++) {
            sum += delta * function.applyAsDouble(start + delta * i);
        }
        
        return sum;
    }
    
    private static void approx(DoubleUnaryOperator f, double a, double b, int num1, int num2, int step) {
        for (int n = num1; n <= num2; n += step) {
            System.out.format("int(%.2f, %.2f, %d) = %f%n", a, b, n, integrate(f, a, b, n));
        }
    }
    
    public static void main(String[] args) {
        
        System.out.println();
        System.out.println("x*x (-10, 10) integration:");
        approx(x -> x*x, -10.0, 10.0, 10, 1000, 100);
        
        System.out.println();
        System.out.println("1 + cos(x) (-1.0, 2.0) integration:");
        approx(x -> 1.0 + Math.cos(x), -1.0, 2.0, 10, 100, 10);
        
        System.out.println();
        System.out.println("sin(x) (-pi, pi) integration:");
        approx(x -> Math.cos(x), -Math.PI, Math.PI, 10, 100, 10);
        
        System.out.println();
        System.out.println("sin(x) (0.0, pi) integration:");
        approx(Math::sin, 0.0, Math.PI, 10, 100, 10);
        
        System.out.println();
        System.out.println("exp(x) (1.0, 1.0) integration:");
        approx(Math::exp, 1.0, 1.0, 10, 100, 10);
        
        System.out.println();
        System.out.println("(x * x) / exp(x) (1.0, 1.0) integration:");
        approx(MyFunction::func, 0.0, 5.0, 10, 100, 10);

    }
    
}
