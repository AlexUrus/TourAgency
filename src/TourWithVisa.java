import java.io.IOException;

public class TourWithVisa extends Tour {

    public TourWithVisa() throws IOException {
    }
    private boolean needVisa;
    public boolean isNeedVisa() {
        return needVisa;
    }
    public void setNeedVisa(boolean needVisa) {
        this.needVisa = needVisa;
    }
}
