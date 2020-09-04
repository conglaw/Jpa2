package com.jpa.localhost.jpa;


import com.jpa.localhost.jpa.dao.CustomerRepositry;
import com.jpa.localhost.jpa.entity.CustomerRight;
import com.jpa.localhost.jpa.entity.ThirdRight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CustomerRepositry customerRepositry;

    @RequestMapping(value = "/right",method = RequestMethod.GET)
//    @ResponseBody
    public String saveRight(){

        for(int i=0;i<10;i++){
            CustomerRight customerRight = new CustomerRight();
            customerRight.setRightId(i+1);
            customerRight.setRightName("cusTest"+(i+1));
            ThirdRight thirdRight = new ThirdRight();
            thirdRight.setRightId(i+1);
            thirdRight.setRightName("测试"+(i+1));
            thirdRight.setCustomerRight(customerRight);
            List<ThirdRight> thirdRights = new ArrayList<>();
            thirdRights.add(thirdRight);
            customerRight.setThirdRights(thirdRights);
            customerRepositry.save(customerRight);
        }

        return "";

    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteRight(@PathVariable("id") Integer id){
        CustomerRight customerRight = customerRepositry.getOne(id);
        if(customerRight!=null){
            customerRepositry.delete(customerRight);
        }
        return "";
    }
}
