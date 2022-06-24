package com.bit.sts27.controller.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SocketHandler extends TextWebSocketHandler{
	
	List<WebSocketSession> list = new ArrayList<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//		2 socket.connection 했을 때
		list.add(session);
//		System.out.println("websocket : "+session);
	}

//	@Override
//	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
////		3 socket.send(~) 시 호출 되는 메서드
////		System.out.println(message.getPayload());
//	}
//	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//		System.out.println(message);
		for(WebSocketSession sock:list)
			sock.sendMessage(message);	
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		
//		System.out.println("handleTransportError");

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
//		socket.close - 접속 끊길 때
		list.remove(session);

	}

	@Override
	public boolean supportsPartialMessages() {
//		1
		return false;
	}

}
