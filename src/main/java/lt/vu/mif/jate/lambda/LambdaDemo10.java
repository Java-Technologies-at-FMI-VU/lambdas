package lt.vu.mif.jate.lambda;

import java.util.Collection;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Predicate;

public class LambdaDemo10 extends PersonList {

    /**
     * Find first with predicate
     * @param persons
     * @param predicate
     * @return 
     */
    private static Person findFirstPerson(Collection<Person> persons, Predicate<Person> predicate) {
        for (Person p: persons) {
            if (predicate.test(p)) {
                return p;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        
        // Composite predicate
        
        Predicate<Person> nameFromA = p -> p.getName().startsWith("A");
        System.out.println(findFirstPerson(persons, nameFromA));
        
        Predicate<Person> andAge20 = nameFromA.and(p -> p.getAge() == 20);
        System.out.println(findFirstPerson(persons, andAge20));
        System.out.println(findFirstPerson(persons, andAge20.negate()));
        System.out.println(findFirstPerson(persons, andAge20.or(p -> p.getAge() > 90)));

        // Composite function
        
        DoubleUnaryOperator square = x -> x * 2;
        System.out.println(square.applyAsDouble(2));
        System.out.println(square.andThen(x -> x * x).applyAsDouble(4));
        System.out.println(square.compose(x -> x * x).applyAsDouble(4));
        
        System.out.println(DoubleUnaryOperator.identity().applyAsDouble(2));
        
    }
    
}
