package com.springframework.boot.data.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cource {

	@Id
	@SequenceGenerator(name = "cource_sequence", sequenceName = "cource_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cource_sequence")
	private Long courceId;
	private String title;
	private Integer credit;
	
	@OneToOne(mappedBy = "cource")
	private CourceMaterial courceMaterial;
	
}
