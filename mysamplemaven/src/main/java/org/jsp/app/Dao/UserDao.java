package org.jsp.app.Dao;

import org.jsp.app.model.*;
import org.springframework.stereotype.Repository;;

@Repository
public interface UserDao {
  void register(User user);
  User validateUser(Login login);
}
