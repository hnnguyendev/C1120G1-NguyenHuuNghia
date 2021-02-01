package case_study.services;

import case_study.models.Room;

import java.util.List;
import java.util.TreeSet;

public interface IRoomService extends ICrudService<Room> {

    List<Room> searchByName(String name);

    TreeSet<Room> findAllNotDuplicateName();

}
