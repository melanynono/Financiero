package com.krakedev.financiero.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestPruebaDepositar {

	@Test
	public void depositarMontoPositivo() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("123", "Juan", "Perez");
		Cuenta cuenta = banco.crearCuenta(cliente);
		boolean resultado = banco.depositar(100, cuenta);
		assertTrue(resultado);
		assertEquals(100, cuenta.getSaldoActual());
	}

	@Test
	public void depositarMontoCero() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("123", "Juan", "Perez");
		Cuenta cuenta = banco.crearCuenta(cliente);
		boolean resultado = banco.depositar(0, cuenta);
		assertFalse(resultado);
		assertEquals(0, cuenta.getSaldoActual());
	}

	@Test
	public void depositarMontoNegativo() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("123", "Juan", "Perez");
		Cuenta cuenta = banco.crearCuenta(cliente);
		boolean resultado = banco.depositar(-50, cuenta);
		assertFalse(resultado);
		assertEquals(0, cuenta.getSaldoActual());
	}
}
