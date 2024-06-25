import java.util.Arrays;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Tạo một mảng số nguyên, hoặc danh sách các chuỗi theo từng yêu cầu
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //Sử dụng Stream API để duyệt qua mảng và phương thức max() để tìm số lớn nhất trong mảng.
        int max = Arrays.stream(arr).max().getAsInt();

        //Sử dụng Stream API và phương thức filter() để tìm số chẵn
        int even = Arrays.stream(arr).filter(x -> x % 2 == 0).findFirst().getAsInt();

        //Sử dụng Stream API và phương thức filter() để lọc các số lớn hơn một giá trị xác định mà người dùng nhập vào
        int value = 5;
        int count = (int) Arrays.stream(arr).filter(x -> x > value).count();

        //Sử dụng Stream API và phương thức reduce() để tính tổng của các số trong danh sách.
        int sum = Arrays.stream(arr).reduce(0, (a, b) -> a + b);

        //Sử dụng Stream API và phương thức anyMatch() để kiểm tra xem danh sách có chứa ít nhất một số chẵn hay không.
        boolean hasEven = Arrays.stream(arr).anyMatch(x -> x % 2 == 0);

        //Sử dụng Stream API và phương thức range() để tạo danh sách các số từ x đến y.
        int[] range = IntStream.range(1, 10).toArray();

        //Sử dụng Stream API và phương thức sorted() để sắp xếp danh sách theo thứ tự bảng chữ cái.
        String[] strings = {"abc", "def", "ghi", "jkl", "mno"};
        
        //Sử dụng Stream API và phương thức map() để chuyển các chuỗi thành chữ in hoa.
        String[] upper = Arrays.stream(strings).map(String::toUpperCase).toArray(String[]::new);

        //Chạy chương trình và quan sát kêt quả
        System.out.println("Max: " + max);
        System.out.println("Even: " + even);
        System.out.println("Count: " + count);
        System.out.println("Sum: " + sum);
        System.out.println("Has even: " + hasEven);
        System.out.println("Range: " + Arrays.toString(range));
        System.out.println("Sorted: " + Arrays.toString(upper));
    }
}