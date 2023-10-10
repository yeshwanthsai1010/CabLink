package com.src.security;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Base64;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SecurityServicesTest {
	static SecurityServicesInterface ssi;
	@BeforeAll
	public static void initialize() {
		ssi = new SecurityServices();
	}
	@Test
	void testEncrypt() {
		assertEquals(ssi.encrypt("Yesh"),Base64.getEncoder().encodeToString("Yesh".getBytes()));
	}

	@Test
	void testDecrypt() {
		assertEquals(ssi.decrypt("Yesh"),new String(Base64.getDecoder().decode("Yesh")));

	}

}
