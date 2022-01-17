package com.example.restaurent.wishlist.entity;

import com.example.restaurent.db.MemoryDbEntity;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WishListEntity extends MemoryDbEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String title;           // 음식명, 장소명
  private String category;
  private String address;         // 주소
  private String roadAddress;     // 도로명
  private String homePageLink;
  private String imageLink;
  private boolean isVisit;
  private int visitCount;
  private LocalDateTime lastVisitDate;

}
