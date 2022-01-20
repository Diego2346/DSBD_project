package app.event.DataModel;

import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Optional;


public interface EventRepository extends CrudRepository<Event, Integer> {
    public Optional<Event> findById(Integer id);
    public Iterable<Event> findAllBySquadraCasaOrSquadraOspite(String squadra1,String squadra2);
    public Iterable<Event> findAllByData(Date data);


}
