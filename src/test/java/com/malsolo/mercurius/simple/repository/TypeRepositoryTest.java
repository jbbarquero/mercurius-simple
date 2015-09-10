package com.malsolo.mercurius.simple.repository;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.malsolo.mercurius.simple.MercuriusSimpleApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MercuriusSimpleApplication.class)
@Transactional
public class TypeRepositoryTest {

	@Test
	public void testMarkerMethod() {
	}

}
