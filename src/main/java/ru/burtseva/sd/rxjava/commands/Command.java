package ru.burtseva.sd.rxjava.commands;

import ru.burtseva.sd.rxjava.db.MongoDriver;
import rx.Observable;

import java.util.List;
import java.util.Map;

public interface Command {
    Observable<String> run(MongoDriver mongoDriver, Map<String, List<String>> queryParameters);
}
