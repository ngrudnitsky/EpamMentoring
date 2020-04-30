package by.epam.nickgrudnitsky.homework4.task2.factory;

import by.epam.nickgrudnitsky.homework4.task2.service.EmployeeService;

public class EmployeeServiceFactory {
    public static EmployeeService getEmployeeService(){
        System.out.println("This is a static factory method that returns instance of another class." +
                " It is used instance is not known and decided at runtime." +
                "Employee Service is created.");
        return new EmployeeService();
    }
}
