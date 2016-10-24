package ticketinco.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Horario {

    private Date hora;

    private Evento evento;
    private List<Disponibilidad> disponibilidades = new ArrayList<>();

}
