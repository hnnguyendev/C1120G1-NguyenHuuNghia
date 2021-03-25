package service.impl;

import model.RentRoom;
import repository.IRentRoomRepository;
import repository.impl.RentRoomRepositoryImpl;
import service.IRentRoomService;

import java.util.List;

public class RentRoomServiceImpl implements IRentRoomService {

    IRentRoomRepository rentRoomRepository = new RentRoomRepositoryImpl();
    @Override
    public List<RentRoom> findALl() {
        return rentRoomRepository.findALl();
    }

    @Override
    public RentRoom findById(Long id) {
        return rentRoomRepository.findById(id);
    }

    @Override
    public void create(RentRoom rentRoom) {
        rentRoomRepository.create(rentRoom);
    }

    @Override
    public List<RentRoom> search(String txtSearch) {
        return rentRoomRepository.search(txtSearch);
    }

    @Override
    public void delete(Long id) {
        rentRoomRepository.delete(id);
    }
}
