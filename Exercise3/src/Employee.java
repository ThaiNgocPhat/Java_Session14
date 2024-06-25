import java.time.LocalDate;

public class Employee {
    private String employeeId; // mã nhân viên
    private String employeeName; // tên nhân viên
    private LocalDate birthday; // ngày sinh
    private boolean sex; // giới tính
    private double salary; // lương cơ bản
    private Employee manager; // người quản lí
    private Department department; // phòng ban

    public Employee(String employeeId, String employeeName, LocalDate birthday, boolean sex, double salary, Department department) {
        if (!employeeId.matches("E\\d{4}")) {
            throw new IllegalArgumentException("employeeId phải bắt đầu bằng E và có đúng 5 kí tự.");
        }
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.sex = sex;
        this.salary = salary;
        this.department = department;
    }

    // Getters và Setters

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", salary=" + salary +
                ", manager=" + (manager != null ? manager.getEmployeeName() : "null") +
                ", department=" + department.getDepartmentName() +
                '}';
    }
}
