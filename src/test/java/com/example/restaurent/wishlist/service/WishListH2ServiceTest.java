package com.example.restaurent.wishlist.service;

import com.example.restaurent.wishlist.entity.WishListEntity;
import com.example.restaurent.wishlist.h2.WishListH2Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WishListH2ServiceTest {

  @Autowired
  WishListH2Repository wishListH2Repository;


  private WishListEntity create(){
    var testObj = new WishListEntity();
    testObj.setCategory("몰라");
    testObj.setTitle("테스트");
    testObj.setVisit(true);
    testObj.setRoadAddress("미성길");
    return testObj;
  }

  @Test
  void addVisitTest(){
    var test1 = create();
    wishListH2Repository.save(test1);
//    var wishItem = wishListH2Repository.findById()
  }
}