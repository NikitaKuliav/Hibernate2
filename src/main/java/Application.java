import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.List;


public class Application {
    public static void main(String[] args){


        EmployeeDao employeeDao = new EmployeeDaoImpl();
//        employeeDao.getAllEmployee().forEach(System.out::println);
//
//        System.out.println();
//        System.out.println(employeeDao.getById(3));
        City city = new City(5,"Tokyo");

        Employee employee1 = new Employee("Kuzya", "Kurchavin", "male", 23, city);
        Employee employee2 = new Employee("Mitya", "Grechnev", "male", 29, city);

//
//        city.setEmployees(List.of(employee1, employee2));
//
        CityDao cityDao = new CityDaoImpl();
//
//        System.out.println(city.getEmployees());

        cityDao.createCity(city);

//        employee1.setAge(56);
//        cityDao.updateCity(city);
//        cityDao.deleteCity(city);
//employeeDao.deleteEmployee(employee1);
//        employeeDao.createEmployee(employee);
//        employeeDao.getAllEmployee().forEach(System.out::println);

    }
}
