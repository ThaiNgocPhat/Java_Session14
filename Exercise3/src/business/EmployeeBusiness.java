package business;

import entity.Department;
import entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeBusiness implements IEmployeeDesign{
    private List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> getAll() {
        return employees;
    }

    @Override
    public Employee getById(String id) {
        return employees.stream().filter(e -> e.getEmployeeId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void add(Employee employee) {
        employees.add(employee);
        employee.getDepartment().setTotalMembers(employee.getDepartment().getTotalMembers() + 1);
    }

    @Override
    public void update(Employee employee) {
        Employee e = getById(employee.getEmployeeId());
        if (e != null) {
            e.setEmployeeName(employee.getEmployeeName());
            e.setBirthday(employee.getBirthday());
            e.setSex(employee.isSex());
            e.setSalary(employee.getSalary());
            e.setManager(employee.getManager());
            e.setDepartment(employee.getDepartment());
        }
    }

    @Override
    public void delete(String id) {
        Employee e = getById(id);
        if (e != null) {
            employees.remove(e);
            e.getDepartment().setTotalMembers(e.getDepartment().getTotalMembers() - 1);
        }
    }

    public double averageEmployeesPerDepartment() {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .values().stream().mapToDouble(Long::doubleValue).average().orElse(0);
    }

    public List<Department> top5DepartmentsByEmployees() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(5)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
    }

    public Employee managerWithMostEmployees() {
        return employees.stream()
                .filter(e -> e.getManager() != null)
                .collect(Collectors.groupingBy(Employee::getManager, Collectors.counting()))
                .entrySet().stream()
                .max((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                .map(e -> e.getKey())
                .orElse(null);
    }

    public List<Employee> top5OldestEmployees() {
        return employees.stream()
                .sorted((e1, e2) -> e1.getBirthday().compareTo(e2.getBirthday()))
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<Employee> top5HighestSalaries() {
        return employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public int calEmployeeAvg() {
        return 0;
    }

    @Override
    public Set<Map.Entry<Department, Integer>> mostCrowded() {
        return null;
    }

    @Override
    public Employee manageMostEmploy() {
        return null;
    }

    @Override
    public List<Employee> employeeAgeMax() {
        return null;
    }

    @Override
    public List<Employee> employeeSalaryMax() {
        return null;
    }

    @Override
    public boolean existByEmployeeId(String depId) {
        return false;
    }
}
