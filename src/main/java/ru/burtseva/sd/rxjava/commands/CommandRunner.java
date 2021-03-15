package ru.burtseva.sd.rxjava.commands;

import ru.burtseva.sd.rxjava.db.MongoDriver;
import rx.Observable;

import java.util.List;
import java.util.Map;

public class CommandRunner {
    static MongoDriver mongoDriver = new MongoDriver();

    public Observable<String> process(String command, Map<String, List<String>> parameters) {
        return getCommandByName(command).run(mongoDriver, parameters);
    }

    private Command getCommandByName(String command) {
        switch (command) {
            // curl -X GET http://localhost:8080/add-user?id=2\&currency=RUB
            case "add-user":
                return new AddUser();
            // curl -X GET http://localhost:8080/add-product?name=2\&cost=10\&currency=RUB
            case "add-product":
                return new AddProduct();
            // curl -X GET http://localhost:8080/show?id=2
            case "show":
                return new ShowProducts();
            default:
                throw new RuntimeException("Unknown command");
        }
    }
}
