package cybersoft.group6.finalProject.eLearning.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Configuration
public class JpaConfig {

	@Component
	public interface GenericRepository<T,ID> extends JpaRepository<T, ID>{
		
	}
}
