package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento implements Comparable<Evento>{
//    ATTRIBUTI
    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;
    private final LocalDate dataOdierna = LocalDate.now();

//    COSTRUTTORE

    public Evento(String titolo, LocalDate data, int postiTotali) {
        checkText(titolo);
        this.titolo = titolo;
        checkData(data);
        this.data = data ;
        checkPostiTotali(postiTotali);
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0;
    }

//    GETTER SETTER

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    public LocalDate getDataOdierna() {
        return dataOdierna;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setData(LocalDate data) {
        checkData(data);
        this.data = data;
    }

//    METODI

    public void checkText(String text) throws RuntimeException {
        if (text.isEmpty()){
            throw new RuntimeException("Errore nella compilazione del titolo");
        }
    }
    public void checkData(LocalDate data) throws RuntimeException {
        if (data.isBefore(dataOdierna)){
            throw new RuntimeException("Inserita data già passata");
        }
    }

    public void checkPostiTotali(int postiTotali) throws RuntimeException{
        if (postiTotali < 1){
            throw new RuntimeException("Numero di posti totali non valido");
        }
    }
    public int getPostiDisponibili(){
        return postiTotali - postiPrenotati;
    }

    public void prenota() throws RuntimeException {
        if (dataOdierna.isAfter(data)){
            throw new RuntimeException("La data dell'evento non può essere già passata");
        }
        if (getPostiDisponibili() == 0){
            throw new RuntimeException("Posti disponibili terminati");
        }
        postiPrenotati++;
    }

    public void disdici() throws RuntimeException {
        if (dataOdierna.isAfter(data)){
            throw new RuntimeException("La data dell'evento non può essere già passata");
        }
        if (postiPrenotati == 0){
            throw new RuntimeException("Non ci sono posti prenotati da disdire");
        }
        postiPrenotati --;
    }
    public String getFormatData(LocalDate data){
        DateTimeFormatter dataformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(dataformatter);
    }

    @Override
    public String toString() {
        return "Evento: " + getFormatData(data) + "-" + getTitolo();
    }

    @Override
    public int compareTo(Evento o) {
        int comparaDate = data.compareTo(o.data);
        if (comparaDate == 0){
            return titolo.compareTo(o.titolo);
        }
        return comparaDate;
    }
}
