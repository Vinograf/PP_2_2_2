package web.service;

import org.springframework.stereotype.Component;
import web.DAO.CarDAO;
import web.DAO.CarDAOImp;
import web.model.Car;

import java.util.List;
@Component
public class CarServiceImp implements CarDAO, CarService {

    private final  CarDAO car = new CarDAOImp();
    @Override
    public List<Car> printCar(int count) {
        return car.printCar(count);
    }
}
