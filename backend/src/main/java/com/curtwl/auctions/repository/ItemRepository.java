package com.curtwl.auctions.repository;

import com.curtwl.auctions.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}