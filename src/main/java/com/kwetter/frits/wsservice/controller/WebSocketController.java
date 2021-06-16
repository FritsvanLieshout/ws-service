package com.kwetter.frits.wsservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/ws")
public class WebSocketController {

    @Autowired
    SimpMessagingTemplate template;

    private final Logger log = LoggerFactory.getLogger(WebSocketController.class);

    @GetMapping("/notify")
    @SendTo("/queue/timeline")
    public Integer broadcastGroupMessage(@Payload String username, Principal principal) {
        log.info("Sending over WS, notify {} with principal: {}", username, principal.getName());

        template.convertAndSendToUser(principal.getName(), "queue/timeline", 1);

        if (username.equals(principal.getName())) {
            return 1;
        }
        return 0;
    }
}
