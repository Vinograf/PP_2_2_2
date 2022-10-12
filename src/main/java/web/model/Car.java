package web.model;

public class Car {
    private int id;
    private int series;
    private String model;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Car(int id, int series, String model) {
        this.id = id;
        this.series = series;
        this.model = model;
    }
}
