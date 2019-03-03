package hello;

/* Enable websocket and stomp messaging */

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


/* Enables WebSocket message handling, backed by a message broker. */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS(); //register this endpoint to enable sockJS fallback options in case websocket is not available

    }

    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); /* /topic - destination prefix to which the client has subscribed */
        config.setApplicationDestinationPrefixes("/app"); /* Controller is bound to accept messages sent at path /app/hello */

    }
}

