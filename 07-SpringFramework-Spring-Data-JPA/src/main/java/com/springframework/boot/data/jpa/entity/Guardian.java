package com.springframework.boot.data.jpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@AttributeOverrides({@AttributeOverride(name = "name", column = @Column(name = "guardian_name")),
					@AttributeOverride(name = "email", column = @Column(name = "guardian_email")),
					@AttributeOverride(name = "mobile", column = @Column(name = "guardian_mobile"))
})
public class Guardian {

	private String name;
	private String email;
	private String mobile;
}
