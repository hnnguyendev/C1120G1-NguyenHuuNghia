package case_study.repositories;

import java.util.List;

public interface IRepository<T> {

    void writeFile(String fileName, List<T> list, boolean append);

    List<String[]> readFile(String fileName);

}
