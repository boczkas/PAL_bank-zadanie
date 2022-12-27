package bank.stan;

import bank.Bank;

import java.util.Scanner;

public class StanZalogowanyKlient implements Stan {
    @Override
    public void uruchom(Bank bank, Scanner scanner) {
        System.out.println("Witam kliencie! Co chcesz zrobic?");

        String wybranaOpcja = "";

        while (!wybranaOpcja.equals("q")) {
            System.out.println(bank.pobierzAkcjeUzytkownika());
            wybranaOpcja = scanner.nextLine();
            switch (wybranaOpcja) {
                case "1":
                    System.out.println(bank.pobierzTekstKlientaDoWyplacaniaPieniedzy());
                    String kwota = scanner.nextLine();
                    bank.wyplacPieniadze(kwota);
                    break;
                case "2":
                    System.out.println(bank.pobierzTekstKlientaDoWplacaniaPieniedzy());
                    kwota = scanner.nextLine();
                    bank.wplacPieniadze(kwota);
                    break;
                case "3":
                    System.out.println(bank.pobierzStanKonta());
                    break;
            }
        }
    }
}
