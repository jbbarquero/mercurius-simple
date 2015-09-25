package com.malsolo.mercurius.simple;

import javax.validation.constraints.NotNull;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("configuration")
@Data
public class ConfigurationProjectProperties {
	
	@NotNull
	private String projectName;
	
	@NotNull
	private String projectDescription;

}
