package com.labours;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.labours.model.LabourRepository;
import com.labours.model.Labours;

@SpringBootApplication
@EnableMongoRepositories(basePackages="com.labours.model")
@Component
@Service
public class LaboursinfoApplication implements CommandLineRunner {
	@Autowired
	LabourRepository repo;
	void createLabourInfo() {
		System.out.println("Data creation started...");
		repo.save(new Labours("A","A", "Mudigere", "577132", "Mudigere","Chikkamagaluru","Karnataka"));
		repo.save(new Labours("B","B", "Belur", "577122", "Belur","Hassan","Karnataka"));
		repo.save(new Labours("C","C", "Belur", "577122", "Belur","Hassan","Karnataka"));
		repo.save(new Labours("D","D", "Hassan", "577133", "Hassan","Hassan","Karnataka"));
		repo.save(new Labours("E","E", "Hassan", "577133", "Hassan","Hassan","Karnataka"));
        System.out.println("Data creation complete...");
	}
	public void showAllLabours() {
         
		repo.findAll("577132").forEach(person -> System.out.println(getLabourDetails(person)));
		
     }
	// 2. Get item by name
    public void getLabourByName(String name) {
        System.out.println("Getting item by name: " + name);
        Labours item = repo.findLabourByName(name);
        System.out.println(getLabourDetails(item));
    }
    
    // 3. Get name and quantity of a all items of a particular category
    public void getLabourByPincode(String pincode) {
        System.out.println("Getting items for the category " + pincode);
        List<Labours> list = repo.findAll(pincode);
        
        list.forEach(item -> System.out.println("Name: " + item.getPerson_name() + ", PINCODE: " + item.getPincode()));
    }
    
    // 4. Get count of documents in the collection
    public void findCountOfGroceryItems() {
        long count = repo.count();
        System.out.println("Number of documents in the collection: " + count);
    }
    public String getLabourDetails(Labours labour) {

        System.out.println(
        "Item Name: " + labour.getPerson_name() + 
        ", \nQuantity: " + labour.getPincode() +
        ", \nItem Category: " + labour.getTaluk()
        );
        
        return "";
    }
    
    public void updatePinCode(String PINCODE,String NewPINCODE) {
        
   
        
        // Find all the items with the category snacks
        List<Labours> list = repo.findAll(PINCODE);
        
        list.forEach(item -> {
            // Update the category in each document
            item.setPincode(NewPINCODE);
        });
        
        // Save all the items in database
        List<Labours> itemsUpdated = repo.saveAll(list);
        
        if(itemsUpdated != null)
            System.out.println("Successfully updated " + itemsUpdated.size() + " items.");         
    }
 // DELETE
    public void deleteGroceryItem(String id) {
        repo.deleteById(id);
        System.out.println("Item with id " + id + " deleted...");
    }
    
public void run(String... args) {
    try {    
	System.out.println("-------------CREATE LABOUR INFO-------------------------------\n");
        
        createLabourInfo();
        
        System.out.println("\n----------------SHOW ALL LABOURS---------------------------\n");
        
        showAllLabours();
        
        System.out.println("\n--------------GET ITEM BY NAME-----------------------------------\n");
        
        getLabourByName("C");
        
        System.out.println("\n-----------GET ITEMS BY PINCODE--------------------------------\n");
        
        getLabourByPincode("577132");
    
        System.out.println("\n-----------UPDATE CATEGORY NAME OF SNACKS CATEGORY----------------\n");
        
        updatePinCode("577132","577139");    
                
        System.out.println("\n----------DELETE A GROCERY ITEM----------------------------------\n");
        
        deleteGroceryItem("E");
        
        System.out.println("\n------------FINAL COUNT OF GROCERY ITEMS-------------------------\n");
        
        findCountOfGroceryItems();
        
        System.out.println("\n-------------------THANK YOU---------------------------");
    }
    catch(Exception e) {
    	System.out.println(e.fillInStackTrace());
    }
    }
	public static void main(String[] args) {
		SpringApplication.run(LaboursinfoApplication.class, args);
	}

}
