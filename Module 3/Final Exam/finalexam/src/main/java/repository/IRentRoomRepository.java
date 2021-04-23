package repository;

import model.RentRoom;

import java.util.List;

public interface IRentRoomRepository {

    List<RentRoom> findALl();

    RentRoom findById(Long id);

    void create(RentRoom rentRoom);

    List<RentRoom> search(String txtSearch);

    void delete(Long id);
}
