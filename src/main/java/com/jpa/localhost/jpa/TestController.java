package com.jpa.localhost.jpa;


import com.jpa.localhost.jpa.dao.CustomerRepositry;
import com.jpa.localhost.jpa.entity.CustomerRight;
import com.jpa.localhost.jpa.entity.ThirdRight;
import com.jpa.localhost.jpa.service.RightServiceImpl;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
@Log
public class TestController {

    @Autowired
    private RightServiceImpl rightService;

    @RequestMapping(value = "/right",method = RequestMethod.GET)
    public String saveRight() throws Exception {

        rightService.saveRitht(0);

        return "";

    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteRight(@PathVariable("id") Integer id){
        /*CustomerRight customerRight = customerRepositry.getOne(id);
        if(customerRight!=null){
            customerRepositry.delete(customerRight);
        }*/
        return "";
    }
}
