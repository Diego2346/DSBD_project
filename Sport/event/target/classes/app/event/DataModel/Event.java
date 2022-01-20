package app.event.DataModel;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String squadraCasa;
    private String squadraOspite;
    private Integer punteggioCasa;
    private Integer punteggioOspite;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Past
    protected Date data;

    public Integer getId() {
        return id;
    }

    public Event setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public Event setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
        return this;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public Event setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
        return this;
    }

    public Integer getPunteggioCasa() {
        return punteggioCasa;
    }

    public Event setPunteggioCasa(Integer punteggioCasa) {
        this.punteggioCasa = punteggioCasa;
        return this;
    }

    public Integer getPunteggioOspite() {
        return punteggioOspite;
    }

    public Event setPunteggioOspite(Integer punteggioOspite) {
        this.punteggioOspite = punteggioOspite;
        return this;
    }

    public Date getData() {
        return data;
    }

    public Event setData(Date data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", punteggioCasa=" + punteggioCasa +
                ", punteggioOspite=" + punteggioOspite +
                ", data='" + data + '\'' +
                '}';
    }
}
