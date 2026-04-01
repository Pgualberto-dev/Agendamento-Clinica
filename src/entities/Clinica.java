package entities;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Clinica {

    private ZoneId zoneId;
    private List<Consulta> consultasList = new ArrayList<>();
    private int limitePorDia;

    public List<Consulta> getConsultasList() {
        return consultasList;
    }


    public ZoneId getZoneId() {
        return zoneId;
    }
}
