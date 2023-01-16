package com.labours.model;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component("LabourRepository")

public interface LabourRepository extends MongoRepository<Labours,String>{
	@Query("{person_name:'?0'}")
	Labours findLabourByName(String person_name);
    
    @Query(value="{pincode:'?0'}", fields="{'person_name' : 1, 'district' : 1,'taluk':1,'pincode':1}")
    List<Labours> findAll(String pincode);
    
   
    public long count();
}
