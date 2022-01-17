package com.example.restaurent.wishlist.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// WishListDto와 WishListEntity를 구별지은 이유는 DB테이블이 바뀌면 객체를 원큐로 쓰는 경우, front도 다 바꿔주어야 한다.
// 하지만, WishListDto를 둠으로써 일종의 가운데 컨버터를 두어 DB테이블이 바뀌면 WishListDto만 바꾸면 되는 간편함을 추구하기 위해서이다.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishListDto {
  private Long id;
  private String title;
  private String category;
  private String address;
  private String roadAddress;
  private String homePageLink;
  private String imageLink;
  private boolean isVisit;
  private int visitCount;
  private LocalDateTime lastVisitDate;
}
