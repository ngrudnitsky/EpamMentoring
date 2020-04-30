package by.epam.nickgrudnitsky.homework4.task2.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class Position {
    private String name;
    private Salary salary;
    private Map<Skill, Integer> skills = new HashMap<>();
    private List<Employee> employees = new ArrayList<>();

    public Position() {
    }

    public Position(String name, Salary salary, List<Employee> employees) {
        this.name = name;
        this.salary = salary;
        this.employees = employees;
    }

    public Position(String name, Salary salary, Map<Skill, Integer> skills) {
        this.name = name;
        this.salary = salary;
        this.skills = skills;
    }

    public Position(String name, Salary salary, Map<Skill, Integer> skills, List<Employee> employees) {
        this.name = name;
        this.salary = salary;
        this.skills = skills;
        this.employees = employees;
    }

    public Position(String name) {
        this.name = name;
    }

    public Position(String name, Salary salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        String template = String.format("Position: '%s', salary = %.2f, employees = [", name, salary.getSalaryAmount());
        StringBuilder result = new StringBuilder(template);
        for (int i = 0; i < employees.size(); i++) {
            result.append(employees.get(i).getName());
            if (i == employees.size() - 1) {
                break;
            }
            result.append(", ");
        }
        return result.append("], skills = ").append(skills).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position = (Position) o;

        if (getName() != null ? !getName().equals(position.getName()) : position.getName() != null) return false;
        if (getSalary() != null ? !getSalary().equals(position.getSalary()) : position.getSalary() != null)
            return false;
        return getEmployees() != null ? getEmployees().equals(position.getEmployees()) : position.getEmployees() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSalary() != null ? getSalary().getSalaryAmount().hashCode() : 0);
        result = 31 * result + (getEmployees() != null ? getEmployees().hashCode() : 0);
        return result;
    }

    public Map<Skill, Integer> getSkills() {
        return skills;
    }

    public void setSkills(Map<Skill, Integer> skills) {
        this.skills = skills;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

