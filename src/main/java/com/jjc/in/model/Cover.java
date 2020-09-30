package com.jjc.in.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="cov_tab")
public class Cover {
	
	@Id
	@GeneratedValue
	@Column(name="cov_id_col")
	private Integer cId;
	
	@Column(name="cov_mod_name_col")
	private String  cModelName;
	
	@Column(name="cov_col_name_col")
	private String  cColorName;
	
	@Column(name="cov_type_col")
	private String cCoverType;
	
	@Column(name="cov_b_cost_col")
	private Double  cBCost;
	
	@Column(name="cov_s_cost_col")
	private Double  cSCost;

}
