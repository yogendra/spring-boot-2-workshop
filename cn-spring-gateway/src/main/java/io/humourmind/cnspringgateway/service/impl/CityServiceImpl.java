package io.humourmind.cnspringgateway.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import io.humourmind.cnspringgateway.domain.City;
import io.humourmind.cnspringgateway.service.CityService;
import reactor.core.publisher.Mono;

@Service
public class CityServiceImpl extends AbstractBaseService implements CityService {

	protected CityServiceImpl(WebClient webClient) {
		super(webClient);
	}

	@Override
	public Mono<City> getCityByPostalCode(String postalCode) {
		return getWebClient().get()
				.uri("{protocol}://{serviceId}/v1/cities/{postalCode}", getProtocol(), serviceId, postalCode)
				.retrieve().bodyToMono(City.class);
	}

	@Override
	@Value("${service.city:cn-city-service}")
	void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
}
