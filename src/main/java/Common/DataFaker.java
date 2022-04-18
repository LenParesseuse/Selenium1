package Common;

import net.datafaker.Faker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataFaker {
    public static Faker faker = new Faker();

    public static String generateString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String generateRandomEmail(String email) {
        String[] parts = email.split("@");
        String part1 = parts[0];
        String part2 = parts[1];
        return part1 + generateString() + "@" + part2;
    }

    public static String generateDepartDate(String num) {
        Date departDate = faker.date().future(Integer.parseInt(num), 4, TimeUnit.DAYS);
        DateFormat df = new SimpleDateFormat("M/d/yyyy");
        return df.format(departDate);
    }
}
