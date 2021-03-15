package ru.burtseva.sd.rxjava.db;

public enum Currency {
    RUB(1), EUR(87), USD(73);

    private final double coefficient;

    Currency(double coefficient) {
        this.coefficient = coefficient;
    }

    public static double convert(Currency from, double value, Currency to) {
        return value * from.coefficient / to.coefficient;
    }
}
