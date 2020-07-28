package effectivejava.chapter7.item42;

import java.util.function.DoubleBinaryOperator;

public enum Operation {
    
    PLUS ("+", (x,y) -> x+y),
    MINUS ("-", (x,y) -> x-y),
    TIMES ("*", (x,y) -> x*y),
    DIVIDE ("/", (x,y) -> x/y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    private Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;

    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }

    @Override
    public String toString() {
        return symbol;
    }
    
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);

        for(Operation op : Operation.values()) {
            System.out.println(op);
            System.out.println(op.apply(x, y));
            System.out.println("");
        }
    }
}