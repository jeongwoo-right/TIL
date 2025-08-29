package websocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class ChatWebsocketHandler implements WebSocketHandler {

	List<WebSocketSession> list = new ArrayList<WebSocketSession>();	
	
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 웹소켓 요청 최초 연결 시 1번 실행
		System.out.println(session.getRemoteAddress() + " 에서 접속했습니다."); 	// 웹소켓 요청 ip
		
		list.add(session);
		
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// 웹소켓 연결 중 여러 번 실행
		System.out.println(session.getRemoteAddress() + " 에서 접속중입니다."); 	// 웹소켓 요청 ip
		
		// websocket.send 함수 호출 = 서버로 메세지 전달했을 때 자동
		String msg = (String) message.getPayload();
		for (WebSocketSession socket : list) {
			WebSocketMessage sendMsg = new TextMessage(msg);
			socket.sendMessage(message);
			
			
		}
	}


	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// [연결 해제] 연결 해제 시 1번 실행, 웹소캣 요청했던 클라이언트가 연결을 끊겠다
		System.out.println(session.getRemoteAddress() + " 에서 접속 해제했습니다."); 	// 웹소켓 요청 ip
		list.remove(session);
	}

	
	
	
	
	
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// (필수 구현 X) 에러 발생할 때 사용
	}

	
	@Override
	public boolean supportsPartialMessages() {
		// 공백 (비워두겠다), return type만 넣어두기
		
		return false;
	}
}
