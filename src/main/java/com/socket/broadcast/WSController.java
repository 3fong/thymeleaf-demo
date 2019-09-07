package com.socket.broadcast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author liulei
 * @Description 消息控制器
 * @create 2017/7/30 18:58
 */
@Controller
public class WSController {

    @MessageMapping("/hi")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return new WiselyResponse("hi! " + message.getName());
    }

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        String user = null;
        if ("liu".equals(principal.getName())) {
            user = "lei";
        } else {
            user = "liu";
        }
        messagingTemplate.convertAndSendToUser(user, "/queue/notifications", principal.getName() + "-send:" + msg);
    }
}
