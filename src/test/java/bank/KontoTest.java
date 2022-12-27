package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KontoTest {

    Konto konto;

    @BeforeEach
    public void setup() {
        this.konto = new Konto();
    }

    @Test
    public void getStanKonta_zeroNaPoczatku() {
        BigDecimal actual = konto.getStanKonta();

        assertThat(actual.intValue()).isZero();
    }

    @Test
    public void wplac_poprawnaKwota_kontoMaPoprawnaWartosc() {
        konto.wplac("100");

        BigDecimal actual = konto.getStanKonta();

        assertThat(actual.intValue()).isEqualTo(100);
    }

    @Test
    public void wplac_niePoprawnaKwota_rzuconyWyjatek() {
        assertThrows(NumberFormatException.class,
                () -> konto.wplac("test"));
    }

    @Test
    public void wyplac_poprawnaKwota_kontoMaPoprawnaWartosc() throws Exception {
        konto.wplac("100");

        konto.wyplac("10");
        BigDecimal actual = konto.getStanKonta();

        assertThat(actual.intValue()).isEqualTo(90);
    }

    @Test
    public void wyplac_kwotaWiekszaNizStan_wyjatekRzucony() {
        konto.wplac("100");

        assertThrows(NieWystarczajacoPieniedzy.class,
                () -> konto.wyplac("110"));
    }

    @Test
    public void wyplac_niePoprawnaKwota_rzuconyWyjatek() {
        assertThrows(NumberFormatException.class,
                () -> konto.wyplac("test"));
    }

    @Test
    public void pobierzStan_zwracaPrawidlowaWartosc() {
        String actual = konto.pobierzStan();

        assertThat(actual).isEqualTo("0");
    }
}
