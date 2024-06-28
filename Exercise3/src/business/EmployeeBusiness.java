package business;

import entity.Department;
import entity.Employee;
import  static business.DepartmentBusiness.departments;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeBusiness implements IEmployeeDesign{
    public static List<Employee> employees = new ArrayList<>();

    @Override
    public int calEmployeeAvg() {
        return employees.size()/departments.size();
    }

    @Override
    public Set<Map.Entry<Department, Integer>> mostCrowded() {
        // B1 : input : phòng ban, nhân viên
        // Tính số lượng nhân viên của mỗi phòng
        // Phân loại các nhân viên theo phòng ban
        Map<Department, Integer> map = new HashMap<>();

        for (Employee e: employees){
            if (map.containsKey(e.getDepartment())){
                // có tồn tại trong map
                map.put(e.getDepartment(), map.get(e.getDepartment())+1);
            }else {
                // chưa tồn tại
                map.put(e.getDepartment(),1);
            }
        }
       return map
               .entrySet()
               .stream()
               .sorted((o1, o2) ->o2.getValue().compareTo(o1.getValue()))
               .limit(5)
               .collect(Collectors.toSet());

    }

    @Override
    public Employee manageMostEmploy() {
        Map<Employee, Integer> map = new HashMap<>();
        for (Employee e: employees){
            if (map.containsKey(e.getManager())){
               map.put(e.getManager(), map.get(e.getManager())+1);
            }else {
                map.put(e.getManager(),1);
            }
        }
        Map.Entry<Employee,Integer> entry = map.entrySet().stream()
                .min((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .orElse(null);
        if (entry!=null){
            return entry.getKey();
        }
        return null;
    }

    @Override
    public List<Employee> employeeAgeMax() {
        return employees.stream()
                .sorted((o1, o2) -> o1.getBirthday().compareTo(o2.getBirthday()))
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> employeeSalaryMax() {
        return employees.stream()
                .sorted((o1, o2) -> (int) o1.getSalary() - (int) o2.getSalary())
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existByEmployeeId(String depId) {
        for(Employee employee : employees){
            if(employee.getEmployeeId().equals(depId)) return true;
        }
        return false;
    }

    @Override
    public boolean create(Employee employee) {
        employees.add(employee);
        return true;
    }

    @Override
    public boolean update(Employee employee) {
        int index = employees.indexOf(findById(employee.getEmployeeId()));
        if(index != -1) {
            employees.set(index, employee);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return employees.removeIf( employee -> employee.getEmployeeId().equals(id));
    }

    @Override
    public Employee findById(String id) {
        for(Employee employee : employees){
            if(employee.getEmployeeId().equals(id)) return employee;
        }
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }
}
