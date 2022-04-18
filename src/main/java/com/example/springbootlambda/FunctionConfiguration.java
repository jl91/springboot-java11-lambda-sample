package com.example.springbootlambda;
//
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.cloud.function.context.FunctionRegistration;
//import org.springframework.cloud.function.context.FunctionType;
//import org.springframework.cloud.function.context.FunctionalSpringApplication;
//import org.springframework.context.ApplicationContextInitializer;
//import org.springframework.context.support.GenericApplicationContext;
//
//import java.util.function.Function;
//
//@SpringBootConfiguration
//public class MySpringCloudFunctionPlanetApplication implements ApplicationContextInitializer<GenericApplicationContext> {
//
//	public static void main(String[] args) {
//		FunctionalSpringApplication.run(MySpringCloudFunctionPlanetApplication.class, args);
//	}
//
//	public Function<String, Boolean> containsCloud() {
//		return value -> value.contains("cloud");
//	}
//
//	@Override
//	public void initialize(GenericApplicationContext context) {
//		context.registerBean(
//				"containsCloud",
//				FunctionRegistration.class,
//				() -> new FunctionRegistration<>(containsCloud())
//						.type(FunctionType
//								.from(String.class)
//								.to(Boolean.class)));
//	}
//
//}



import java.util.function.Function;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FunctionConfiguration {

	/*
	 * You need this main method (empty) or explicit <start-class>example.FunctionConfiguration</start-class>
	 * in the POM to ensure boot plug-in makes the correct entry
	 */
	public static void main(String[] args) {
		// empty unless using Custom runtime at which point it should include
		// SpringApplication.run(FunctionConfiguration.class, args);
	}

	@Bean
	public Function<String, String> uppercase() {
		return value -> {
			if (value.equals("exception")) {
				throw new RuntimeException("Intentional exception");
			}
			else {
				return value.toUpperCase();
			}
		};
	}
}