package com.deliver.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.deliver.entities.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>  {

}
