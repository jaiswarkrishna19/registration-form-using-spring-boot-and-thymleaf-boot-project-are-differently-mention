 package com.data.service;
  
  import java.util.List;
  
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Service;
  
  import com.data.model.User;
  import com.data.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean add_user(User user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean delete_user_by_id(int u_id) {
        userRepository.deleteById(u_id);
        return true;
    }

    @Override
    public User get_user_by_id(int u_id) {
        return userRepository.findById(u_id).orElse(null);
    }

    @Override
    public List<User> get_all_user() {
        return userRepository.findAll();
    }
}
