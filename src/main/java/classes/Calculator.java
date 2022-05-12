package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;

public class Calculator {
    public static Supplier<Calculator> instance = Calculator::new;

    public BinaryOperator<Integer> plus = (x, y) -> x + y;
    public BinaryOperator<Integer> minus = (x, y) -> x - y;
    public BinaryOperator<Integer> multiply = (x, y) -> x * y;
    public BinaryOperator<Integer> divide = (x, y) -> y == 0 ? null : x / y; //делить на ноль нельзя (ArithmeticException)

    public UnaryOperator<Integer> pow = x -> x * x;
    public UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    public Predicate<Integer> isPositive = x -> x > 0;

    public Consumer<Integer> println = System.out::println;

    public List<Integer> multipleCalculations(int a, int b) {
        return List.of(
                plus.apply(a, b),
                minus.apply(a, b),
                multiply.apply(a, b),
                divide.apply(a, b)
        );
    }
}
