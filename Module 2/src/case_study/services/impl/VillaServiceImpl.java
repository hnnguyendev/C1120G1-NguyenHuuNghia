package case_study.services.impl;

import case_study.repositories.IRepository;
import case_study.repositories.impl.RepositoryImpl;
import case_study.models.Villa;
import case_study.services.IVillaService;
import case_study.utils.comparison.CompareVillaByName;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class VillaServiceImpl implements IVillaService {

    private static final String FILE_NAME = "villa.csv";

    IRepository<Villa> repository = new RepositoryImpl<>();

    @Override
    public Villa findById(String id) {
        List<Villa> villaList = findAll();
        for (Villa villa : villaList) {
            if (id.equals(villa.getId())) {
                return villa;
            }
        }

        return null;
    }

    @Override
    public List<Villa> findAll() {
        List<String[]> listString = repository.readFile(FILE_NAME);
        List<Villa> villaList = new ArrayList<>();
        for (String[] strings : listString) {
            Villa villa = new Villa(strings);
            villaList.add(villa);
        }

        return villaList;
    }

    @Override
    public void save(Villa villa) {
        List<Villa> villaList = findAll();
        villaList.add(villa);
        repository.writeFile(FILE_NAME, villaList, false);
    }

    @Override
    public void update(Villa newVilla, String id) {
        List<Villa> villaList = findAll();
        Villa villa = findById(id);
        int index = -1;
        for (int i = 0; i < villaList.size(); i++) {
            if (villaList.get(i).getId().equals(villa.getId())) {
                index = i;
            }
        }
        if (index != -1) {
            villaList.remove(index);
            villaList.add(index, newVilla);
            repository.writeFile(FILE_NAME, villaList, false);
        }
    }

    @Override
    public void delete(String id) {
        List<Villa> villaList = findAll();
        Villa villa = findById(id);
        int index = -1;
        for (int i = 0; i < villaList.size(); i++) {
            if (villaList.get(i).getId().equals(villa.getId())) {
                index = i;
            }
        }
        if (index != -1) {
            villaList.remove(index);
            repository.writeFile(FILE_NAME, villaList, false);
        }
    }

    @Override
    public List<Villa> searchByName(String name) {
        List<Villa> villaList = findAll();
        List<Villa> searchList = new ArrayList<>();
        for (Villa villa : villaList) {
            if (villa.getServiceName().contains(name)) {
                searchList.add(villa);
            }
        }

        return searchList;
    }

    @Override
    public TreeSet<Villa> findAllNotDuplicateName() {
        TreeSet<Villa> villaTreeSet = new TreeSet<>(new CompareVillaByName());
        List<Villa> villaList = findAll();

//        for (Villa villa : villaList) {
//            villaTreeSet.add(villa);
//        }
        villaTreeSet.addAll(villaList);

        return villaTreeSet;
    }

}
