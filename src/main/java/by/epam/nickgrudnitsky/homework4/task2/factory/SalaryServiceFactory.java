package by.epam.nickgrudnitsky.homework4.task2.factory;

import by.epam.nickgrudnitsky.homework4.task2.service.SalaryService;

public class SalaryServiceFactory {
    public SalaryService getSalaryService() {
        System.out.println("This is non-static factory method that returns instance of another class. " +
                "It is used instance is not known and decided at runtime." +
                "Salary Factory is created.");
        return new SalaryService();
    }
}
