package com.krakedev.financiero.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestPreubaTransferir {
	
	@Test
	public void transferirMontoValido() {

	    Banco banco = new Banco();

	    Cliente cliente1 = new Cliente("123", "Juan", "Perez");
	    Cliente cliente2 = new Cliente("456", "Maria", "Lopez");

	    Cuenta origen = banco.crearCuenta(cliente1);
	    Cuenta destino = banco.crearCuenta(cliente2);

	    banco.depositar(200, origen);

	    boolean resultado = banco.transferir(origen, destino, 50);

	    assertTrue(resultado);

	    assertEquals(150, origen.getSaldoActual());
	    assertEquals(50, destino.getSaldoActual());
	}
	
	@Test
	public void transferirSinSaldoSuficiente() {

	    Banco banco = new Banco();

	    Cliente cliente1 = new Cliente("123", "Juan", "Perez");
	    Cliente cliente2 = new Cliente("456", "Maria", "Lopez");

	    Cuenta origen = banco.crearCuenta(cliente1);
	    Cuenta destino = banco.crearCuenta(cliente2);

	    banco.depositar(100, origen);

	    boolean resultado = banco.transferir(origen, destino, 150);

	    assertFalse(resultado);

	    assertEquals(100, origen.getSaldoActual());
	    assertEquals(0, destino.getSaldoActual());
	}

}
