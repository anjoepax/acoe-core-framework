package org.acoe.com.annotations;


import org.acoe.com.enums.CategoryType;

import java.lang.annotation.*;

/**
 * Custom annotations to capture the author and category to be appended in the extent report
 * @date September 23, 2021
 * @author Anthony Joseph Manigos
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface FrameworkAnnotations {
    String[] author();
    CategoryType[] category();
}
