package bank;

import uzytkownik.Administrator;
import uzytkownik.Klient;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bank {

    private Map<Klient, String> klienciZHaslami = new HashMap<>();
    private Map<Administrator, String> administratorzyZHaslami = new HashMap<>();
    private Map<Klient, Konto> klienciZKontami = new HashMap<>();

    private Klient aktualenieZalogowanyKlient;
    private Administrator aktualenieZalogowanyAdministrator;
    public Bank() {
        this.administratorzyZHaslami.put(new Administrator("a"), "a");
        this.administratorzyZHaslami.put(new Administrator("admin"), "admin");
        Klient klient = new Klient("k", "k");
        this.klienciZHaslami.put(klient, "k");
        this.klienciZKontami.put(klient, new Konto());
    }

    public void zalogujKlienta(String imie, String nazwisko, String haslo) {
    }

    public void zalogujAdministratora(String nazwa, String haslo) {
    }

    public void dodajKlienta(String imie, String nazwisko, String haslo) throws IllegalAccessException {
    }

    public void usunKlienta(String imie, String nazwisko) throws IllegalAccessException {
    }

    public String pobierzTekstLogowaniaKlienta() {
        return "";
    }

    public String pobierzTekstLogowaniaAdministratora() {
        return "";
    }


    public String pobierzRodo() {
        return "";
    }

    public String pobierzPowitanie() {
        return "";
    }

    public String pobierzAkcjeAdministratora() {
        return "";
    }

    public String pobierzTekstAdministratoraDoTworzeniaKlienta() {
        return "";
    }

    public String pobierzTekstAdministratoraDoUsuwaniaKlienta() {
        return "";
    }

    public String pobierzTekstKlientaDoWplacaniaPieniedzy() {
        return "";
    }

    public String pobierzTekstKlientaDoWyplacaniaPieniedzy() {
        return "";
    }

    public Klient getAktualenieZalogowanyKlient() {
        return aktualenieZalogowanyKlient;
    }

    public Administrator getAktualenieZalogowanyAdministrator() {
        return aktualenieZalogowanyAdministrator;
    }

    public boolean czyKlientZalogowany() {
        return this.aktualenieZalogowanyKlient != null;
    }

    public boolean czyAdminZalogowany() {
        return this.aktualenieZalogowanyAdministrator != null;
    }

    public Set<Klient> pobierzWszystkichKlientow() throws IllegalAccessException {
        return Set.of();
    }

    public String pobierzAkcjeUzytkownika() {
        return "";
    }

    public void wplacPieniadze(String kwota) {
    }

    public void wyplacPieniadze(String kwota) {
    }

    public String pobierzStanKonta() {
        return "";
    }
}
