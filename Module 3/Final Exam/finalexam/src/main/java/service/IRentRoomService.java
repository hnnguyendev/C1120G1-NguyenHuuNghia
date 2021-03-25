package service;

import model.RentRoom;

import java.util.List;

public interface IRentRoomService {

    List<RentRoom> findALl();

    RentRoom findById(Long id);

    void create(RentRoom rentRoom);

    List<RentRoom> search(String txtSearch);

    void delete(Long id);
}
