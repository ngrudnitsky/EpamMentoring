package by.epam.nickgrudnitsky.homework4.task2.service;


import by.epam.nickgrudnitsky.homework4.task2.beans.Employee;
import by.epam.nickgrudnitsky.homework4.task2.beans.Position;

public class EmployeeService {
    public void hire(Employee employee, Position position) {
        if (employee != null && position != null) {
            employee.setPosition(position);
            employee.setSalary(position.getSalary());
            position.getEmployees().add(employee);
        }
    }

    public void fire(Employee employee) {
        if (employee != null) {
            Position position = employee.getPosition();
            employee.setPosition(null);
            position.getEmployees().remove(employee);
        }
    }
}
