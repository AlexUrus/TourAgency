import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tour  {

    @Override
    public String toString() {
        return   number +
                ". Страна: " + country +
                ", Уровень комфорта: " + comfort +
                ", Цена: " + price +
                " Рублей";
    }
    private String country;
    private int comfort;
    private int number;
    private int price;
    private boolean hot;
    public boolean getHot() {
        return hot;
    }
    public void setHot(boolean hot) {
        this.hot = hot;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setComfort(int comfort) {
        this.comfort = comfort;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getCountry() {
        return country;
    }
    public int getPrice() {
        return price;
    }
}
interface TourBuilder{
    TourBuilder setNumber(int number);
    TourBuilder setCountry(String country);
    TourBuilder setComfort(int comfort);
    TourBuilder setPrice(int price);
    TourBuilder setHotKoef(int hotKoef);
    TourBuilder setNeedVisa(int needVisa) throws IOException;
    TourWithVisa build();
}
class TourBuilderPattern implements TourBuilder{
    TourWithVisa tour;
    {
        try {
            tour = new TourWithVisa();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TourBuilder setNumber(int number) {
        tour.setNumber(number);
        return this;
    }

    @Override
    public TourBuilder setCountry(String country) {
        tour.setCountry(country);
        return this;
    }

    @Override
    public TourBuilder setComfort(int comfort) {
        tour.setComfort(comfort);
        return this;
    }

    @Override
    public TourBuilder setPrice(int price) {
        tour.setPrice(price);
        return this;
    }

    @Override
    public TourBuilder setHotKoef(int hotKoef) {
        if (hotKoef == 1) tour.setHot(true);
        else tour.setHot(false);
        return this;
    }

    @Override
    public TourBuilder setNeedVisa(int needVisa) {
        if (needVisa == 1)
        {
            tour.setNeedVisa(true);
        }
        return this;
    }

    @Override
    public TourWithVisa build() {
        return tour;
    }
}
