package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uzytkownik.Administrator;
import uzytkownik.Klient;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {

    Bank bank;

    @BeforeEach
    public void setup() {
        bank = new Bank();
    }

    @Test
    public void pobierzPowitanie_zwracaPowitanie() {
        String actual = bank.pobierzPowitanie();

        assertThat(actual).isEqualTo("1. Zaloguj klienta\n2. Zaloguj administratora\n3. Wyswietl RODO\n");
    }

    @Test
    public void pobierzRodo_zwracaTekstRodo() {
        String actual = bank.pobierzRodo();

        assertThat(actual).isEqualTo("Tu powinno byc RODO");
    }

    @Test
    public void pobierzTekstLogowaniaKlienta_zwracaTekstLogowania() {
        String actual = bank.pobierzTekstLogowaniaKlienta();

        assertThat(actual).isEqualTo("Podaj kolejno (po zatwierdzeniu enterem kazdego): " +
                "imie, nazwisko, haslo uzytkownika");
    }

    @Test
    public void pobierzTekstKlientaDoWyplacaniaPieniedzy_zwracaPoprawnyTekst() {
        String actual = bank.pobierzTekstKlientaDoWyplacaniaPieniedzy();

        assertThat(actual).isEqualTo("Podaj kwote wyplaty");
    }

    @Test
    public void pobierzTekstLogowaniaAdministratora_zwracaPoprawnyTekst() {
        String actual = bank.pobierzTekstLogowaniaAdministratora();

        assertThat(actual).isEqualTo("Podaj kolejno (po zatwierdzeniu enterem kazdego): nazwe, haslo administratora");
    }

    @Test
    public void pobierzTekstAdministratoraDoTworzeniaKlienta_zwracaPoprawnyTekst() {
        String actual = bank.pobierzTekstAdministratoraDoTworzeniaKlienta();

        assertThat(actual).isEqualTo("Podaj kolejno (po zatwierdzeniu enterem kazdego): " +
                "imie, nazwisko, haslo uzytkownika");
    }

    @Test
    public void pobierzTekstAdministratoraDoUsuwaniaKlienta_zwracaPoprawnyTekst() {
        String actual = bank.pobierzTekstAdministratoraDoUsuwaniaKlienta();

        assertThat(actual).isEqualTo("Podaj kolejno (po zatwierdzeniu enterem kazdego):" +
                " imie, nazwisko uzytkownika");
    }

    @Test
    public void pobierzAkcjeAdministratora_zwracaAkcjeAdministratora() {
        String actual = bank.pobierzAkcjeAdministratora();

        assertThat(actual).isEqualTo("1. Stworz klienta\n2. Usun klienta\n3. Wyswietl wszystkich klientow");
    }

    @Test
    public void pobierzAkcjeKlienta_zwracaAkcjeKlienta() {
        String actual = bank.pobierzAkcjeUzytkownika();

        assertThat(actual).isEqualTo("1. Wyplac pieniadze\n2. Wplac pieniadze\n3. Wyswietl stan konta");
    }

    @Test
    public void pobierzTekstKlientaDoWplacaniaPieniedzy_zwracaTekstKlientaDoWplacaniaPieniedzy() {
        String actual = bank.pobierzTekstKlientaDoWplacaniaPieniedzy();

        assertThat(actual).isEqualTo("Podaj kwote do wplaty");
    }

    @Test
    public void zalogujAdministratora_poprawneDane_administratorZalogowany() {
        bank.zalogujAdministratora("a", "a");

        Administrator aktualenieZalogowanyAdministrator = bank.getAktualenieZalogowanyAdministrator();
        Klient aktualenieZalogowanyKlient = bank.getAktualenieZalogowanyKlient();

        assertThat(aktualenieZalogowanyAdministrator).isEqualTo(new Administrator("a"));
        assertThat(aktualenieZalogowanyKlient).isNull();
    }

    @Test
    public void zalogujAdministratora_niepoprawnaNazwa_administratorNieZalogowany() {
        bank.zalogujAdministratora("niepoprawnaNazwa", "");

        Administrator aktualenieZalogowany = bank.getAktualenieZalogowanyAdministrator();

        assertThat(aktualenieZalogowany).isNull();
    }

    @Test
    public void zalogujAdministratora_niepoprawneHaslo_administratorNieZalogowany() {
        bank.zalogujAdministratora("regular", "bledneHaslo");

        Administrator aktualenieZalogowany = bank.getAktualenieZalogowanyAdministrator();

        assertThat(aktualenieZalogowany).isNull();
    }

    @Test
    public void zalogujKlienta_poprawneDane_klientZalogowany() {
        bank.zalogujKlienta("k", "k", "k");

        Administrator aktualenieZalogowanyAdministrator = bank.getAktualenieZalogowanyAdministrator();
        Klient aktualenieZalogowanyKlient = bank.getAktualenieZalogowanyKlient();

        assertThat(aktualenieZalogowanyAdministrator).isNull();
        assertThat(aktualenieZalogowanyKlient).isEqualTo(new Klient("k", "k"));
    }

    @Test
    public void zalogujKlienta_niepoprawneImie_klientNieZalogowany() {
        bank.zalogujKlienta("test", "k", "k");

        Klient aktualenieZalogowanyKlient = bank.getAktualenieZalogowanyKlient();

        assertThat(aktualenieZalogowanyKlient).isNull();
    }

    @Test
    public void zalogujKlienta_niepoprawneNazwisko_klientNieZalogowany() {
        bank.zalogujKlienta("k", "test", "k");

        Klient aktualenieZalogowanyKlient = bank.getAktualenieZalogowanyKlient();

        assertThat(aktualenieZalogowanyKlient).isNull();
    }

    @Test
    public void zalogujKlienta_niepoprawneHaslo_klientNieZalogowany() {
        bank.zalogujKlienta("k", "k", "test");

        Klient aktualenieZalogowanyKlient = bank.getAktualenieZalogowanyKlient();

        assertThat(aktualenieZalogowanyKlient).isNull();
    }

    @Test
    public void czyKlientZalogowany_klientZalogowany_true() {
        bank.zalogujKlienta("k", "k", "k");

        boolean actual = bank.czyKlientZalogowany();

        assertThat(actual).isTrue();
    }

    @Test
    public void czyKlientZalogowany_klientNieZalogowany_false() {
        boolean actual = bank.czyKlientZalogowany();

        assertThat(actual).isFalse();
    }


    @Test
    public void dodajKlienta_adminNieZalogowany_rzuconyWyjatek() {
        IllegalAccessException exception =
                assertThrows(IllegalAccessException.class,
                () -> bank.dodajKlienta("", "", ""));

        assertThat(exception).hasMessage("Nie mozna dodawac klienta, gdy administrator nie jest zalogowany");
    }

    @Test
    public void dodajKlienta_adminZalogowany_klientDodany() throws Exception {
        String imie = "imie";
        String nazwisko = "nazwisko";
        bank.zalogujAdministratora("a", "a");

        bank.dodajKlienta(imie, nazwisko, "1234");
        Set<Klient> klienci = bank.pobierzWszystkichKlientow();

        assertThat(klienci).containsExactly(new Klient("k", "k"), new Klient(imie, nazwisko));
    }

    @Test
    public void dodajKlienta_adminZalogowany_istniejacyKlient_rzuconyWyjatek() throws Exception {
        String imie = "imie";
        String nazwisko = "nazwisko";
        bank.zalogujAdministratora("a", "a");

        bank.dodajKlienta(imie, nazwisko, "1234");

        IllegalAccessException exception = assertThrows(IllegalAccessException.class,
                () -> bank.dodajKlienta(imie, nazwisko, "1234"));
        assertThat(exception).hasMessage("Taki klient juz istnieje!");
    }

    @Test
    public void usunKlienta_adminNieZalogowany_rzuconyWyjatek() {
        IllegalAccessException exception = assertThrows(IllegalAccessException.class,
                () -> bank.usunKlienta("", ""));
        assertThat(exception).hasMessage("Nie mozna usuwac klienta, gdy administrator nie jest zalogowany");
    }

    @Test
    public void usunKlienta_adminZalogowany_nieIstniejacyKlient_rzuconyWyjatek() {
        bank.zalogujAdministratora("a", "a");

        IllegalAccessException exception = assertThrows(IllegalAccessException.class,
                () -> bank.usunKlienta("u", "u"));
        assertThat(exception).hasMessage("Nie mozna usunac nieistniejacego klienta!");
    }

    @Test
    public void usunKlienta_adminZalogowany_istniejacyKlient_klientUsuniety() throws Exception {
        String imie = "imie";
        String nazwisko = "nazwisko";
        String imie2 = "imie2";
        String nazwisko2 = "nazwisko2";
        bank.zalogujAdministratora("a", "a");
        bank.dodajKlienta(imie, nazwisko, "1234");
        bank.dodajKlienta(imie2, nazwisko2, "1234");

        bank.usunKlienta(imie, nazwisko);
        Set<Klient> klienci = bank.pobierzWszystkichKlientow();

        assertThat(klienci).containsExactly(new Klient("k", "k"), new Klient(imie2, nazwisko2));
    }

    @Test
    public void pobierzWszystkichKlientow_adminZalogowany_zwroconaListaKlientow() throws Exception {
        String imie = "imie";
        String nazwisko = "nazwisko";
        String imie2 = "imie2";
        String nazwisko2 = "nazwisko2";
        bank.zalogujAdministratora("a", "a");

        bank.dodajKlienta(imie, nazwisko, "1234");
        bank.dodajKlienta(imie2, nazwisko2, "1234");
        Set<Klient> klienci = bank.pobierzWszystkichKlientow();

        assertThat(klienci).containsExactly(new Klient("k", "k"), new Klient(imie, nazwisko),
                new Klient(imie2, nazwisko2));
    }

    @Test
    public void pobierzWszystkichKlientow_adminNieZalogowany_rzuconyWyjatek() {
        IllegalAccessException exception =
                assertThrows(IllegalAccessException.class,
                        () -> bank.pobierzWszystkichKlientow());

        assertThat(exception).hasMessage("Nie mozna wyswietlac uzytkownikow, gdy administrator nie jest zalogowany");
    }

    @Test
    public void wplacPieniadze_poprawnaKwota_stanKontaZaktualizowany() {
        bank.zalogujKlienta("k", "k", "k");

        bank.wplacPieniadze("100");

        assertThat(bank.pobierzStanKonta()).isEqualTo("100");
    }

    @Test
    public void wplacPieniadze_niePoprawnaKwota_stanKontaNieZaktualizowany() {
        bank.zalogujKlienta("k", "k", "k");

        bank.wplacPieniadze("test");

        assertThat(bank.pobierzStanKonta()).isEqualTo("0");
    }

    @Test
    public void wyplacPieniadze_poprawnaKwota_stanKontaZaktualizowany() {
        bank.zalogujKlienta("k", "k", "k");
        bank.wplacPieniadze("100");

        bank.wyplacPieniadze("10");

        assertThat(bank.pobierzStanKonta()).isEqualTo("90");
    }

    @Test
    public void wyplacPieniadze_niePoprawnaKwota_stanKontaNieZaktualizowany() {
        bank.zalogujKlienta("k", "k", "k");
        bank.wplacPieniadze("100");

        bank.wyplacPieniadze("test");

        assertThat(bank.pobierzStanKonta()).isEqualTo("100");
    }

    @Test
    public void wyplacPieniadze_zaDuzaKwota_stanKontaNieZaktualizowany() {
        bank.zalogujKlienta("k", "k", "k");
        bank.wplacPieniadze("100");

        bank.wyplacPieniadze("200");

        assertThat(bank.pobierzStanKonta()).isEqualTo("100");
    }
}
