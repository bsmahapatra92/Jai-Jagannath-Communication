package com.jjc.in.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="speaker_tab")
public class Speaker {
	
	@Id
	@GeneratedValue
	@Column(name="spk_id_col")
	private Integer spkId;
	
	@Column(name="spk_brand_col")
	private String  spkBrand;
	
	@Column(name="spk_mod_name_col")
	private String  spkModName;
	
	@Column(name="spk_b_cost_col")
	private Double  spkBCost;
	
	@Column(name="spk_s_cost_col")
	private Double  spkSCost;
	

}
