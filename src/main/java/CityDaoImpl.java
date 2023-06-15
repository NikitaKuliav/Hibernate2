import util.CreateEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

import static util.CreateEntityManager.createEntityManager;

public class CityDaoImpl implements CityDao {
    private final String user = "postgres";
    private final String pass = "root";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override
    public void createCity(City city) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.merge(city);

        transaction.commit();
        entityManager.close();

    }

    @Override
    public City GetById(int id) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        City city = entityManager.find(City.class, id);

        transaction.commit();
        entityManager.close();
        return city;
    }

    @Override
    public List<City> getAllCities() {
        EntityManager entityManager = CreateEntityManager.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        String jpqlQuery = "Select e FROM City e";
        TypedQuery<City> query = entityManager.createQuery(jpqlQuery, City.class);
        List<City> cities = query.getResultList();

        transaction.commit();
        entityManager.close();

        return cities;
    }

    @Override
    public void updateCity(City city) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.merge(city);

        transaction.commit();
        entityManager.close();

    }

    @Override
    public void deleteCity(City city) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.remove(city);

        transaction.commit();
        entityManager.close();

    }
}
