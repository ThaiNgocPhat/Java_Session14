package business;

import entity.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DepartmentBusiness<Employee> implements IDepartmentDesign {
    private List<Department> departments = new ArrayList<>();

    @Override
    public List<Department> getAll() {
        return departments;
    }

    @Override
    public Department getById(String id) {
        return departments.stream().filter(d -> d.getDepartmentId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void add(Department department) {
        departments.add(department);
    }

    @Override
    public void update(Department department) {
        Department d = getById(department.getDepartmentId());
        if (d != null) {
            d.setDepartmentName(department.getDepartmentName());
        }
    }

    @Override
    public void delete(String id) {
        departments.removeIf(d -> d.getDepartmentId().equals(id));
    }
}
