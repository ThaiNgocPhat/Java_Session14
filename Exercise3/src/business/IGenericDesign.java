package business;
import java.util.List;

public interface IGenericDesign<T, S> {
    List<T> getAll();
    T getById(String id);
    void add(T t);
    void update(T t);
    void delete(String id);
}
