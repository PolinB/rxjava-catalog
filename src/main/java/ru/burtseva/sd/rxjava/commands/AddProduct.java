package ru.burtseva.sd.rxjava.commands;

import ru.burtseva.sd.rxjava.db.Currency;
import ru.burtseva.sd.rxjava.db.MongoDriver;
import ru.burtseva.sd.rxjava.db.Product;
import rx.Observable;

import java.util.List;
import java.util.Map;

public class AddProduct implements Command {
    @Override
    public Observable<String> run(MongoDriver mongoDriver, Map<String, List<String>> queryParameters) {
        String name = queryParameters.get(Product.NAME).get(0);
        double cost = Double.parseDouble(queryParameters.get(Product.COST).get(0));
        Currency currency = Currency.valueOf(queryParameters.get(Product.CURRENCY).get(0));
        return mongoDriver.addProduct(new Product(name, cost, currency)).map(success -> "product added success");
    }
}
