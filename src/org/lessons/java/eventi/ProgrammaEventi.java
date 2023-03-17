package org.lessons.java.eventi;

import java.time.LocalDate;
import java.util.*;

public class ProgrammaEventi {
    private String titolo;
    private List<Evento> eventi;

    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    public String getTitolo() {
        return titolo;
    }

    public void addEvento(Evento evento){
        eventi.add(evento);
    }
    public List<Evento> getEventiFromDate(LocalDate data){
        List<Evento> eventiStessaData = new ArrayList<>();
        for (Evento evento: eventi){
            if (evento.getData().equals(data)){
                eventiStessaData.add(evento);
            }
        }
        return eventiStessaData;
    }
    public int getNumeroEventi(){
        return this.eventi.size();
    }
    public void removeEventi(){
    this.eventi.clear();
    }
    public List<Evento> eventiOrdinati(){
        Collections.sort(eventi);
        return eventi;
    }
}
