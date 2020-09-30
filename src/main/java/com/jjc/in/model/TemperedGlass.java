package com.jjc.in.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="temp_glass_tab")
public class TemperedGlass {
	
	@Id
	@GeneratedValue
	@Column(name="temp_gls_id_col")
	private Integer tempGlassId;
	
	@Column(name="temp_gls_model_col")
	private String  tempGlassModel;
	
	@Column(name="temp_gls_type_col")
	private String tempGlassType;
	
	@Column(name="temp_gls_b_cost_col")
	private String  tempGlassBCost;
	
	@Column(name="temp_gls_s_cost_col")
	private String  tempGlassSCost;

}
