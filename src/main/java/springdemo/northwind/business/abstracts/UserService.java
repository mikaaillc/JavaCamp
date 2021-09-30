package springdemo.northwind.business.abstracts;

import springdemo.northwind.core.entities.User;
import springdemo.northwind.core.utilities.results.DataResult;
import springdemo.northwind.core.utilities.results.Result;


public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
}
