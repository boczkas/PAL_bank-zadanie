package bank;

import java.math.BigDecimal;

public class Konto {

    private BigDecimal stanKonta;

    public Konto() {
        this.stanKonta = new BigDecimal(0);
    }

    public BigDecimal getStanKonta() {
        return stanKonta;
    }

    public void wplac(String kwota) {
        this.stanKonta = stanKonta.add(new BigDecimal(kwota));
    }

    public void wyplac(String kwota) {
    }

    public String pobierzStan() {
        return this.stanKonta.toString();
    }
}
