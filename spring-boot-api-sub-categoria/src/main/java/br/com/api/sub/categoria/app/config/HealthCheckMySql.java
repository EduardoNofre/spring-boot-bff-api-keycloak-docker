package br.com.api.sub.categoria.app.config;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariDataSource;

import lombok.var;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HealthCheckMySql{

	private Environment env;
    private final HikariDataSource dataSource;

    public HealthCheckMySql(HikariDataSource dataSource, Environment env) {
    	log.info("[HealthCheckMySql] - iniciando");
        this.dataSource = dataSource;
        this.env = env;
    }

    public String health(){
    	try (var connection = dataSource.getConnection()) {
            var statement = connection.prepareStatement(env.getProperty("spring.datasource.hikari.connection-test-query"));
            statement.execute();
            return "UP";
        } catch (Exception ex) {
        	log.error(ex.getMessage());
        	return "DOWN"; 
        }
    }
}