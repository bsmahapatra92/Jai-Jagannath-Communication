package com.jjc.in.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ear_ph_tab")
public class EarPhone {

	@Id
	@GeneratedValue
	@Column(name="ear_ph_id_col")
	private Integer earPhId;
	
	@Column(name="ear_ph_brand_col")
	private String  earPhBrand;
	
	@Column(name="ear_ph_model_col")
	private String  earPhModel;
	
	@Column(name="ear_ph_colr_col")
	private String  earPhColor;
	
	@Column(name="ear_ph_b_cost_col")
	private Double  earPhBCost;
	
	@Column(name="ear_ph_s_cost_col")
	private Double  earphSCost;
	
	
	
}
