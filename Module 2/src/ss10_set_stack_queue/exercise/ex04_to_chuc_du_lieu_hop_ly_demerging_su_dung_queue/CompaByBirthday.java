package ss10_set_stack_queue.exercise.ex04_to_chuc_du_lieu_hop_ly_demerging_su_dung_queue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class CompaByBirthday implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = simpleDateFormat.parse(o1.getBirthday());
            date2 = simpleDateFormat.parse(o2.getBirthday());
            return date1.compareTo(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
