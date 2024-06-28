import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        //Viết chương trình DateTime API để lấy ngày hiện tại của hệ thống và các nơi bao gồm : Asia/Tokyo, Australia/Sydney ,America/Sao_Paulo
        System.out.println("Ngày hiện tại của hệ thống: ");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println("Ngày hiện tại tại địa điểm Asia/Tokyo: ");
        System.out.println(now.atZone(ZoneId.of("Asia/Tokyo")));
        System.out.println("Ngày hiện tại tại địa điểm Australia/Sydney: ");
        System.out.println(now.atZone(ZoneId.of("Australia/Sydney")));
        System.out.println("Ngày hiện tại tại địa điểm America/Sao_Paulo: ");
        System.out.println(now.atZone(ZoneId.of("America/Sao_Paulo")));


        //Viết chương trình Datetime API để lấy thời gian hiện tại (giờ phút giây).
        System.out.println("Thời gian hiện tại: ");
        System.out.println(now.getHour() + " giờ " + now.getMinute() + " phút " + now.getSecond() + " giây");


        //Viết chương trình Datetime API để tính toán số ngày trong tháng hiện tại.
        System.out.println("Số ngày trong tháng hiện tại: ");
        System.out.println(now.getMonth().length(now.toLocalDate().isLeapYear()));


        //Viết chương trình Datetime API để tính toán số ngày trong năm hiện tại.
        System.out.println("Số ngày trong năm hiện tại: ");
        System.out.println(now.toLocalDate().lengthOfYear());


        //Viết chương trình Datetime API để chuyển đổi một chuỗi ngày sang một đối tượng LocalDate.
        System.out.println("Chuyển đổi một chuỗi ngày sang một đối tượng LocalDate: ");
        LocalDate date = LocalDate.parse("2023-04-01");
        System.out.println(date);


        //Viết chương trình Datetime API để chuyển đổi một đối tượng LocalDate sang một chuỗi ngày (dd/MM/yyyy).
        System.out.println("Chuyển đổi một đối tượng LocalDate sang một chuỗi ngày (dd/MM/yyyy): ");
        System.out.println(date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear());


        //Viết chương trình Datetime API để chuyển đổi một đối tượng LocalDateTime sang một chuỗi ngày(dd/MM/yyyy HH:mm:ss).
        System.out.println("Chuyển đổi một đối tượng LocalDateTime sang một chuỗi ngày(dd/MM/yyyy HH:mm:ss): ");
        LocalDateTime datetime = LocalDateTime.now();
        System.out.println(datetime.getDayOfMonth() + "/" + datetime.getMonthValue() + "/" + datetime.getYear() + " " + datetime.getHour() + ":" + datetime.getMinute() + ":" + datetime.getSecond());


        //Viết chương trình Datetime API để so sánh hai ngày LocalDate ( trả về int ),trả về số ngày chênh lệch        System.out.println("So sánh hai ngày LocalDate: ");
        LocalDate date1 = LocalDate.parse("2023-05-09");
        LocalDate date2 = LocalDate.parse("2023-04-02");
        System.out.println("So ngay chênh lệch: " + date2.until(date1, ChronoUnit.DAYS));


        //Viết chương trình Datetime API để so sánh hai thời gian LocalTime.
        System.out.println("So sánh hai thời gian LocalTime: ");
        LocalDateTime datetime1 = LocalDateTime.now();
        LocalDateTime datetime2 = LocalDateTime.now();
        System.out.println(datetime1.compareTo(datetime2));


        //Viết chương trình Datetime API để thêm hoặc bớt một số ngày, giờ, phút, giây hoặc mili giây vào một ngày hoặc thời gian nhập vào.
        System.out.println("Thêm hoặc bớt một số ngày, giờ, phút, giây hoặc mili giây vào một ngày hoặc thời gian nhập vào: ");
        LocalDateTime datetime3 = LocalDateTime.now();
        System.out.println("Ngày hiện tại: ");
        System.out.println(datetime3);
        System.out.println("Thêm 1 ngày: ");
        System.out.println(datetime3.plusDays(1));
        System.out.println("Bớt 1 ngày: ");
        System.out.println(datetime3.minusDays(1));
        System.out.println("Thêm 1 giờ: ");
        System.out.println(datetime3.plusHours(1));
        System.out.println("Bớt 1 giờ: ");
        System.out.println(datetime3.minusHours(1));
        System.out.println("Thêm 1 phút: ");
        System.out.println(datetime3.plusMinutes(1));
        System.out.println("Bớt 1 phút: ");
        System.out.println(datetime3.minusMinutes(1));
        System.out.println("Thêm 1 giây: ");
        System.out.println(datetime3.plusSeconds(1));
        System.out.println("Bớt 1 giây: ");
        System.out.println(datetime3.minusSeconds(1));
        System.out.println("Thêm 1 mili giây: ");
        System.out.println(datetime3.plusNanos(1));
        System.out.println("Bớt 1 mili giây: ");
        System.out.println(datetime3.minusNanos(1));


        //Viết chương trình Datetime API để tính toán ngày (LocalDate) tiếp theo hoặc ngày trước đó của một ngày.
        System.out.println("Ngày tiếp theo hoặc ngày trước đó của một ngày: ");
        LocalDate date3 = LocalDate.parse("2023-04-01");
        System.out.println("Ngày hiện tại: ");
        System.out.println(date3);
        System.out.println("Ngày tiếp theo: ");
        System.out.println(date3.plusDays(1));
        System.out.println("Ngày trước đó: ");
        System.out.println(date3.minusDays(1));

    }
}