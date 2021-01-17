package ss10_set_stack_queue.exercise.ex04_to_chuc_du_lieu_hop_ly_demerging_su_dung_queue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// sap xep dung PriorityQueue
public class Employee implements Comparable<Employee> {

    private String fullName;
    private boolean gender;
    private String birthday;

    public Employee() {
    }

    public Employee(String fullName, boolean gender, String birthday) {
        this.fullName = fullName;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", gender=" + gender +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    // sap xep dung PriorityQueue
    @Override
    public int compareTo(Employee o) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = simpleDateFormat.parse(this.getBirthday());
            date2 = simpleDateFormat.parse(o.getBirthday());
            return date1.compareTo(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
