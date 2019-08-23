package com.yk.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

//外置web服务器运行，屏蔽@Configuration
@Configuration
public class WebSocketConfig {
	@Bean
	public ServerEndpointExporter serverEndpointExporer(){
		return new ServerEndpointExporter();
	}
	
}
