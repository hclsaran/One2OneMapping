package com.saran;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="EmpOne2One")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	@Column(name="cell_phone")
	private String cellphone;

	/*
	 CascadeType.ALL is that the persistence will propagate (cascade) all EntityManager 
	 operations (PERSIST, REMOVE, REFRESH, MERGE, DETACH) to the relating entities.
	 */
	
	@OneToOne(mappedBy="employee", cascade=CascadeType.ALL)
	private Address employeeDetail; //HAS A
	
	public Employee(String firstname,String lastname,Date birthDate,String cellphone) {
		this.firstname=firstname;
		this.lastname=lastname;
		this.birthDate=birthDate;
		this.cellphone=cellphone;
	}
	
}
