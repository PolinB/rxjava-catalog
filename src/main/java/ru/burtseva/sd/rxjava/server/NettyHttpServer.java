package ru.burtseva.sd.rxjava.server;

import io.reactivex.netty.protocol.http.server.HttpServer;
import ru.burtseva.sd.rxjava.commands.CommandRunner;
import io.netty.handler.codec.http.HttpResponseStatus;
import rx.Observable;

public class NettyHttpServer {
    private static final CommandRunner commandRunner = new CommandRunner();

    public static void main(final String[] args) {
        HttpServer
            .newServer(8080)
            .start((req, resp) -> {

                String action = req.getDecodedPath().substring(1);

                Observable<String> responseMessage;
                try {
                    responseMessage = commandRunner.process(action, req.getQueryParameters());
                } catch (RuntimeException e) {
                    responseMessage = Observable.just(e.getMessage());
                    resp.setStatus(HttpResponseStatus.BAD_REQUEST);
                }

                return resp.writeString(responseMessage);
            })
            .awaitShutdown();
    }
}
