package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.IAnnotationTransformer;

public class IAnnotationTransformerImpl implements IAnnotationTransformer{
	public void transform(ITestAnnotation annotation, Class testClass, 
			Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(IRetryAnalyzerImpl.class);
	}
}
