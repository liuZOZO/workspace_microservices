package com.trainticket.query_ordinary.repository;

import com.trainticket.query_ordinary.domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Chenjie Xu on 2017/3/14.
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, String> {

    List<Item> findByStartingAndDestination(String staring, String destination);
}
