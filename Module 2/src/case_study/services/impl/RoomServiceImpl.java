package case_study.services.impl;

import case_study.models.Room;
import case_study.repositories.IRepository;
import case_study.repositories.impl.RepositoryImpl;
import case_study.services.IRoomService;
import case_study.utils.comparison.CompareRoomByName;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class RoomServiceImpl implements IRoomService {

    private static final String FILE_NAME = "room.csv";

    IRepository<Room> repository = new RepositoryImpl<>();

    @Override
    public Room findById(String id) {
        List<Room> roomList = findAll();
        for (Room room : roomList) {
            if (id.equals(room.getId())) {
                return room;
            }
        }

        return null;
    }

    @Override
    public List<Room> findAll() {
        List<String[]> listString = repository.readFile(FILE_NAME);
        List<Room> roomList = new ArrayList<>();
        for (String[] strings : listString) {
            Room room = new Room(strings);
            roomList.add(room);
        }

        return roomList;
    }

    @Override
    public void save(Room room) {
        List<Room> roomList = findAll();
        roomList.add(room);
        repository.writeFile(FILE_NAME, roomList, false);

    }

    @Override
    public void update(Room newRoom, String id) {
        List<Room> roomList = findAll();
        Room room = findById(id);
        int index = -1;
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getId().equals(room.getId())) {
                index = i;
            }
        }
        if (index != -1) {
            roomList.remove(index);
            roomList.add(index, newRoom);
            repository.writeFile(FILE_NAME, roomList, false);
        }
    }

    @Override
    public void delete(String id) {
        List<Room> roomList = findAll();
        Room room = findById(id);
        int index = -1;
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getId().equals(room.getId())) {
                index = i;
            }
        }
        if (index != -1) {
            roomList.remove(index);
            repository.writeFile(FILE_NAME, roomList, false);
        }
    }

    @Override
    public List<Room> searchByName(String name) {
        List<Room> roomList = findAll();
        List<Room> searchList = new ArrayList<>();
        for (Room room : roomList) {
            if (room.getServiceName().contains(name)) {
                searchList.add(room);
            }
        }

        return searchList;
    }

    @Override
    public TreeSet<Room> findAllNotDuplicateName() {
        TreeSet<Room> roomTreeSet = new TreeSet<>(new CompareRoomByName());
        List<Room> roomList = findAll();
        roomTreeSet.addAll(roomList);

        return roomTreeSet;
    }
}
