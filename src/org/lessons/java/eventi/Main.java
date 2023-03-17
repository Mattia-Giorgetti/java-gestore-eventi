package org.lessons.java.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ciao! Inserisci un evento");
        try {
        System.out.println("Titolo: ");
        String titolo = scan.nextLine();
        System.out.println("Data evento (anno-mese-giorno): ");
        LocalDate data = LocalDate.parse(scan.nextLine());
        System.out.println("Posti totali evento?");
            int postiTotali = 0;
            try {
                postiTotali = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {}
            Evento evento = new Evento(titolo,data,postiTotali);
            System.out.println(evento);

            int userChoice = 0;
            boolean richiestaPrenotazione = true;
            while (richiestaPrenotazione){

                try {
                    System.out.println("Vuoi effettuare una prenotazione? s/n");
                    richiestaPrenotazione = scan.nextLine().equalsIgnoreCase("s");
                    if (richiestaPrenotazione){
                        System.out.println("Quanti posti vorresti prenotare?");
                        userChoice = Integer.parseInt(scan.nextLine());
                        if (userChoice < 1 || userChoice > evento.getPostiTotali()){
                            System.out.println("Errore... puoi inserire un numero da 1 a " + evento.getPostiTotali());
                        } else {
                            richiestaPrenotazione = false;
                        }
                    }
                } catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }
            for (int i = 0; i < userChoice ; i++) {
                    evento.prenota();
            }
            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            System.out.println("Posti disponibili: " + evento.getPostiDisponibili());

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }




        scan.close();
    }
}
