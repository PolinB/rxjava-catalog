package ru.burtseva.sd.rxjava.commands;

import ru.burtseva.sd.rxjava.db.MongoDriver;
import ru.burtseva.sd.rxjava.db.User;
import rx.Observable;

import java.util.List;
import java.util.Map;

public class ShowProducts implements Command {
    @Override
    public Observable<String> run(MongoDriver mongoDriver, Map<String, List<String>> queryParameters) {
        return processListProducts(queryParameters);
    }

    public static Observable<String> processListProducts(Map<String, List<String>> queryParameters) {
        int id = Integer.parseInt(queryParameters.get(User.ID).get(0));

        return CommandRunner.mongoDriver.getUser(id).map(User::getCurrency)
                .flatMap(currency -> CommandRunner.mongoDriver.getAllProducts()
                        .map(product -> product.showProduct(currency)));
    }
}
