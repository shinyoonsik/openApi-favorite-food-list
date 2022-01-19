package com.example.restaurent.controller;

import com.example.restaurent.wishlist.dto.WishListDto;
import com.example.restaurent.wishlist.service.WishListH2Service;
//import com.example.restaurent.wishlist.service.WishListService;
import com.example.restaurent.wishlist.service.WishListMysqlService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/food")
@RequiredArgsConstructor
public class ApiController {

  private final WishListH2Service wishListH2Service;
  private final WishListMysqlService wishListMysqlService;

  // error: mysql로 바꾼 결과, search후 id값을 받아오지 않으므로 db에 넣을때 id가 없으면 자동 증가시켜서 insert하기
  @GetMapping("/search")
  public WishListDto search(@RequestParam String query){
    return wishListMysqlService.search(query);
  }

  @PostMapping("")
  public WishListDto add(@RequestBody WishListDto wishListDto){
    log.info("{}", wishListDto);
    return wishListMysqlService.add(wishListDto);
  }

  @GetMapping("/wish-list")
  public List<WishListDto> findAll(){
    return wishListMysqlService.findAll();
  }

  @DeleteMapping("/{index}")
  public void delete(@PathVariable Long index){
    wishListMysqlService.delete(index);
  }

  @PostMapping("/{index}")
  public void addVisit(@PathVariable Long index){
    wishListMysqlService.addVisit(index);
  }
}
