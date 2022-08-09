package com.saran;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AddrOne2One")
public class Address {

	@Id
	@Column(name = "employee_id", unique = true, nullable = false)
	@GeneratedValue(generator = "gen") /*
										 * Note that in EmployeeDetail class we have used @GenericGenerator to specify
										 * primary key. This will ensure that the primary key from Employee table is
										 * used instead of generating a new one.
										 */
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "employee"))
	private Long employeeId;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@OneToOne // one2one association
	@PrimaryKeyJoinColumn
	private Employee employee;// HAS A

	public Address(String street, String city, String state, String country) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}
}
