package com.SpringClasses.DMS.DSO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SpringClasses.DMS.Database.Publisher;

@Repository
public interface PublisherDSO extends CrudRepository<Publisher,Integer> {

}
