package lt.vu.mif.jate.lambda;

import java.util.Arrays;
import java.util.Comparator;

class NameLengthComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().length() - p2.getName().length();
    }
    
}

public class LambdaDemo01 extends PersonList {
    
    public static void main(String[] args) {
        Person[] arr = persons.toArray(new Person[]{ });
        
        // Named class
        
        Arrays.sort(arr, new NameLengthComparator());
        printFirst("Sorted by name ascending", arr, 10);

        // Annonymous class
        
        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getAge() - p2.getAge();
            }
        });
        printFirst("Sorted by age ascending", arr, 10);
        
        // Lambda v01
        
        Arrays.sort(arr, (Person p1, Person p2) -> { return p2.getAge() - p1.getAge(); });
        printFirst("Sorted by age descending", arr, 10);
        
        // Lambda v02
        
        Arrays.sort(arr, (p1, p2) -> { return p2.getName().length() - p1.getName().length(); });
        printFirst("Sorted by name descending", arr, 10);
        
        // Lambda v03
        
        Arrays.sort(arr, (p1, p2) -> 
                p1.getName().length() - p2.getName().length() != 0 ? 
                    p1.getName().length() - p2.getName().length() : 
                    p1.getAge() - p2.getAge());
        printFirst("Sorted by name and age ascending", arr, 10);
        
        // Effectively final variable
        
        StringBuilder sb = new StringBuilder();
        persons.stream().forEach(p -> sb.append(p.getName()));
        System.out.format("All names length: %d%n", sb.length());
                
    }

    private static <T> void printFirst(String title, T[] arr, int len) {
        System.out.println();
        System.out.println(title);
        for (T t: Arrays.copyOf(arr, len)) {
            System.out.println(t);
        }
    }    
}
