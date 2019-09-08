package org.nix.home.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;


@Component
public class RedisMessageListener extends KeyExpirationEventMessageListener {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * Creates new {@link MessageListener} for {@code __keyevent@*__:expired} messages.
     *
     * @param listenerContainer must not be {@literal null}.
     */
    public RedisMessageListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    //key 过期时调用
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("onPMessage pattern " + pattern + " " + " " + message);
        String channel = new String(message.getChannel());
        String str = (String) redisTemplate.getValueSerializer().deserialize(message.getBody());
        System.out.println(str);
        System.out.println(channel);

    }

}
