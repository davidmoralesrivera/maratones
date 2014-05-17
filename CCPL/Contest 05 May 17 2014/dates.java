
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class dates {

    static final BufferedReader IN = new BufferedReader(new InputStreamReader(System.in));
    static final String[] MONTHS = new String[]{"January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(IN.readLine());
        String input[];
        String output;
        Calendar date;
        int day;
        for (int i = 0; i < T; i++) {
            input = IN.readLine().split("-");
            date = new GregorianCalendar(Integer.parseInt(input[0]), getMonth(input[1]), Integer.parseInt(input[2]));
            date.add(Calendar.DAY_OF_MONTH, Integer.parseInt(IN.readLine()));
            output = "Case " + (i + 1) + ": " + date.get(Calendar.YEAR) + "-" + MONTHS[date.get(Calendar.MONTH)] + "-";
            day = date.get(Calendar.DAY_OF_MONTH);
            if (day < 10) {
                output += "0" + day;
            } else {
                output += day;
            }
            System.out.println(output);
        }
    }

    static int getMonth(String month) {
        for (int i = 0; i < MONTHS.length; i++) {
            if (MONTHS[i].equalsIgnoreCase(month)) {
                return i;
            }
        }
        return -1;
    }
}
