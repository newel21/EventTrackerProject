package com.skilldistillery.equipment.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EquipmentTests {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Equipment equipment;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("EquipmentTracker");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		equipment = em.find(Equipment.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void test_Equipment_mapping() {
		assertEquals("M4/M4A1 5.56mm Carbine", equipment.getName());
		assertEquals("The M4/M4A1 5.56mm Carbine is a lightweight rifle", equipment.getDescription());
		assertEquals("1005012310973", equipment.getNsn());
		assertEquals("M412345", equipment.getSerial());
		assertEquals(1, equipment.getQuantity());
		assertEquals(634, equipment.getPrice());
	}

}
