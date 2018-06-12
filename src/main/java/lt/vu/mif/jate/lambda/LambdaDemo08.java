package lt.vu.mif.jate.lambda;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LambdaDemo08 extends PersonList {

    public static void main(String[] args) {
        
        // Consumer
        
        StringBuilder nameFirstChars = new StringBuilder();
        Consumer<Person> addFirstChar = p -> { if (!p.getName().isEmpty()) nameFirstChars.append(p.getName().charAt(0)); };
        for (Person p: persons) {
            addFirstChar.accept(p);
        }
        
        System.out.println(nameFirstChars);
        
        // Supplier
        
        Supplier<Person> randomPerson = () -> persons.get(new Random().nextInt(persons.size()));
        
        for (int i = 0; i < 10; i++) {
            System.out.println(randomPerson.get());
        }
        
        // Scope and legality calls
        
        String s1 = "";
        //Consumer<Person> notLegal01 = (p) -> s1 = p.getName();
        
        StringBuilder s2 = new StringBuilder();
        Consumer<Person> legal01 = (p) -> s2.append(p.getName());
        legal01.accept(randomPerson.get());
        
        //Consumer<Person> notLegal02 = (s1) -> s2.append(s1.getName());
        //Consumer<Person> notLegal03 = (p) -> { String s1 = ""; });
        
        
        
    } 
    
}
