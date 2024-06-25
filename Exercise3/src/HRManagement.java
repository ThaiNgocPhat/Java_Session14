import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class HRManagement {
    private List<Department> departments;
    private List<Employee> employees;

    public HRManagement() {
        this.departments = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    // Quản trị phòng ban
    public List<Department> getAllDepartments() {
        return departments;
    }

    public void addDepartment(Department department) {
        if (departments.contains(department)) {
            throw new IllegalArgumentException("Phòng ban đã tồn tại.");
        }
        departments.add(department);
    }

    public void editDepartmentName(String departmentId, String newName) {
        Department department = findDepartmentById(departmentId);
        if (department != null) {
            department.setDepartmentName(newName);
        } else {
            throw new NoSuchElementException("Phòng ban không tồn tại.");
        }
    }

    public List<Employee> getEmployeesByDepartmentId(String departmentId) {
        return employees.stream()
                .filter(emp -> emp.getDepartment().getDepartmentId().equals(departmentId))
                .collect(Collectors.toList());
    }

    public void deleteDepartment(String departmentId) {
        Department department = findDepartmentById(departmentId);
        if (department != null && department.getTotalMembers() == 0) {
            departments.remove(department);
        } else {
            throw new IllegalStateException("Phòng ban còn nhân viên hoặc không tồn tại.");
        }
    }

    private Department findDepartmentById(String departmentId) {
        return departments.stream()
                .filter(dept -> dept.getDepartmentId().equals(departmentId))
                .findFirst()
                .orElse(null);
    }

    // Quản trị nhân viên
    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(String employeeId) {
        return employees.stream()
                .filter(emp -> emp.getEmployeeId().equals(employeeId))
                .findFirst()
                .orElse(null);
    }

    public void addEmployee(Employee employee) {
        if (departments.isEmpty()) {
            throw new IllegalStateException("Danh sách phòng ban rỗng. Cần thêm phòng ban trước.");
        }
        if (employees.contains(employee)) {
            throw new IllegalArgumentException("Nhân viên đã tồn tại.");
        }
        employees.add(employee);
        Department department = employee.getDepartment();
        department.setTotalMembers(department.getTotalMembers() + 1);
    }

    public void editEmployee(Employee updatedEmployee) {
        Employee employee = getEmployeeById(updatedEmployee.getEmployeeId());
        if (employee != null) {
            employee.setEmployeeName(updatedEmployee.getEmployeeName());
            employee.setBirthday(updatedEmployee.getBirthday());
            employee.setSex(updatedEmployee.isSex());
            employee.setSalary(updatedEmployee.getSalary());
            employee.setManager(updatedEmployee.getManager());
            employee.setDepartment(updatedEmployee.getDepartment());
        } else {
            throw new NoSuchElementException("Nhân viên không tồn tại.");
        }
    }

    public void deleteEmployee(String employeeId) {
        Employee employee = getEmployeeById(employeeId);
        if (employee != null) {
            Department department = employee.getDepartment();
            department.setTotalMembers(department.getTotalMembers() - 1);
            employees.remove(employee);
        } else {
            throw new NoSuchElementException("Nhân viên không tồn tại.");
        }
    }

    // Thống kê
    public double getAverageEmployeesPerDepartment() {
        return departments.stream()
                .mapToInt(Department::getTotalMembers)
                .average()
                .orElse(0);
    }

    public List<Department> getTop5DepartmentsByEmployeeCount() {
        return departments.stream()
                .sorted(Comparator.comparingInt(Department::getTotalMembers).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    public Employee getManagerWithMostEmployees() {
        return employees.stream()
                .filter(emp -> emp.getManager() != null)
                .collect(Collectors.groupingBy(Employee::getManager, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public List<Employee> getTop5OldestEmployees() {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getBirthday))
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<Employee> getTop5HighestSalaryEmployees() {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    // Method để test
    public static void main(String[] args) {
        HRManagement hrManagement = new HRManagement();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Thêm phòng ban
        Department dept1 = new Department("D001", "IT");
        Department dept2 = new Department("D002", "HR");
        hrManagement.addDepartment(dept1);
        hrManagement.addDepartment(dept2);

        // Thêm nhân viên
        Employee emp1 = new Employee("E0001", "Alice", LocalDate.parse("01/01/1985", formatter), true, 1000.0, dept1);
        Employee emp2 = new Employee("E0002", "Bob", LocalDate.parse("02/02/1986", formatter), false, 1200.0, dept1);
        Employee emp3 = new Employee("E0003", "Charlie", LocalDate.parse("03/03/1987", formatter), true, 1100.0, dept2);

        hrManagement.addEmployee(emp1);
        hrManagement.addEmployee(emp2);
        hrManagement.addEmployee(emp3);

        // Hiển thị danh sách phòng ban
        System.out.println("Danh sách phòng ban:");
        hrManagement.getAllDepartments().forEach(System.out::println);

        // Hiển thị danh sách nhân viên
        System.out.println("Danh sách nhân viên:");
        hrManagement.getAllEmployees().forEach(System.out::println);
    }
}
