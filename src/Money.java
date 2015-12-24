import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Money implements Comparable{
    private Unit unit;
    private double amount;

    public Money(double amount, Unit unit) {
        this.amount = amount;
        this.unit = unit;


    }

    public Money addMoney(Money that) {
        Money convertedThis = this.convertToPaise();
        Money convertedThat = that.convertToPaise();
        Money result = new Money(convertedThat.amount + convertedThis.amount, Unit.Paise);
        return (result.convertToRupees());

    }

    private Money convertToRupees() {
        if (this.unit == Unit.Paise)
            return new Money(this.amount/100.0, Unit.Rupees);
        return this;
    }

    private Money convertToPaise() {
        if (this.unit == Unit.Rupees)
            return new Money(((int) this.amount * 100.0) + ((this.amount - (int) this.amount) * 100.0), Unit.Paise);
        return this;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money that = (Money) o;

        if (Double.compare(that.convertToPaise().amount, this.convertToPaise().amount) == 0) return true;
       // return unit == money.unit;

    return false;

    }


    @Override
    public int hashCode() {
        int result;
        long temp;
        result = unit != null ? unit.hashCode() : 0;
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Money subtractMoney(Money that) {
        Money convertedThis = this.convertToPaise();
        Money convertedThat = that.convertToPaise();
        Money result = new Money(convertedThis.amount - convertedThat.amount, Unit.Paise);
        return (result.convertToRupees());

    }

    @Override
    public String toString() {

        return "value = "+ this.amount + " , unit = "+this.unit;
    }

    public ArrayList<Money> sort(ArrayList<Money> moneyValueList) {
        ArrayList<Money> sortedList = new ArrayList<Money>();
        for (Money money :moneyValueList) {
            System.out.println(money.amount);
        }


        return moneyValueList;
    }

    @Override
    public int compareTo(Object obj) {
        Money money = (Money)obj;
        if(this.amount< money.amount)
            return -1;
        if(this.amount > money.amount)
            return 1;
        return 0;
    }
}
