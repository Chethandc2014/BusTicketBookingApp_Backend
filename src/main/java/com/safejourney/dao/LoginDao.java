package com.safejourney.dao;
import org.springframework.data.repository.CrudRepository;

import com.safejourney.entity.User;

public interface LoginDao extends  CrudRepository<User,String>{

}
