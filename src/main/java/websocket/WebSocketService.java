package websocket;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Service;
@ServerEndpoint("/ws")
@Service
public class WebSocketService {
	/*@OnOpen
	public void onOpen(){
		System.out.println("开启websocket链接。。。");
	}
	
	@OnMessage
	public void onMessage(String msg){
		System.out.println("传输消息。。。"+msg);
	}
	
	@OnClose
	public void onClosed(){
		System.out.println("关闭websocket链接。。。");
	}*/
	
	 private static int onlineCount=0;
	    private static CopyOnWriteArrayList<WebSocketService> webSocketSet=new CopyOnWriteArrayList<WebSocketService>();
	    private Session session;
	 
	    @OnOpen
	    public void onOpen(Session session){
	        this.session=session;
	        webSocketSet.add(this);//加入set中
	        addOnlineCount();
	        System.out.println("有新连接加入！当前在线人数为"+getOnlineCount());
	    }
	 
	    @OnClose
	    public void onClose(){
	        webSocketSet.remove(this);
	        subOnlineCount();
	        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
	    }
	 
	    @OnMessage
	    public void onMessage(String message,Session session){
	        System.out.println("来自客户端的消息："+message);
//	        群发消息
	        for (WebSocketService item:webSocketSet){
	            try {
	                item.sendMessage(message);
	            } catch (IOException e) {
	                e.printStackTrace();
	                continue;
	            }
	        }
	    }
	 
	    @OnError
	    public void onError(Session session,Throwable throwable){
	        System.out.println("发生错误！");
	        throwable.printStackTrace();
	    }
	//   下面是自定义的一些方法
	    public void sendMessage(String message) throws IOException {
	        this.session.getBasicRemote().sendText(message);
	    }
	    
	    public static synchronized int getOnlineCount(){
	        return onlineCount;
	    }
	    public static synchronized void addOnlineCount(){
	    	WebSocketService.onlineCount++;
	    }
	    public static synchronized void subOnlineCount(){
	    	WebSocketService.onlineCount--;
	    }


}
