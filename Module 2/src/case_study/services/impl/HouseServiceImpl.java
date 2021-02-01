package case_study.services.impl;

import case_study.models.House;
import case_study.repositories.IRepository;
import case_study.repositories.impl.RepositoryImpl;
import case_study.services.IHouseService;
import case_study.utils.comparison.CompareHouseByName;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class HouseServiceImpl implements IHouseService {

    private static final String FILE_NAME = "house.csv";

    IRepository<House> repository = new RepositoryImpl<>();

    @Override
    public House findById(String id) {
        List<House> houseList = findAll();
        for (House house : houseList) {
            if (id.equals(house.getId())) {
                return house;
            }
        }

        return null;
    }

    @Override
    public List<House> findAll() {
        List<String[]> listString = repository.readFile(FILE_NAME);
        List<House> houseList = new ArrayList<>();
        for (String[] strings : listString) {
            House house = new House(strings);
            houseList.add(house);
        }

        return houseList;
    }

    @Override
    public void save(House house) {
        List<House> houseList = findAll();
        houseList.add(house);
        repository.writeFile(FILE_NAME, houseList, false);
    }

    @Override
    public void update(House newHouse, String id) {
        List<House> houseList = findAll();
        House house = findById(id);
        int index = -1;
        for (int i = 0; i < houseList.size(); i++) {
            if (houseList.get(i).getId().equals(house.getId())) {
                index = i;
            }
        }
        if (index != -1) {
            houseList.remove(index);
            houseList.add(index, newHouse);
            repository.writeFile(FILE_NAME, houseList, false);
        }
    }

    @Override
    public void delete(String id) {
        List<House> houseList = findAll();
        House house = findById(id);
        int index = -1;
        for (int i = 0; i < houseList.size(); i++) {
            if (houseList.get(i).getId().equals(house.getId())) {
                index = i;
            }
        }
        if (index != -1) {
            houseList.remove(index);
            repository.writeFile(FILE_NAME, houseList, false);
        }
    }

    @Override
    public List<House> searchByName(String name) {
        List<House> houseList = findAll();
        List<House> searchList = new ArrayList<>();
        for (House house : houseList) {
            if (house.getServiceName().contains(name)) {
                searchList.add(house);
            }
        }

        return searchList;
    }

    @Override
    public TreeSet<House> findAllNotDuplicateName() {
        TreeSet<House> houseTreeSet = new TreeSet<>(new CompareHouseByName());
        List<House> houseList = findAll();
        houseTreeSet.addAll(houseList);

        return houseTreeSet;
    }

}
