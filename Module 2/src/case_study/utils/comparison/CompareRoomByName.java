package case_study.utils.comparison;

import case_study.models.Room;

import java.util.Comparator;

public class CompareRoomByName implements Comparator<Room> {
    @Override
    public int compare(Room o1, Room o2) {
        return o1.getServiceName().compareTo(o2.getServiceName());
    }
}
