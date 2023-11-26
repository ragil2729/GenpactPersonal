package com.example.MetaData.entity;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@NoArgsConstructor
@Table(name="migrated_data")
public class MetaData {

	
	@Id
	@Column(name = "id")
	private int id;
	 
	

	@Column(name="file_name")
	private String file_name;
	
	
	
	  public int getId() { return id; }
	  
	  
	  public void setId(int id) { this.id = id; }
	  
	  
	  public String getFile_name() { return file_name; }
	  
	  
	  public void setFile_name(String file_name) { this.file_name = file_name; }
	 
	
	

	public MetaData(int id, String file_name) {
		this.id = id;
		this.file_name = file_name;
	}


	@Override
	public String toString() {
		return "MetaData [id=" + id + ", file_name=" + file_name + "]";
	}

	
	
	
}
