package lt.vu.mif.jate.lambda;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class LambdaDemo07 extends PersonList {

    /**
     * Iteration 1: count average age
     * @param persons
     * @return 
     */
    private static int getAverageOfPersonAge(final Collection<Person> persons) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Person p: persons) {
            sum = sum.add(new BigDecimal(p.getAge()));
        }
        return sum.divide(new BigDecimal(persons.size()), RoundingMode.DOWN).intValue();
    }
    
    /**
     * Iteration 1: count average name length
     * @param persons
     * @return 
     */
    private static int getAverageOfPersonNameLength(final Collection<Person> persons) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Person p: persons) {
            sum = sum.add(new BigDecimal(p.getName().length()));
        }
        return sum.divide(new BigDecimal(persons.size()), RoundingMode.DOWN).intValue();
    }
    
    /**
     * Iteration 2: count average of Function
     * @param persons
     * @param func
     * @return 
     */
    private static int getAverageOfPerson(final Collection<Person> persons, Function<Person, Integer> func) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Person p: persons) {
            sum = sum.add(new BigDecimal(func.apply(p)));
        }
        return sum.divide(new BigDecimal(persons.size()), RoundingMode.DOWN).intValue();
    }

    /**
     * Iteration 3: count average of Function
     * @param <T>
     * @param collection
     * @param func
     * @return 
     */
    private static <T> int getAverageOf(final Collection<T> collection, Function<T, Integer> func) {
        BigDecimal sum = BigDecimal.ZERO;
        for (T t: collection) {
            sum = sum.add(new BigDecimal(func.apply(t)));
        }
        return sum.divide(new BigDecimal(collection.size()), RoundingMode.DOWN).intValue();
    }
    
    /**
     * Iteration 4: apply functions on collection
     * @param <T> collection (initial) type
     * @param <R> result type
     * @param collection collection of Ts
     * @param func calculating R from T
     * @param mapper map from 2x Rs to a single R
     * @param divider do final calc from R to R
     * @return 
     */
    private static <T, R> R getOf(final Collection<T> collection, Function<T, R> func, BinaryOperator<R> mapper, Function<R, R> sumator) {
        R r = null;
        for (T t: collection) {
            r = mapper.apply(r, func.apply(t));
        }
        return sumator.apply(r);
    }
    
    public static void main(String[] args) {
        
        // Pre Java 8
        
        System.out.println(getAverageOfPersonAge(persons));
        System.out.println(getAverageOfPersonNameLength(persons));

        // Function

        System.out.println(getAverageOfPerson(persons, p -> p.getAge()));
        System.out.println(getAverageOfPerson(persons, p -> p.getName().length()));

        // Generic Function
        
        System.out.println(getAverageOf(persons, p -> p.getAge()));
        System.out.println(getAverageOf(persons, p -> p.getName().length()));
        
        // Mapper
        
        System.out.println((Object) getOf(
                persons, 
                p -> new BigDecimal(p.getAge()),
                (d1, d2) -> d2.add(d1 == null ? BigDecimal.ZERO : d1),
                (d1) -> d1.divide(new BigDecimal(persons.size()), RoundingMode.DOWN)));
        
        System.out.println((Object) getOf(
                persons, 
                p -> new BigDecimal(p.getName().length()),
                (d1, d2) -> d2.add(d1 == null ? BigDecimal.ZERO : d1),
                (d1) -> d1.divide(new BigDecimal(persons.size()), RoundingMode.DOWN)));
        
    }
    
    
}
