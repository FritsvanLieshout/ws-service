package com.kwetter.frits.wsservice.controller;

import com.kwetter.frits.wsservice.entity.TweetTimelineDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/ws")
public class WebSocketController {

    private final Logger log = LoggerFactory.getLogger(WebSocketController.class);

    @MessageMapping("/sendTweet")
    @SendTo("/topic_timeline")
    public TweetTimelineDTO broadcastGroupMessage(@Payload TweetTimelineDTO tweetTimeline) {
        return tweetTimeline;
    }

    @MessageMapping("notify")
    @SendTo("topic_notify")
    public Integer broadcastGroupMessage(@Payload Integer notifyCount, Principal principal) {
        log.info("Notifications: {} , send to: {} ", notifyCount, principal.getName());
        return notifyCount;
    }
}
