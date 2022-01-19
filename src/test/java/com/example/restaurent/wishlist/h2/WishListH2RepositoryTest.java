package com.example.restaurent.wishlist.h2;

import com.example.restaurent.wishlist.entity.WishListEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WishListH2RepositoryTest {


  private WishListEntity create(){
    var testObj = new WishListEntity();
    testObj.setCategory("몰라");
    testObj.setTitle("테스트");
    testObj.setVisit(true);
    testObj.setRoadAddress("미성길");
    return testObj;
  }

  @Autowired
  WishListH2Repository wishListH2Repository;

  @Test
  public void insertTest(){
    wishListH2Repository.save(create());

    System.out.println(wishListH2Repository.findAll());
  }

  @Test
  public void deleteTest(){
    wishListH2Repository.save(create());
    wishListH2Repository.deleteById(1L);
    System.out.println(wishListH2Repository.findAll());
  }
}