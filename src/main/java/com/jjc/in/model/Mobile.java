package com.jjc.in.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="mob_tab")
public class Mobile {

	@Id
	@GeneratedValue
	@Column(name="mob_id_col")
	private Integer mobId;
	
	@Column(name="mob_bran_name_col")
	private String  mobBrandName;
	
	@Column(name="mob_mode_name_col")
	private String  mobModelName;
	
	@Column(name="mob_inStk_col")
	private Integer mobInStock;
	
	@Column(name="mob_b_cost_col")
	private Double  mobBCost;
	
	@Column(name="mob_s_cost_col")
	private Double  mobSCost;
	 
	
	
	
	
}

