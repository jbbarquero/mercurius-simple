package com.malsolo.mercurius.simple.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.malsolo.mercurius.simple.MercuriusSimpleApplication;
import com.malsolo.mercurius.simple.domain.Address;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MercuriusSimpleApplication.class)
@Transactional
public class AddressRepositoryTest {

	@Autowired
	AddressRepositoryInitData initData;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Before
	public void populateDatabase() {
		initData.init();
	}
	
	@Test
	public void testMarkerMethod() {
	}

	@Test
	public void testFindAll() {
		List<Address> address = this.addressRepository.findAll();
		assertNotNull(address);
		assertTrue(address.size() > 0);
		assertEquals(2, address.size());
	}
}
