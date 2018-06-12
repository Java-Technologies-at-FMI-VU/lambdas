package lt.vu.mif.jate.lambda;

import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaDemo09 extends PersonList {

    public static void main(String[] args) {
        
        // Static class method
        
        Function<Double, Double> cos = Math::cos; // == (x) -> Math.cos(x)
        System.out.println(cos.apply(Math.PI));

        // Variable instance method
        
        String s = "Alma Matter Vilnensis";
        
        Supplier<String> upper01 = s::toUpperCase; // == (x) -> x.toUpperCase()
        System.out.println(upper01.get());
        
        // Parameter instance method
        
        Function<String, String> upper02 = String::toUpperCase; // == (x) -> x.toUpperCase()
        System.out.println(upper02.apply(s));
        
        // Constructor
        
        Supplier<String> str01 = String::new; // == (x) -> x.toUpperCase()
        System.out.println(str01.get());

        Function<String, String> str02 = String::new; // == (x) -> x.toUpperCase()
        System.out.println(str02.apply(s));
        
    } 
    
}
