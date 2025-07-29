 package com.data.service;
  
  import java.util.List;
  import com.data.model.User;
  
  public interface UserService {
      boolean add_user(User user);
      boolean delete_user_by_id(int u_id);
      User get_user_by_id(int u_id);
      List<User> get_all_user();
  }