import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Programmers_3332 {

    public static void main(String[] args) throws ParseException {
        String[] log = {"08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"};
        long[] answer = new long[log.length / 2];
        SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.KOREA);
        for(int i = 0; i < log.length; i = i + 2){
            Date start = format.parse(log[i]);
            Date end = format.parse(log[i + 1]);
            long diff = end.getTime() - start.getTime();
            long minute = diff / (1000 * 60);
            if(minute < 5) answer[i / 2] = 0;
            else if(minute >= 105) answer[i / 2] = 105;
            else answer[i / 2] = minute;
        }
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
