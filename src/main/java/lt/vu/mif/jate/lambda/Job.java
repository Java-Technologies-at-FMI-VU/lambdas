package lt.vu.mif.jate.lambda;

import java.util.Collection;

@FunctionalInterface
public interface Job<T> {

    public T execute(Collection<Person> persons);
    
}
