import org.junit.Test;

import java.util.ArrayList;
import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class MoneyTest {

    @org.junit.Test
    public void shouldAdd150rupeesWith10Paise() {
        Money money1 = new Money(150, Unit.Rupees);
        Money money2 = new Money(10, Unit.Paise);
        assertEquals(new Money(150.10, Unit.Rupees), money1.addMoney(money2));

    }

    @Test
    public void shouldSubtract150rupeesWith50Paise() {
        Money money1 = new Money(150, Unit.Rupees);
        Money money2 = new Money(10, Unit.Paise);
        assertEquals(new Money(149.90, Unit.Rupees), money1.subtractMoney(money2));
    }

    @Test
    public void shouldSubtract50rupeesFrom20rupees() {
        Money money1 = new Money(20, Unit.Rupees);
        Money money2 = new Money(50, Unit.Rupees);
        assertEquals(new Money(-30.0, Unit.Rupees), money1.subtractMoney(money2));


    }

    @Test
    public void shouldSubtract20paiseFrom10paise() {
        Money money1 = new Money(10, Unit.Paise);
        Money money2 = new Money(20, Unit.Paise);
        assertEquals(new Money(-0.10, Unit.Rupees), money1.subtractMoney(money2));
    }

    @Test
    public void shouldCheckIf20ruppesIsPrintedCorrectly() {
        Money money=new Money(20.0,Unit.Rupees);
        assertEquals("value = 20.0 , unit = Rupees",money.toString());


    }

    @Test
    public void shouldCheckIf120paiseIs1point20rupees() {
        Money money=new Money(120,Unit.Paise);
        assertTrue(new Money(1.20, Unit.Rupees).equals(money));

    }

    @Test
    public void sortTheMoneyValuesGivenPaise() {
        Money money1 = new Money(120, Unit.Paise);
        Money money2 = new Money(100, Unit.Paise);
        assertEquals(1, money1.compareTo(money2));
    }

    @Test
    public void sortTheMoneyValuesGivenRupee() {
        Money money1 = new Money(80, Unit.Rupees);
        Money money2 = new Money(100, Unit.Rupees);
        assertEquals(-1, money1.compareTo(money2));
    }

}

