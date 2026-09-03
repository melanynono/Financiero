package com.krakedev.financiero.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestPreubaRetirar {

	@Test
	public void retirarMontoValido() {

	    Banco banco = new Banco();

	    Cliente cliente = new Cliente("123", "Juan", "Perez");
	    Cuenta cuenta = banco.crearCuenta(cliente);

	    banco.depositar(200, cuenta);

	    boolean resultado = banco.retirar(50, cuenta);

	    assertTrue(resultado);
	    assertEquals(150, cuenta.getSaldoActual());
	}
	
	
	@Test
	public void retirarMontoMayorAlSaldo() {

	    Banco banco = new Banco();

	    Cliente cliente = new Cliente("123", "Juan", "Perez");
	    Cuenta cuenta = banco.crearCuenta(cliente);

	    banco.depositar(100, cuenta);

	    boolean resultado = banco.retirar(150, cuenta);

	    assertFalse(resultado);
	    assertEquals(100, cuenta.getSaldoActual());
	}
}
