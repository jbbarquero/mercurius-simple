package com.malsolo.mercurius.simple.infrastructure.actuate;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Service;

@Service
public class MeasureService {

	private final CounterService counterService;
	private final GaugeService gaugeService;

	private final Random random = new Random();

	@Autowired
	public MeasureService(CounterService counterService, GaugeService gaugeService) {
		this.counterService = counterService;
		this.gaugeService = gaugeService;
	}
	
	public void call() {
		this.counterService.increment("mercurius.counter");
		this.gaugeService.submit("mercurius.gauge", random.nextDouble());
	}
	
}
