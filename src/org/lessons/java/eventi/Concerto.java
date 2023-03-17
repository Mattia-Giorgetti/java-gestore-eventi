package org.lessons.java.eventi;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
    private LocalTime ora;
    private BigDecimal prezzo;


    public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, BigDecimal prezzo) throws RuntimeException {
        super(titolo, data, postiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public String getFormatOra(LocalTime ora){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");
        return ora.format(formatter);
    }
    public String getFormatPrezzo(BigDecimal prezzo){
        DecimalFormat df = new DecimalFormat("##,##");
        return df.format(prezzo);
    }

    @Override
    public String toString() {
        return "Data: " + getFormatData(getData()) + " Ora: " + getFormatOra(ora) + " Titolo: " + getTitolo() + " Prezzo: " + getFormatPrezzo(prezzo) + "€";
    }
}
