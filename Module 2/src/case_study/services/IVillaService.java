package case_study.services;

import case_study.models.Villa;

import java.util.List;
import java.util.TreeSet;

public interface IVillaService extends ICrudService<Villa> {

    List<Villa> searchByName(String name);

    TreeSet<Villa> findAllNotDuplicateName();

}
