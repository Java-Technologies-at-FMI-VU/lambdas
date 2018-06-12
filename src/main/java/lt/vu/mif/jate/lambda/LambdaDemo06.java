package lt.vu.mif.jate.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;

public class LambdaDemo06 extends PersonList {

    /**
     * Iteration 1: specific function
     * @param persons
     * @param name
     * @return 
     */
    private static Person findFirstPersonByName(Collection<Person> persons, String name) {
        for (Person p: persons) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * Iteration 1: specific function
     * @param persons
     * @param age
     * @return 
     */
    private static Person findFirstPersonByAge(Collection<Person> persons, int age) {
        for (Person p: persons) {
            if (p.getAge() == age) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * Iteration 2: with predicate
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
    
    /**
     * Iteration 3: with generics and predicate
     * @param <T>
     * @param collection
     * @param predicate
     * @return 
     */
    private static <T> T findFirst(Collection<T> collection, Predicate<T> predicate) {
        for (T t: collection) {
            if (predicate.test(t)) {
                return t;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println(findFirstPersonByName(persons, "w"));
        System.out.println(findFirstPersonByAge(persons, 10));
     
        System.out.println(findFirstPerson(persons, p -> p.getName().equalsIgnoreCase("t")));
        System.out.println(findFirstPerson(persons, p -> p.getAge() == 23));
        
        System.out.println(findFirst(persons, p -> p.getName().equalsIgnoreCase("u")));
        System.out.println(findFirst(persons, p -> p.getAge() == 38));

        System.out.println(findFirst(persons, p -> p.getAge() > 35 && p.getAge() < 40 && p.getName().length() == 10));
        
        System.out.println(
            findFirst(
                Arrays.asList(new String[]{ "Hello", "my", "dear", "Alma", "Mater", "Vilnensis", "!" }), 
                s -> s.matches(".*(.)\\1.*")
            )
        );
        
    }
    
    
}
