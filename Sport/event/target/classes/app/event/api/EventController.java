package app.event.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import app.event.DataModel.Event;
import app.event.Service.EventService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping(path="/event")
public class EventController {

    @Autowired
    EventService EventService;

    @GetMapping(path="/{id}")
    public @ResponseBody Event getEvent(@PathVariable Integer id, HttpServletRequest request){
        return EventService.getEvent(id,request);
    }
    @GetMapping(path="/squadra/{squadra}")
    public @ResponseBody Iterable<Event> getEvent(@PathVariable String squadra, HttpServletRequest request){
        return EventService.getEvent(squadra,request);
    }
    @GetMapping(path="/data/{data}")
    public @ResponseBody Iterable<Event> getEvent(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date data, HttpServletRequest request){
        return EventService.getEvent(data,request);
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<Event> getAll(HttpServletRequest request){
        return EventService.getAll(request);
    }

    @PostMapping(path="/add")
    public @ResponseBody Event add(@RequestBody Event event,HttpServletRequest request){
        return EventService.register(event,request);
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody String delete(@PathVariable Integer id, HttpServletRequest request){
       return EventService.delete(id,request);

    }

}
