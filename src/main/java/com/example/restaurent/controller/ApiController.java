package com.example.restaurent.controller;

import com.example.restaurent.wishlist.dto.WishListDto;
import com.example.restaurent.wishlist.service.WishListH2Service;
import com.example.restaurent.wishlist.service.WishListService;
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

  private final WishListService wishListService;
  private final WishListH2Service wishListH2Service;

  @GetMapping("/search")
  public WishListDto search(@RequestParam String query){
    return wishListH2Service.search(query);
  }

  @PostMapping("")
  public WishListDto add(@RequestBody WishListDto wishListDto){
    log.info("{}", wishListDto);
    return wishListH2Service.add(wishListDto);
  }

  @GetMapping("/wish-list")
  public List<WishListDto> findAll(){
    return wishListH2Service.findAll();
  }

  @DeleteMapping("/{index}")
  public void delete(@PathVariable Long index){
    wishListH2Service.delete(index);
  }

  @PostMapping("/{index}")
  public void addVisit(@PathVariable Long index){
    wishListH2Service.addVisit(index);
  }
}
