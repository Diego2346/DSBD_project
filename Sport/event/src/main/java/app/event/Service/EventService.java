package app.event.Service;


import app.event.DataModel.EventLog;
import app.event.DataModel.EventRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import app.event.DataModel.Event;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Date;

@Service
@Transactional
public class EventService {
    @Autowired
    EventRepository repository;
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    @Value("${topicLogging}")
    private String topicLogging;

    //GET
    public Event getEvent(Integer id, HttpServletRequest request){
        if(!repository.existsById(id)) {
            sendKafkaLog(Instant.now().getEpochSecond(), request.getRemoteAddr(), request.getMethod().concat(" ").concat(request.getRequestURI()),404);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
        sendKafkaLog(Instant.now().getEpochSecond(), request.getRemoteAddr(), request.getMethod().concat(" ").concat(request.getRequestURI()),200);
        return repository.findById(id).get();
    }
    public Iterable<Event> getEvent(String squadra, HttpServletRequest request){
        if(!repository.findAllBySquadraCasaOrSquadraOspite(squadra,squadra).iterator().hasNext()) {
            sendKafkaLog(Instant.now().getEpochSecond(), request.getRemoteAddr(), request.getMethod().concat(" ").concat(request.getRequestURI()),404);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
        sendKafkaLog(Instant.now().getEpochSecond(), request.getRemoteAddr(), request.getMethod().concat(" ").concat(request.getRequestURI()),200);
        return repository.findAllBySquadraCasaOrSquadraOspite(squadra,squadra);

    }
    public Iterable<Event> getEvent(Date data, HttpServletRequest request){
        if (!repository.findAllByData(data).iterator().hasNext()) {
            sendKafkaLog(Instant.now().getEpochSecond(), request.getRemoteAddr(), request.getMethod().concat(" ").concat(request.getRequestURI()),404);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
        sendKafkaLog(Instant.now().getEpochSecond(), request.getRemoteAddr(), request.getMethod().concat(" ").concat(request.getRequestURI()),200);
        return repository.findAllByData(data);

    }
    public Iterable<Event> getAll(HttpServletRequest request){
        sendKafkaLog(Instant.now().getEpochSecond(), request.getRemoteAddr(), request.getMethod().concat(" ").concat(request.getRequestURI()),200);
        return repository.findAll();    }

    //POST
    public Event register(Event user,HttpServletRequest request){
        sendKafkaLog(Instant.now().getEpochSecond(), request.getRemoteAddr(), request.getMethod().concat(" ").concat(request.getRequestURI()),200);
        return repository.save(user);
    }


    //DELETE
    public String delete(Integer id, HttpServletRequest request){
        if(!repository.existsById(id)) {
            sendKafkaLog(Instant.now().getEpochSecond(), request.getRemoteAddr(), request.getMethod().concat(" ").concat(request.getRequestURI()),404);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
        repository.deleteById(id);
        sendKafkaLog(Instant.now().getEpochSecond(), request.getRemoteAddr(), request.getMethod().concat(" ").concat(request.getRequestURI()),200);
        return "Evento con id: " + id + " cancellato";

    }

    public void sendKafkaLog(Long timestamp, String sourceIp, String request, Integer status) {
        EventLog log = new EventLog();
        log.setTimestamp(timestamp);
        log.setSourceIp(sourceIp);
        log.setRequest(request);
        log.setStatus(status);
        kafkaTemplate.send(topicLogging, "http_response", new Gson().toJson(log));
        System.out.println("Invio:" + new Gson().toJson(log));
      }
}

