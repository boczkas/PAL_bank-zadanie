package bank.stan;

import bank.Bank;

import java.util.Scanner;

public class StanZalogowanyAdmin implements Stan {
    @Override
    public void uruchom(Bank bank, Scanner scanner) {
        System.out.println("Witam administratorze! Co chcesz zrobic?");

        String wybranaOpcja = "";

        while (!wybranaOpcja.equals("q")) {
            System.out.println(bank.pobierzAkcjeAdministratora());
            wybranaOpcja = scanner.nextLine();
            switch (wybranaOpcja) {
                case "1":
                    stworzKlienta(bank, scanner);
                    break;
                case "2":
                    usunKlienta(bank, scanner);
                    break;
                case "3":
                    wyswietlKlientow(bank);
                    break;
            }
        }
    }

    private void wyswietlKlientow(Bank bank) {
        try {
            System.out.println(bank.pobierzWszystkichKlientow());
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    private void usunKlienta(Bank bank, Scanner scanner) {
        System.out.println(bank.pobierzTekstAdministratoraDoUsuwaniaKlienta());
        String imie = scanner.nextLine();
        String nazwisko = scanner.nextLine();
        try {
            bank.usunKlienta(imie, nazwisko);
            System.out.println("Usunieto klienta!");
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    private void stworzKlienta(Bank bank, Scanner scanner) {
        System.out.println(bank.pobierzTekstAdministratoraDoTworzeniaKlienta());
        String imie = scanner.nextLine();
        String nazwisko = scanner.nextLine();
        String haslo = scanner.nextLine();
        try {
            bank.dodajKlienta(imie, nazwisko, haslo);
            System.out.println("Stworzono klienta!");
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}
