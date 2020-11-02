package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);
        
        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void negatiivinenVarasto() {
        Varasto tyhja = new Varasto(-1);

        assertEquals(0.0, tyhja.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenLisays() {
        double ennen = varasto.getSaldo();
        varasto.lisaaVarastoon(-1.0);

        assertEquals(ennen, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenPyynto() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(-1.0);

        assertEquals(0, saatuMaara, vertailuTarkkuus);
    }
    
    @Test
    public void lisaysYliTayden() {
        varasto.lisaaVarastoon(11.0);

        assertEquals(10.0, varasto.getSaldo(), vertailuTarkkuus);
    }
    @Test
    public void pyyntoYliMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(11);

        assertEquals(8, saatuMaara, vertailuTarkkuus);
    }
    
    @Test
    public void toStringTesti() {

        assertEquals(varasto.toString(), "saldo = " + varasto.getSaldo() + ", vielä tilaa " + varasto.paljonkoMahtuu());
    }
    @Test
    public void negatiivinenVarastoAlkuSaldolla() {
        Varasto tyhja = new Varasto(-1,0);

        assertEquals(0.0, tyhja.getTilavuus(), vertailuTarkkuus);
    }
    @Test
    public void negatiivinenAlkuSaldoVarasto() {
        Varasto tyhja = new Varasto(5,-1);

        assertEquals(0.0, tyhja.getSaldo(), vertailuTarkkuus);
    }
    @Test
    public void yliAlkuSaldoVarasto() {
        Varasto tyhja = new Varasto(5,6);

        assertEquals(5.0, tyhja.getSaldo(), vertailuTarkkuus);
    }
    @Test
    public void alkuSaldoVarasto() {
        Varasto tyhja = new Varasto(10,5);

        assertEquals(5.0, tyhja.getSaldo(), vertailuTarkkuus);
        assertEquals(10.0, tyhja.getTilavuus(), vertailuTarkkuus);
    }
}