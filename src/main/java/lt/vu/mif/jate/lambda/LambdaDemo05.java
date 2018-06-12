package lt.vu.mif.jate.lambda;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongUnaryOperator;
import lombok.Setter;
import lombok.ToString;

public class LambdaDemo05 {

    public static void main(String[] args) {
        
        // Unary operators
        
        DoubleUnaryOperator duo = x -> x * x;
        System.out.println(duo.applyAsDouble(Math.PI));
        
        IntUnaryOperator iuo = x -> x + x;
        System.out.println(iuo.applyAsInt(123));

        LongUnaryOperator luo = x -> x + 10L;
        System.out.println(luo.applyAsLong(123L));
        
        // Binary operators
        
        DoubleBinaryOperator dbo = (x, y) -> x * y;
        System.out.println(dbo.applyAsDouble(Math.PI, Math.E));
        
        IntBinaryOperator ibo = (x, y) -> x + y;
        System.out.println(ibo.applyAsInt(123, 1234));
        
        LongBinaryOperator lbo = (x, y) -> x + y + 10L;
        System.out.println(lbo.applyAsLong(123L, 124L));

        // Unary predicates
        
        DoublePredicate dp = x -> x > Math.PI;
        System.out.println(dp.test(Math.E));
        
        IntPredicate ip = x -> x != 0;
        System.out.println(ip.test(Integer.SIZE));
        
        LongPredicate lp = x -> x == Long.MIN_VALUE;
        System.out.println(lp.test(-1L * Long.MAX_VALUE));
        
        // Unary consumers
        
        ValueHolder holder = new ValueHolder();
        System.out.println(holder);
        
        DoubleConsumer dc = x -> holder.setDoubleValue(x);
        dc.accept(Math.PI);
        
        IntConsumer ic = x -> holder.setIntValue(x);
        ic.accept(Integer.MAX_VALUE);
        
        LongConsumer lc = x -> holder.setLongValue(x);
        lc.accept(Long.MIN_VALUE);
        
        System.out.println(holder);

        // Providers
        
        DoubleSupplier ds = () -> holder.doubleValue;
        System.out.println(ds.getAsDouble());
        
        IntSupplier is = () -> holder.intValue;
        System.out.println(is.getAsInt());
        
        LongSupplier ls = () -> holder.longValue;
        System.out.println(ls.getAsLong());
        
    }
    
    @Setter
    @ToString
    private static class ValueHolder {
        
        private Long longValue = null;
        private Integer intValue = null;
        private Double doubleValue = null;
        
    }
    
    
}
