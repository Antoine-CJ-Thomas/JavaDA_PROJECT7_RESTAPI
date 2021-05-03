package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * This class stores the data of a rule
 */
@Entity
@Table(name = "rulename")
public class Rule {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;

    @NotBlank
    @Size(min=8, max=16)
	private String name;
    
    @NotBlank
    @Size(min=8, max=16)
	private String description;
    
    @NotBlank
    @Size(min=8, max=16)
	private String json;
    
    @NotBlank
    @Size(min=8, max=16)
	private String template;
    
    @NotBlank
    @Size(min=8, max=16)
	private String sqlStr;
    
    @NotBlank
    @Size(min=8, max=16)
	private String sqlPart;

	public Rule() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getSqlStr() {
		return sqlStr;
	}

	public void setSqlStr(String sqlStr) {
		this.sqlStr = sqlStr;
	}

	public String getSqlPart() {
		return sqlPart;
	}

	public void setSqlPart(String sqlPart) {
		this.sqlPart = sqlPart;
	}
}
