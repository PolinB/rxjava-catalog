package ru.burtseva.sd.rxjava.db;

import org.bson.Document;

public class User {
    private final int id;
    private final Currency currency;

    public static final String ID = "id";
    public static final String CURRENCY = "currency";

    public User(int id, Currency currency) {
        this.id = id;
        this.currency = currency;
    }

    public User(Document doc) {
        this(doc.getInteger(ID), Currency.valueOf(doc.getString(CURRENCY)));
    }

    public Document toDocument() {
        return new Document(ID, id).append(CURRENCY, currency.toString());
    }

    public int getId() {
        return id;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "User{" +
                ID + "=" + id +
                ", " + CURRENCY + "=" + currency +
                '}';
    }
}

