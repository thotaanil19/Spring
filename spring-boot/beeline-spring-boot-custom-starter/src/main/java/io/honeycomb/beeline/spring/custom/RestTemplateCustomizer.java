package io.honeycomb.beeline.spring.custom;

import org.springframework.web.client.RestTemplate;

@FunctionalInterface
public interface RestTemplateCustomizer {

	/**
	 * Callback to customize a {@link RestTemplate} instance.
	 * @param restTemplate the template to customize
	 */
	void customize(RestTemplate restTemplate);

}
