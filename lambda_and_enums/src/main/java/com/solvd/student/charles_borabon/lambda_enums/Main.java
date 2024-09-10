package com.solvd.student.charles_borabon.lambda_enums;

import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // Predicate: check if number is positive
        Predicate<Integer> isPositive = (n) -> n > 0;
        System.out.println(isPositive.test(5)); // true
        System.out.println("--------------------");

        // Consumer: print a message in uppercase
        Consumer<String> printUpperCase = (s) -> System.out.println(s.toUpperCase());
        printUpperCase.accept("hello world");
        System.out.println("--------------------");

        // Supplier: return a random number between 1 and 100
        Supplier<Integer> random = () -> (int) (Math.random() * 100 + 1);
        System.out.println(random.get());
        System.out.println("--------------------");

        // Function: return the square of a number
        Function<Integer, Integer> square = (n) -> n * n;
        System.out.println(square.apply(5)); // 25
        System.out.println("--------------------");

        // BinaryOperator: return the sum of two numbers
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(5, 10)); // 15
        System.out.println("--------------------");

        // Custom lambda with generics - BiPredicate: check if two numbers are equal
        BiPredicate<Integer, Integer> areEqual = (a, b) -> a.equals(b);
        System.out.println(areEqual.test(5, 5)); // true
        System.out.println("--------------------");

        // enum Operation test
        double a = 5, b = 10;
        for (Operation op : Operation.values()) {
            System.out.println(a + " " + op.getSymbol() + " " + b + " = " + op.apply(a, b));
        }
        System.out.println("--------------------");

        // enum TrafficSignal test
        for (TrafficSignal signal : TrafficSignal.values()) {
            System.out.println(signal);
        }
        System.out.println("--------------------");

        // enum Level test
        for (Level level : Level.values()) {
            System.out.println(level + " - " + level.getMultiplier());
        }
        System.out.println("--------------------");

        // enum Season test
        for (Season season : Season.values()) {
            System.out.println(season + " - " + season.getAvgTemp());
        }
        System.out.println("--------------------");

        // enum Currency test
        for (Currency currency : Currency.values()) {
            System.out.println(currency + " - " + currency.getSymbol());
        }
    }

    // enum Operation
    enum Operation {
        Add("+") {
            @Override
            public double apply(double a, double b) {
                return a + b;
            }
        },
        Subtract("-") {
            @Override
            public double apply(double a, double b) {
                return a - b;
            }
        },
        Multiply("*") {
            @Override
            public double apply(double a, double b) {
                return a * b;
            }
        },
        Divide("/") {
            @Override
            public double apply(double a, double b) {
                return a / b;
            }
        };

        private final String symbol;
        Operation(String symbol) {
            this.symbol = symbol;
        }
        public String getSymbol() { return this.symbol; }
        public abstract double apply(double x, double y);
    }

    // enum TrafficSignal
    enum TrafficSignal {
        RED(60), YELLOW(10), GREEN(30);

        private final int duration;
        TrafficSignal(int duration) { this.duration = duration; }
        public int getDuration() { return this.duration; }
        @Override
        public String toString() { return this.name() + " - " + this.duration + " seconds"; }
    }

    // enum Level
    enum Level {
        EASY(1.0), MEDIUM(1.5), HARD(2.0), EXPERT(3.0);

        private final double multiplier;
        Level(double multiplier) { this.multiplier = multiplier; }
        public double getMultiplier() { return this.multiplier; }
    }

    // enum Season
    enum Season {
        WINTER(-5), SPRING(15), SUMMER(25), FALL(10);

        private final int avgTemp;
        Season(int avgTemp) { this.avgTemp = avgTemp; }
        public int getAvgTemp() { return this.avgTemp; }
    }

    // enum Currency
    enum Currency {
        USD("$"), EUR("€"), GBP("£"), JPY("¥");

        private final String symbol;
        Currency(String symbol) { this.symbol = symbol; }
        public String getSymbol() { return this.symbol; }
    }
}
