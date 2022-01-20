package app.consumer_logging.kafka;

import app.consumer_logging.DataModel.Log;
import app.consumer_logging.DataModel.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class KafkaConsumerLog {

    @Autowired
    LogRepository repository;

    @KafkaListener(topics = "${topicLogging}", groupId = "${groupLogging}", containerFactory = "logKafkaListenerFactory")
    public void consumeLog(Log log) {
        System.out.println("Salvo Log: " + log);
        repository.save(log);
    }
}