package myconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import websocket.ChatWebsocketHandler;

@Configuration		// @Component + [@SpringBootApp 시작될 때 같이 한 번만 실행해라]
@EnableWebSocket
public class MyWebsocketConfig implements WebSocketConfigurer {
	@Autowired
	ChatWebsocketHandler websocketHandler;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		System.out.println("websocket 컨피그실행");		// 언제?
		registry.addHandler(websocketHandler, "/chatws").setAllowedOrigins("*");
	}
}
