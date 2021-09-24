package org.acoe.com.listener;

import org.acoe.com.utils.DataProviderUtils;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Annotation transformer that setups the different attributes in the test during runtime
 * @date September 23, 2021
 * @author Anthony Joseph Manigos
 */
public final class AnnotationTransformer implements IAnnotationTransformer {

    /**
     * Transform method where it executes runtime changing the dateProvider, retryAnalyzer of the test annotation
     * @param annotation - The @Test annotation
     * @param aClass - The test class - not in use
     * @param constructor - The test constructor - not in use
     * @param method - The test method - not in use
     * @see org.testng.annotations.Test
     */
    @Override
    public void transform(ITestAnnotation annotation, Class aClass, Constructor constructor, Method method) {
        annotation.setDataProvider("getData");
        annotation.setDataProviderClass(DataProviderUtils.class);
        annotation.setRetryAnalyzer(RetryFailedTest.class);
    }
}
