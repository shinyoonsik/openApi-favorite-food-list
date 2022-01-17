package com.example.restaurent.wishlist.repository;

import com.example.restaurent.db.MemoryDbRepositoryAbstract;
import com.example.restaurent.wishlist.entity.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {
}
