package web.DAO;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarDAOImp implements CarDAO {
    public CarDAOImp() {
    }

    private List<Car> cars;

    {
        cars = new ArrayList<Car>();
        cars.add(new Car(1, 11, "BMV"));
        cars.add(new Car(2, 222, "AUDI"));
        cars.add(new Car(3, 333, "HONDA"));
        cars.add(new Car(4, 4444, "KIA"));
        cars.add(new Car(5, 55555, "WW"));
    }

    @Override
    public List<Car> printCar(int count) {
        if (count == 0 || count > 5) {
            return cars;
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
