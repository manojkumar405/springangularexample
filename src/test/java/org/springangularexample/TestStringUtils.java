/**
 * 
 */
package org.springangularexample;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * @author manojkumar.m
 *
 */
public class TestStringUtils {

	@Test
	public void test() {
		System.out.println(StringUtils
				.capitalize(StringUtils.join(StringUtils.splitByCharacterTypeCamelCase("sequenceNumber"), ' ')));
	}

}
