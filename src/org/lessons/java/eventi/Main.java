package org.lessons.java.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
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

            boolean makeReservation = false;
            int userChoice = 0;
            System.out.println("Desideri fare una prenotazione? (s/n)");
            makeReservation = scan.nextLine().equalsIgnoreCase("s");
            if (makeReservation){
                boolean valid = false;
                while (!valid){
                    System.out.println("Quanti posti vuoi prenotare?");
                    userChoice = Integer.parseInt(scan.nextLine());

                    if (userChoice < 1 || userChoice > evento.getPostiTotali()){
                        System.out.println("Errore... puoi inserire un numero da 1 a " + evento.getPostiTotali());
                    } else {
                        valid = true;
                        for (int i = 0; i < userChoice ; i++) {
                            evento.prenota();
                        }
                        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
                        System.out.println("Posti disponibili: " + evento.getPostiDisponibili());
                        System.out.println();

                        boolean exit = false;
                        while (!exit){
                            System.out.println("Vuoi disdire o uscire? Disdici (1) | Esci (2)");
                            int userSecondChoice = Integer.parseInt(scan.nextLine());
                            switch (userSecondChoice){
                                case 1:
                                    System.out.println("Quanti dei posti vuoi disdire? Posti attualmente prenotati: " + evento.getPostiPrenotati() );
                                    int postiRestituiti = Integer.parseInt(scan.nextLine());
                                    for (int i = 0; i <postiRestituiti ; i++) {
                                        try {
                                            evento.disdici();
                                        } catch (RuntimeException e){
                                            System.out.println(e.getMessage());
                                        }
                                    }
                                    System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
                                    System.out.println("Posti disponibili: " + evento.getPostiDisponibili());
                                    break;
                                case 2:
                                    exit = true;
                                    System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
                                    System.out.println("Posti disponibili: " + evento.getPostiDisponibili());
                                    System.out.println("Arrivederci");
                                    break;
                                default:
                                    System.out.println("Invalid input");
                            }
                        }
                    }
                }
            } else {
                System.out.println("Arrivederci!");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
//        TEST MILESTONE 3 e 4

        LocalTime orario = LocalTime.of(20,30);
        LocalDate data = LocalDate.of(2023,9,23);
        BigDecimal prezzo = new BigDecimal("49.9990");

        Concerto concerto = new Concerto("Promessi Sposi", data,150,orario,prezzo);
        System.out.println(concerto);

        System.out.println();
        String titolo = "Shakespear Season";
        ProgrammaEventi programmaEventi = new ProgrammaEventi(titolo);

        programmaEventi.addEvento(new Evento("Amleto",data,150));
        programmaEventi.addEvento(new Evento("Giulietta e Romeo",data,250));
        programmaEventi.addEvento(new Evento("Riccardo III",data,95));
        System.out.println(programmaEventi.getEventiFromDate(data));
        System.out.println(programmaEventi.getNumeroEventi());

        scan.close();
    }
}
