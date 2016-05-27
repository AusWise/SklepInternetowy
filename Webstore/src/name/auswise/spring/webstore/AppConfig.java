package name.auswise.spring.webstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class AppConfig {
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource(){
		
		File file = new File("validation.properties");
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				System.out.println(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("blablablablablablabla");
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/resources/validation.properties");
		return messageSource;
	}
}
