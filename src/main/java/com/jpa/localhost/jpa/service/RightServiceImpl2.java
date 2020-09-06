package com.jpa.localhost.jpa.service;

import com.jpa.localhost.jpa.dao.CustomerRepositry;
import com.jpa.localhost.jpa.entity.CustomerRight;
import com.jpa.localhost.jpa.entity.ThirdRight;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Log
public class RightServiceImpl2 {

    @Autowired
    private CustomerRepositry customerRepositry;

//    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
//    public CustomerRight saveRitht(Integer i){
//        CustomerRight customerRight = save(i);
//        try {
//            saveRitht2(i+1);
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        }
//        return customerRight;
//    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public CustomerRight saveRitht2(Integer i) throws NullPointerException {
        CustomerRight customerRight = null;
        customerRight = save(i);
        throw new RuntimeException();
    }

    private CustomerRight save(Integer i ){
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
        return customerRight;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteRightById(Integer id){
        CustomerRight customerRight = customerRepositry.getOne(id);
        if(customerRight!=null){
            customerRepositry.delete(customerRight);
        }
    }


//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void batchSaveAndDel() {
//        CustomerRight right1 = saveRitht(0);
//        log.info( " ====== 1 ====== "+right1);
//        try {
//            CustomerRight right2 = null;
//            right2 = saveRitht2(1);
//            log.info( " ====== 2 ====== "+right2);
//        }catch (Exception e){
//            log.info(" ====== "+e.getLocalizedMessage());
//        }
//
//
//
////        throw new NullPointerException();
//
//    }
}
