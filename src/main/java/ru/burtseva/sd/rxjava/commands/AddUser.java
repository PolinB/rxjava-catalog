package ru.burtseva.sd.rxjava.commands;

import ru.burtseva.sd.rxjava.db.Currency;
import ru.burtseva.sd.rxjava.db.MongoDriver;
import ru.burtseva.sd.rxjava.db.User;
import rx.Observable;

import java.util.List;
import java.util.Map;

public class AddUser implements Command {
    @Override
    public Observable<String> run(MongoDriver mongoDriver, Map<String, List<String>> queryParameters) {
        int id = Integer.parseInt(queryParameters.get(User.ID).get(0));
        Currency currency = Currency.valueOf(queryParameters.get(User.CURRENCY).get(0));
        return mongoDriver.addUser(new User(id, currency)).map(success -> "user added success");
    }
}
