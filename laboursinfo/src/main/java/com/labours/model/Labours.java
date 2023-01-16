package com.labours.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Document("LaboursInfo")
public class Labours {
	 @Id
	 private String id;
	 @Field("person_name")
	 private String person_name;
	 @Field("address")
	    private String address;
	 @Field("pincode")
	    private String pincode;
	 @Field("taluk")
	    private String taluk;
	 @Field("district")
	    private String district;
	 @Field("state")
	    private String state;

	    public Labours(String id, String person_name, String address, String pincode
	    		, String taluk
	    		, String district
	    		, String state) {
	        super();
	        this.id = id;
	        this.person_name = person_name;
	        this.address = address;
	        this.pincode = pincode;
	        this.taluk=taluk;
	        this.district=district;
	        this.state=state;
	    }
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getTaluk() {
		return taluk;
	}
	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
