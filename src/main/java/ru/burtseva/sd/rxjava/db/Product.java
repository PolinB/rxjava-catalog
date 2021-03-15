package ru.burtseva.sd.rxjava.db;

import org.bson.Document;

public class Product {
    private final String name;
    private final double value;
    private final Currency currency;

    public static final String NAME = "name";
    public static final String COST = "cost";
    public static final String CURRENCY = "currency";

    public Product(String name, double value, Currency currency) {
        this.name = name;
        this.value = value;
        this.currency = currency;
    }

    public Product(Document doc) {
        this(doc.getString(NAME), doc.getDouble(COST), Currency.valueOf(doc.getString(CURRENCY)));
    }

    public Document toDocument() {
        return new Document(NAME, name).
                append(COST, value).
                append(CURRENCY, currency.toString());
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                NAME + "=" + name +
                ", " + COST + "=" + value +
                ", " + CURRENCY + "=" + currency +
                '}';
    }

    public String showProduct(Currency need) {
        return "Product{" +
                NAME + "=" + name +
                ", " + COST + "=" + Currency.convert(currency, value, need) +
                "}\n";
    }
}

