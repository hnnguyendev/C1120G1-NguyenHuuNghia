package case_study.utils.comparison;

import case_study.models.House;

import java.util.Comparator;

public class CompareHouseByName implements Comparator<House> {
    @Override
    public int compare(House o1, House o2) {
        return o1.getServiceName().compareTo(o2.getServiceName());
    }
}
