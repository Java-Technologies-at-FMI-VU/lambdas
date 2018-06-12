package lt.vu.mif.jate.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.RandomStringUtils;

@Getter
@RequiredArgsConstructor
@ToString @EqualsAndHashCode(of = "name")
class Person {
    
    private final String name;
    private final int age;
    
}

abstract class PersonList {
    
    private static final int AGE_MAX = 110;
    private static final int NAME_LEN_MAX = 30;
    private static final int NUMBER_OF_PERSONS = 10000;
    
    @Getter
    protected static final List<Person> persons = new ArrayList<>();
    static {
        Random rand = new Random();
        for (int i = 0; i < NUMBER_OF_PERSONS; i++) {
            persons.add(
                new Person(
                    RandomStringUtils.randomAlphabetic(rand.nextInt(NAME_LEN_MAX)), 
                    rand.nextInt(AGE_MAX)));
        }
    }
    
}