import util.CreateEntityManager;

import javax.persistence.*;
import java.util.List;
import static util.CreateEntityManager.createEntityManager;
public class EmployeeDaoImpl implements EmployeeDao{

    private final String user = "postgres";
    private final String pass = "root";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override
    public List<Employee> getAllEmployee() {

        EntityManager entityManager = CreateEntityManager.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        String jpqlQuery = "Select e FROM Employee e";
        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);
        List<Employee> employees = query.getResultList();

        transaction.commit();
        entityManager.close();

        return employees;
    }

    @Override
    public Employee getById(int id) {

        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Employee employee = entityManager.find(Employee.class, id);

        transaction.commit();
        entityManager.close();
        return employee;
    }

    @Override
    public void createEmployee(Employee employee) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(employee);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public void updateEmployee(Employee employee) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.merge(employee);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public void deleteEmployee(Employee employee) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.remove(employee);

        transaction.commit();
        entityManager.close();
    }

}
