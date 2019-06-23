package com.coviam.quizSocialCMS.CMS;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@SpringBootApplication
public class CmsApplication extends AbstractMongoConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);
	}

	@Override
	protected String getDatabaseName() {
		return "ScreenedData";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("localhost",27017);
	}
}

