package entity;

import java.util.Arrays;

public class Department {
    private String departmentId;
    private String departmentName;
    private int totalMembers;

    public Department(String departmentId, String departmentName) {
        if (!departmentId.matches("D\\d{3}")) {
            throw new IllegalArgumentException("Department ID must start with 'D' and have 4 characters.");
        }
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.totalMembers = 0;
    }

    // Getters and Setters

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", totalMembers=" + totalMembers +
                '}';
    }

    public Arrays getEmployees() {
        return null;
    }
}
