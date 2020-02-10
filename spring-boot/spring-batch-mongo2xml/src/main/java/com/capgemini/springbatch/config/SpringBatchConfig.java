package com.capgemini.springbatch.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.capgemini.springbatch.domain.Report;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Bean
	public Job job() throws Exception {
		return jobBuilderFactory.get("readReport").flow(step1()).end().build();
	}

	@Bean
	public Step step1() throws Exception {
		return stepBuilderFactory.get("step1").<Report, Report>chunk(10).reader(mongo_reader()).writer(xml_writer())
				.build();
	}

	@Bean
	public MongoItemReader<Report> mongo_reader() {
		MongoItemReader<Report> reader = new MongoItemReader<>();
		reader.setTemplate(mongoTemplate);

		reader.setSort(new HashMap<String, Sort.Direction>() {
			{
				put("_id", Direction.DESC);
			}
		});

		reader.setTargetType(Report.class);
		reader.setQuery("{}");
		return reader;
	}

	@Bean
	public StaxEventItemWriter<Report> xml_writer() {
		StaxEventItemWriter<Report> writer = new StaxEventItemWriter<>();
		writer.setResource(new FileSystemResource("output/mongo.xml"));
		writer.setMarshaller(xml_unmarshaller());
		writer.setRootTagName("reports");
		return writer;
	}

	@Bean
	public XStreamMarshaller xml_unmarshaller() {
		XStreamMarshaller unMarshaller = new XStreamMarshaller();
		Map<String, Class> aliases = new HashMap<String, Class>();
		aliases.put("report", Report.class);
		unMarshaller.setAliases(aliases);
		return unMarshaller;
	}

}