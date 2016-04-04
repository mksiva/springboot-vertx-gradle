package hello;

import org.springframework.stereotype.Component;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;

@Component
public class StaticServer extends AbstractVerticle {
	 @Override
	    public void start() throws Exception {
		 vertx.createHttpServer().requestHandler(new Handler<HttpServerRequest>() {
			
			@Override
			public void handle(HttpServerRequest event) {
				event.response()
				//.putHeader("content-type", "application/json")
				.end("Hello from vert.x first app guys!");		
			}
		}).listen(8080);
		 
	    }
}
