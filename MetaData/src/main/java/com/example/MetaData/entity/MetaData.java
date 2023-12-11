package com.example.MetaData.entity;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@NoArgsConstructor
@Table(name="migrated_data")
public class MetaData {

	
	
	
	 
	

	@Column(name="file_name")
	private String file_name;
	
	@Id
	@Column(name="ObjectID")
	private int objectID;

	

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public int getObjectID() {
		return objectID;
	}

	public void setObjectID(int objectID) {
		this.objectID = objectID;
	}


	public MetaData( String file_name, int objectID) {
		
		this.file_name = file_name;
		this.objectID = objectID;
	}

	@Override
	public String toString() {
		return "MetaData{" +
				"file_name='" + file_name + '\'' +
				", objectID=" + objectID +
				'}';
	}
}
