package com.malsolo.mercurius.simple.infrastructure.actuate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;

public class MercuriusPublicMetrics implements PublicMetrics {

	private final Random random = new Random();

	@Override
	public Collection<Metric<?>> metrics() {
		return Arrays.asList(new Metric<>("mercurius.public", random.nextInt()));
	}

}
