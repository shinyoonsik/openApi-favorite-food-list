package com.example.restaurent.wishlist.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.restaurent.wishlist.entity.WishListEntity;
import com.example.restaurent.wishlist.mysql.WishListMysqlRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WishListMysqlServiceTest {

  @Autowired
  WishListMysqlService wishListMysqlService;

  @Autowired
  WishListMysqlRepository wishListMysqlRepository;

  @Test
  void searchTest(){
    var temp = wishListMysqlService.search("갈비");
    System.out.println(temp);
    Assertions.assertNotNull(temp);
  }

  @Test
  void saveTest(){

    WishListEntity wishListEntity = new WishListEntity();
    wishListEntity.setTitle("울라라랄라");
    var ret = wishListMysqlRepository.save(wishListEntity);
    System.out.println(ret);
    Assertions.assertEquals(wishListEntity, ret);
//    var wishListDto = wishListMysqlService.search("갈비");
//    var result = wishListMysqlService.add(wishListDto);
//    Assertions.assertEquals(result, wishListDto);
  }
}