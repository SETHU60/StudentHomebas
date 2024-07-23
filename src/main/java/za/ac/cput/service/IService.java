package za.ac.cput.service;
import org.springframework.stereotype.Service;

@Service
public interface IService<T, ID> {

    T save(T t);

    T read(ID id);

    T update(T t);

    boolean deleteById(ID id);
}

