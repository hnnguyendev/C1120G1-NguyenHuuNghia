package case_study.utils.comparison;

import case_study.models.Villa;

import java.util.Comparator;

public class CompareVillaByName implements Comparator<Villa> {
    @Override
    public int compare(Villa o1, Villa o2) {
        return o1.getServiceName().compareTo(o2.getServiceName());
    }
}
