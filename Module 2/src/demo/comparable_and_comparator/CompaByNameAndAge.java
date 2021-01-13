package demo.comparable_and_comparator;

import java.util.Comparator;

public class CompaByNameAndAge implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
       if (o1.getName().compareTo(o2.getName())>0){
           return 1;
        }else if (o1.getName().compareTo(o2.getName())<0){
           return -1;
       }else {
           if (o1.getAge()>o2.getAge()){
               return 1;
           }else if (o1.getAge()<o2.getAge()){
               return -1;
           }else {
               return 0;
           }
       }
    }
}
