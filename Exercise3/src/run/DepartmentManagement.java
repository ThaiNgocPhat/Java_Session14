package run;
import business.DepartmentBusiness;
import business.EmployeeBusiness;
import entity.Department;
import entity.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DepartmentManagement {
    public static void main(String[] args) {
        DepartmentBusiness departmentService = new DepartmentBusiness();
        EmployeeBusiness employeeService = new EmployeeBusiness();

        Department d1 = new Department("D001", "IT");
        Department d2 = new Department("D002", "HR");
        departmentService.add(d1);
        departmentService.add(d2);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Employee e1 = new Employee("E0001", "John Doe", LocalDate.parse("01/01/1980", formatter), true, 5000, null, d1);
        Employee e2 = new Employee("E0002", "Jane Smith", LocalDate.parse("15/03/1985", formatter), false, 6000, e1, d1);
        employeeService.add(e1);
        employeeService.add(e2);

        // Hiển thị danh sách phòng ban
        departmentService.getAll().forEach(System.out::println);

        // Hiển thị danh sách nhân viên
        employeeService.getAll().forEach(System.out::println);

        // Xem chi tiết thông tin nhân viên theo mã
        System.out.println(employeeService.getById("E0001"));

        // Sửa tên phòng ban
        d1.setDepartmentName("Information Technology");
        departmentService.update(d1);

        // Xóa nhân viên
        employeeService.delete("E0002");

        // Thống kê số lượng nhân viên trung bình của mỗi phòng
        System.out.println("Average employees per department: " + employeeService.averageEmployeesPerDepartment());

        // Tìm ra 5 phòng có số lượng nhân viên đông nhất
        employeeService.top5DepartmentsByEmployees().forEach(System.out::println);

        // Tìm ra người quản lý nhiều nhân viên nhất
        System.out.println("Manager with most employees: " + employeeService.managerWithMostEmployees());

        // Tìm ra 5 nhân viên có tuổi cao nhất công ty
        employeeService.top5OldestEmployees().forEach(System.out::println);

        // Tìm ra 5 nhân viên hưởng lương cao nhất
        employeeService.top5HighestSalaries().forEach(System.out::println);
    }
}