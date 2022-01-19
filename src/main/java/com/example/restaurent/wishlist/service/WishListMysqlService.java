package com.example.restaurent.wishlist.service;

import com.example.restaurent.naver.NaverClient;
import com.example.restaurent.naver.dto.SearchImageReq;
import com.example.restaurent.naver.dto.SearchLocalReq;
import com.example.restaurent.wishlist.dto.WishListDto;
import com.example.restaurent.wishlist.entity.WishListEntity;
import com.example.restaurent.wishlist.mysql.WishListMysqlRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// Mysql에 넣기
@Service
@RequiredArgsConstructor
public class WishListMysqlService {

  private final NaverClient naverClient;
  private final WishListMysqlRepository wishListMysqlRepository;

  public WishListDto search(String qurey){
    var searchLocalReq = new SearchLocalReq();
    searchLocalReq.setQuery(qurey);

    var searchLocalRes = naverClient.searchLocal(searchLocalReq);
    if(searchLocalRes.getTotal() > 0){
      var localItem = searchLocalRes.getItems().stream().findFirst().get();

      var imageQuery = localItem.getTitle().replaceAll("<[^>]*>", "");
      var searchImgaeReq = new SearchImageReq();
      searchImgaeReq.setQuery(imageQuery);

      var searchImageRes = naverClient.searchImage(searchImgaeReq);
      if(searchImageRes.getTotal() > 0){
        var imageItem = searchImageRes.getItems().stream().findFirst().get();

        // 결과를 리턴
        var result = new WishListDto();
        result.setTitle(localItem.getTitle());
        result.setCategory(localItem.getCategory());
        result.setAddress(localItem.getAddress());
        result.setRoadAddress(localItem.getRoadAddress());
        result.setHomePageLink(localItem.getLink());
        result.setImageLink(imageItem.getLink());

        return result;
      }
    }
    return new WishListDto();
  }

  public WishListDto add(WishListDto wishListDto){
    var entity = dtoToEntity(wishListDto);
    System.out.println(entity.toString());
    var saveEntity = wishListMysqlRepository.save(entity);
    return entityToDto(saveEntity);
  }

  // dto -> entity
  private WishListEntity dtoToEntity(WishListDto wishListDto){
    var entity = new WishListEntity();

    entity.setVisitCount(wishListDto.getVisitCount());
    entity.setVisit(wishListDto.isVisit());
    entity.setRoadAddress(wishListDto.getRoadAddress());
    entity.setLastVisitDate(wishListDto.getLastVisitDate());
    entity.setTitle(wishListDto.getTitle());
    entity.setCategory(wishListDto.getCategory());
    entity.setAddress(wishListDto.getAddress());
    entity.setImageLink(wishListDto.getImageLink());
    entity.setHomePageLink(wishListDto.getHomePageLink());
    entity.setId(wishListDto.getId());

    return entity;
  }

  // entity -> dto
  private WishListDto entityToDto(WishListEntity wishListEntity){
    var dto = new WishListDto();

    dto.setId(wishListEntity.getId());
    dto.setImageLink(wishListEntity.getImageLink());
    dto.setVisit(wishListEntity.isVisit());
    dto.setHomePageLink(wishListEntity.getHomePageLink());
    dto.setCategory(wishListEntity.getCategory());
    dto.setAddress(wishListEntity.getAddress());
    dto.setTitle(wishListEntity.getTitle());
    dto.setRoadAddress(wishListEntity.getRoadAddress());
    dto.setVisitCount(wishListEntity.getVisitCount());
    dto.setLastVisitDate(wishListEntity.getLastVisitDate());

    return dto;
  }

  public List<WishListDto> findAll(){
    return wishListMysqlRepository.findAll()
        .stream()
        .map(element -> entityToDto(element))
        .collect(Collectors.toList());
  }

  public void delete(Long id){
    wishListMysqlRepository.deleteById(id);
  }

  public void addVisit(Long id){
    var wishItem = wishListMysqlRepository.findById(id);
    if (wishItem.isPresent()) {
      var item = wishItem.get();
      item.setVisit(true);
      item.setVisitCount(item.getVisitCount() + 1);
      wishListMysqlRepository.save(item);
    }
  }
}

