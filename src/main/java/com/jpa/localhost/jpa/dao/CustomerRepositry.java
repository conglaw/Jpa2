package com.jpa.localhost.jpa.dao;

import com.jpa.localhost.jpa.entity.CustomerRight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositry extends JpaRepository<CustomerRight,Integer>{

}
