//package com.example.restaurent.wishlist.repository;
//
//import com.example.restaurent.wishlist.entity.WishListEntity;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class WishListRepositoryTest {
//
//  @Autowired
//  private WishListRepository wishListRepository;
//
//  private WishListEntity create(){
//    var wishList = new WishListEntity();
//    wishList.setAddress("address");
//    wishList.setCategory("category");
//    wishList.setHomePageLink("homepagelink");
//    wishList.setImageLink("imagelink");
//    wishList.setTitle("title");
//    wishList.setLastVisitDate(null);
//    wishList.setVisit(false);
//    wishList.setRoadAddress("readAddress");
//    wishList.setVisitCount(0);
//    return wishList;
//  }
//
//  @Test
//  public void saveTest(){
//    var wishListEntity = create();
//    var expected = wishListRepository.save(wishListEntity);
//
//    Assertions.assertNotNull(expected);
//    Assertions.assertEquals(1, expected.getIndex());
//  }
//
//  @Test
//  public void findByIdTest(){
//    var wishListEntity = create();
//    wishListRepository.save(wishListEntity);
//
//    var expected = wishListRepository.findById(1);
//
//    Assertions.assertEquals(true, expected.isPresent());
//    Assertions.assertEquals(1, expected.get().getIndex());
//  }
//
//  @Test
//  public void deleteTest(){
//    var wishListEntity = create();
//    wishListRepository.save(wishListEntity);
//
//    wishListRepository.deleteById(1);
//
//    int expected = wishListRepository.findAll().size();
//    Assertions.assertEquals(0, expected);
//  }
//
//  @Test
//  public void listAllTest(){
//    var wishListEntity = create();
//    wishListRepository.save(wishListEntity);
//
//    var wishListEntity2 = create();
//    wishListRepository.save(wishListEntity2);
//
//    var wishListEntity3 = create();
//    wishListRepository.save(wishListEntity3);
//
//    Assertions.assertEquals(3, wishListRepository.findAll().size());
//  }
//
//}
