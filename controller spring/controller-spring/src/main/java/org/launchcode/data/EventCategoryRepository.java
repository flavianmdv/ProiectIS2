package org.launchcode.data;


import org.launchcode.models.EventCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventCategoryRepository extends CrudRepository<EventCategory, Integer> {

}