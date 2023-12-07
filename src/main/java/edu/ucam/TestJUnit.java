package edu.ucam;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class TestJUnit {
	
		@Test
		public void testCrearClase() {
			System.out.println("testCrearClase\n-------\n");
			String a="Clase creada exitosamente.";
			Gestion gestion=new Gestion();
			assertEquals(a,gestion.crearClase("A"));
		}
		
		
		@Test
		public void testExisteAlumnoEnClase_A() {
			System.out.println("testExisteAlumnoEnClase_A\n-------\n");
			Gestion gestion=new Gestion();
			assertTrue(gestion.existeAlumnoEnClase("John 1"));
		}
		
		@Test
		public void testExisteAlumnoEnClase_B() {
			System.out.println("testExisteAlumnoEnClase_B\n-------\n");
			Gestion gestion=new Gestion();
			Estudiante estudiante = new Estudiante("Juan Estopa",gestion.crearClase("Letras","0"));
			gestion.agregarEstudianteAClase("Letras", "Juan Estopa");
			assertFalse(gestion.existeAlumnoEnClase("Juan Estopa"));
		}
		
		@Test
		public void testReferenciaAlumnoEnClase_A() {
			System.out.println("testReferenciaAlumnoEnClase_A\n-------\n");
			Gestion gestion=new Gestion();
			Estudiante estudiante = new Estudiante("J T",gestion.crearClase("IT","0"));
			gestion.agregarEstudianteAClase("IT", "J T");
			assertNull(gestion.referenciaAlumnoEnClase("J T"));
		}
		
		@Test
		public void testReferenciaAlumnoEnClase_B() {
			System.out.println("testReferenciaAlumnoEnClase_B\n-------\n");
			Gestion gestion=new Gestion();
			String clase= "Ciencias";
			String nombre="John Connor";
			gestion.crearClase(clase);
			gestion.agregarEstudianteAClase(clase,nombre);
			assertNotNull(gestion.referenciaAlumnoEnClase(nombre));
		}
		
		@Test
		public void testReferenciaAlumnoEnClase_C() {
			System.out.println("testReferenciaAlumnoEnClase_C\n-------\n");
			String clase= "Ciencias";
			String nombre="John AA";
			Gestion gestion=new Gestion();
			Estudiante estudiante =gestion.referenciaAlumnoEnClase(nombre);
			assertSame(estudiante,gestion.referenciaAlumnoEnClase(nombre));
		}
		
		@Test
		public void testReferenciaAlumnoEnClase_D() {
			System.out.println("testReferenciaAlumnoEnClase_D\n-------\n");
			String clase= "Ciencias";
			String nombre="John Estopa";
			Gestion gestion=new Gestion();
			Estudiante estudiante = new Estudiante("Juan Estopa",gestion.crearClase("Letras","0"));
		
			assertNotSame(estudiante,gestion.referenciaAlumnoEnClase(nombre));
		}
		
		@Test
		public void testAssertArrayEquals() {
			System.out.println("testCompararInformacionDeTodasLasClases\n-------\n");
	        Gestion gestion = new Gestion();
	        
	        int[] actual = gestion.obtenerInformacionDeTodasLasClases();

	        int[] expected = {1, 2, 3}; 

	        // Compara los arrays
	        assertArrayEquals(expected, actual);		
	        }
		
}
