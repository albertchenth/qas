package com.cth.qas.configuration;

import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.ConfigurationSource;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.cth.qas.repository")
@EnableTransactionManagement
public class GraphDBConfiguration {

	private static final Logger logger = LoggerFactory
			.getLogger(GraphDBConfiguration.class);
	public static final String PROPERTIES_FILE = "ogm-bolt.properties";

	@Bean
	public SessionFactory sessionFactory() {
		// with domain entity base package(s)
		String[] packages = { "com.cth.qas.entity", "com.cth.qas.relation" };
		return new SessionFactory(configuration(), packages);
	}

	@Bean
	public org.neo4j.ogm.config.Configuration configuration() {
		ConfigurationSource properties = new ClasspathConfigurationSource(
				PROPERTIES_FILE);
		org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder(
				properties).build();
		if (logger.isInfoEnabled()) {
			logger.info("PROPERTIES_FILE:" + PROPERTIES_FILE);
			logger.info("configuration build... ");
		}
		return configuration;
	}

	@Bean
	public Neo4jTransactionManager transactionManager() {
		return new Neo4jTransactionManager(sessionFactory());
	}

}
