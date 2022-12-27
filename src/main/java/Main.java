import bank.Bank;
import bank.stan.Stan;
import bank.stan.StanZalogowanyAdmin;
import bank.stan.StanZalogowanyKlient;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(bank.pobierzPowitanie());

            String userInput = scanner.nextLine();

            Stan stan = null;
            switch (userInput) {
                case "1":
                    System.out.println(bank.pobierzTekstLogowaniaKlienta());
                    String imie = scanner.nextLine();
                    String nazwisko = scanner.nextLine();
                    String hasloKlienta = scanner.nextLine();
                    bank.zalogujKlienta(imie, nazwisko, hasloKlienta);
                    if (bank.czyKlientZalogowany()) {
                        stan = new StanZalogowanyKlient();
                    }
                    break;
                case "2":
                    System.out.println(bank.pobierzTekstLogowaniaAdministratora());
                    String nazwa = scanner.nextLine();
                    String haslo = scanner.nextLine();
                    bank.zalogujAdministratora(nazwa, haslo);
                    if (bank.czyAdminZalogowany()) {
                        stan = new StanZalogowanyAdmin();
                    }
                    break;
                case "3":
                    System.out.println(bank.pobierzRodo());
                    break;
            }

            if (stan != null) {
                stan.uruchom(bank, scanner);
            }
        }
    }
}
