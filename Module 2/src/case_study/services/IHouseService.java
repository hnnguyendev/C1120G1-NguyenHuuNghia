package case_study.services;

import case_study.models.House;

import java.util.List;
import java.util.TreeSet;

public interface IHouseService extends ICrudService<House> {

    List<House> searchByName(String name);

    TreeSet<House> findAllNotDuplicateName();

}
