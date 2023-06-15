import java.util.List;

public interface CityDao {
    void createCity(City city);

    City GetById(int id);

    List<City> getAllCities();

    void updateCity(City city);

    void deleteCity(City city);
}
