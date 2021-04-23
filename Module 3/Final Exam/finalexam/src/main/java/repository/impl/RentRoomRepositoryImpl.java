package repository.impl;

import mapper.RentRoomMapper;
import model.RentRoom;
import repository.IRentRoomRepository;

import java.util.List;

public class RentRoomRepositoryImpl extends BaseRepositoryImpl<RentRoom> implements IRentRoomRepository {
    @Override
    public List<RentRoom> findALl() {
        return select("select * from rentrooms;", new RentRoomMapper());
    }

    @Override
    public RentRoom findById(Long id) {
        List<RentRoom> rentRoomList = select("select * from rentrooms where id = ?;", new RentRoomMapper(), id);
        return rentRoomList.isEmpty() ? null : rentRoomList.get(0);
    }

    @Override
    public void create(RentRoom rentRoom) {
        update("insert into rentrooms (fullname, phone, startday, note, idpaymentmethod) values (?,?,?,?,?);",
                rentRoom.getFullName(),
                rentRoom.getPhone(),
                rentRoom.getStartDay(),
                rentRoom.getNote(),
                rentRoom.getPaymentMethod().getId());
    }

    @Override
    public List<RentRoom> search(String txtSearch) {
        return select("call search(?);", new RentRoomMapper(), txtSearch);
    }

    @Override
    public void delete(Long id) {
        update("delete from rentrooms where id = ?;", id);
    }
}
