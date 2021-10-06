/**
 * 
 */
package org.springangularexample;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author manojkumar.m
 *
 */
public class SpringAngularExampleServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
		return builder.sources(SpringAngularExampleApplication.class);
	}

}
