import java.util.Objects;

public class Department {
    private String departmentId; // mã phòng ban
    private String departmentName; // tên phòng ban
    private int totalMembers; // tổng số nhân viên của phòng

    public Department(String departmentId, String departmentName) {
        if (!departmentId.matches("D\\d{3}")) {
            throw new IllegalArgumentException("departmentId phải bắt đầu bằng D và có đúng 4 kí tự.");
        }
        if (departmentName == null || departmentName.isEmpty()) {
            throw new IllegalArgumentException("departmentName không được rỗng.");
        }
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.totalMembers = 0;
    }

    // Getters và Setters

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return departmentId.equals(that.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId);
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", totalMembers=" + totalMembers +
                '}';
    }
}
