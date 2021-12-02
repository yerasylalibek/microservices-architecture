package kz.app.cart.shopping.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class KafkaListenener {

    Logger LOG = LoggerFactory.getLogger(KafkaListenener.class);

    @KafkaListener(topics = "topic-1", groupId = "topics")
    void listener(String data) {
        LOG.info(data);
    }
//
//    @KafkaListener(
//            topics = "reflectoring-1, reflectoring-2",
//            groupId = "reflectoring-group-2")
//    void commonListenerForMultipleTopics(String message) {
//        LOG.info("MultipleTopicListener - {}", message);
//    }
}
