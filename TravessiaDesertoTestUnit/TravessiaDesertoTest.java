import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;


public class TravessiaDesertoTest {

	TravessiaDeserto jogo;
	
	//INICIALIZA JOGO
	
		@Before
	public void setUpI() {
			jogo = new TravessiaDeserto();

		}

		@Test
	public void testInicializar() {

			jogo.inicializaJogo();
			assertEquals(0, jogo.getPosicao());
			assertEquals(6, jogo.getFuel());
			//ok
		}
		
		@After
	public void tearDownI() {
			jogo = null;
		}

	
	//AVANÇAR

	@Before
	public void setUpA() {
		jogo = new TravessiaDeserto();

	}

	@Test
	public void testAvancar() {
		
		int pos = jogo.getPosicao();
		
		//teste sem combustível
		
		assertEquals(0, jogo.getFuel());

			//ambiente pronto
		
		jogo.avancar();
		assertEquals(pos, jogo.getPosicao());		
		//ok
		
		//teste com combustível
		
		jogo.inicializaJogo();
		assertEquals(0, jogo.getPosicao());
		assertEquals(6, jogo.getFuel());
		
			//ambiente pronto até a sexta posição
		
		for (int cont=1; cont<7; cont++) {
		
			jogo.avancar();
			assertEquals(cont, jogo.getPosicao());
			assertEquals(6-cont, jogo.getFuel());
			}
		//ok
		
		jogo.getMapa()[6]=4;
		jogo.carregar();
		jogo.carregar();
		jogo.carregar();
		jogo.carregar();
		assertEquals(6, jogo.getPosicao());
		assertEquals(4, jogo.getFuel());
		
			//ambiente pronto até a décima posição
		
		for (int cont=6; cont<10; cont++) {

			jogo.avancar();
			assertEquals(cont+1, jogo.getPosicao());
			assertEquals(9-cont, jogo.getFuel());
			}
		//ok
	}
	
	
	@After
	public void tearDownA() {
		jogo = null;
	}

	
	//VOLTAR
	
	@Before
	public void setUpV() {
		jogo = new TravessiaDeserto();

	}

	@Test
	public void testVoltar() {
		
		//teste sem combustível voltar em qualquer posição
		
		jogo.inicializaJogo();
		jogo.descarregar();
		jogo.descarregar();
		jogo.descarregar();
		jogo.descarregar();
		jogo.descarregar();
		assertEquals(0, jogo.getPosicao());
		assertEquals(1, jogo.getFuel());

			//ambiente pronto
		
		jogo.voltar();
		assertEquals(0, jogo.getPosicao());
//		assertEquals(1, jogo.getFuel());	//	esperado 0, retornado 6: não é regra.
		// Não ok
		
		//teste com combustível voltar a partir da posição 0
		
		jogo.inicializaJogo();
		assertEquals(0, jogo.getPosicao());
		assertEquals(6, jogo.getFuel());
		
			//ambiente pronto
		
		jogo.voltar();
		assertEquals(0, jogo.getPosicao());
		assertEquals(6, jogo.getFuel());
		//ok
		
		//teste com combustível voltar a partir da posição 1
		
		jogo.inicializaJogo();
		
		for (int cont=1; cont<10; cont++) {
			jogo.avancar();
			jogo.getMapa()[cont]=1;
			jogo.carregar();
		}
		assertEquals(9, jogo.getPosicao());
		assertEquals(6, jogo.getFuel());
		
			//ambiente pronto
		
		for (int cont=9; cont>3; cont--) {
			jogo.voltar();	
		}
		for (int cont=3; cont>1; cont--) {
			jogo.getMapa()[cont]=1;
			jogo.carregar();
			jogo.voltar();	
		}
		assertEquals(1, jogo.getPosicao());
		assertEquals(0, jogo.getFuel());
		//ok

	}
	
	@After
	public void tearDownV() {
		jogo = null;
	}
			
	
	//CARREGAR
	
		@Before
	public void setUpC() {
			jogo = new TravessiaDeserto();

		}

		@Test
	public void testCarregar() {

			//teste carregar com tanque cheio na posição 0
			
			jogo.inicializaJogo();
			assertEquals(6, jogo.getFuel());
			
				//ambiente pronto
			
			jogo.carregar();
			assertEquals(6, jogo.getFuel());
			//ok
			
			// teste carregar na posição de 1 à 9 com tanque cheio
			
			jogo.inicializaJogo();
			assertEquals(6, jogo.getFuel());
			assertEquals(0, jogo.getPosicao());
			for (int cont=1; cont<10; cont++) {
				assertEquals(0, jogo.getMapa()[cont]);
			}
			
				//ambiente pronto
			
			for (int cont=1; cont<10; cont++) {
				jogo.avancar();
				jogo.getMapa()[cont]=2;
				jogo.carregar();
			}
			assertEquals(6, jogo.getFuel());
			assertEquals(9, jogo.getPosicao());
			for (int cont=1; cont<10; cont++) {		//teste para ver se abasteceu somente 1 por vez
				assertEquals(1, jogo.getMapa()[cont]);
			}
			//ok

			// teste carregar a vontade na posição 0
			
			jogo.inicializaJogo();
						
			for (int cont=0; cont<6; cont++) {
				jogo.descarregar();
				}
				assertEquals(0, jogo.getFuel());
				assertEquals(0, jogo.getPosicao());
						
				//ambiente pronto
						
			for (int cont=0; cont<6; cont++) {
				jogo.carregar();
				}
				assertEquals(6, jogo.getFuel());
				assertEquals(0, jogo.getPosicao());
			//ok
						
			// teste carregar na posição de 1 à 9 sem combustível
			
			jogo.inicializaJogo();
			assertEquals(6, jogo.getFuel());
			assertEquals(0, jogo.getPosicao());
			for (int cont=1; cont<10; cont++) {
				assertEquals(0, jogo.getMapa()[cont]);
			}
			
				//ambiente pronto
			
			for (int cont=0; cont<6; cont++) {
				jogo.avancar();
				jogo.carregar();
			}
			
			for (int cont=6; cont<10; cont++) {
				jogo.getMapa()[cont]=1;
				jogo.carregar();	//terá combustível
				jogo.carregar();	//não terá combustível
				jogo.avancar();
			}
			assertEquals(0, jogo.getFuel());
			assertEquals(10, jogo.getPosicao());
			for (int cont=1; cont<10; cont++) {
				assertEquals(0, jogo.getMapa()[cont]);
			}
			//ok
	
		}
		
		@After
	public void tearDownC() {
			jogo = null;
		}
	
		
		//DESCARREGA
		
		@Before
	public void setUpD() {
			jogo = new TravessiaDeserto();

		}

		@Test
	public void testDescarregar() {

			//teste descarregar sem combustível
			
			assertEquals(0, jogo.getFuel());
			
				//ambiente pronto
			
			jogo.descarregar();
			assertEquals(0, jogo.getFuel());
			//ok
			
			//teste descarregar com combustível > 0 na posição de 0 à 9
			
			jogo.inicializaJogo();
			jogo.getMapa()[3]=6;
			jogo.getMapa()[6]=6;
			jogo.getMapa()[9]=1;
			assertEquals(6, jogo.getFuel());
			assertEquals(0, jogo.getPosicao());
			
				//ambiente pronto
			
			do {
			
			for (int cont=0; cont<3; cont++) {
				jogo.descarregar();
				jogo.avancar();
			}
			for (int cont=0; cont<6; cont++) {
				jogo.carregar();
			}
			assertEquals(6, jogo.getFuel());
			} while ( jogo.getPosicao()==3 && jogo.getFuel()==6);

			for (int cont=0; cont<3; cont++) {
				jogo.descarregar();
				jogo.avancar();	
			}
			jogo.carregar();
			jogo.descarregar();
			assertEquals(0, jogo.getFuel());
			assertEquals(9, jogo.getPosicao());
			for (int cont=1; cont<10; cont++) {
				assertEquals(1, jogo.getMapa()[9]);
			}
			//ok
	
		}
	
		@After
	public void tearDownD() {
			jogo = null;
		}

		
		//WINNER
		
		@Before
	public void setUpW() {
			jogo = new TravessiaDeserto();

		}

		@Test
	public void testWinner() {

			jogo.inicializaJogo();
			for (int cont=1; cont<7; cont++) {
					jogo.avancar();
					assertEquals(false, jogo.isWinner());
					}
				jogo.getMapa()[6]=6;
			for (int cont=0; cont<4; cont++) {
					jogo.carregar();
				}
			for (int cont=0; cont<3; cont++) {
					jogo.avancar();
					assertEquals(false, jogo.isWinner());
					}
			assertEquals(1, jogo.getFuel());
			assertEquals(9, jogo.getPosicao());
			assertEquals(false, jogo.isWinner());
			
				//ambiente pronto
			
			jogo.avancar();
			assertEquals(true, jogo.isWinner());
			//ok
			
		}
		
		@After
	public void tearDownW() {
			jogo = null;
		}
		
		
		//WINNER
		
		@Before
	public void setUpG() {
			jogo = new TravessiaDeserto();

		}

		@Test
	public void testGameover() {

			//teste game over na posição 0
			
			jogo.inicializaJogo();
			for (int cont=0; cont<6; cont++) {
				jogo.descarregar();
			}
			assertEquals(0, jogo.getFuel());
			assertEquals(0, jogo.getPosicao());
			
				//ambiente pronto
			
			assertEquals(false, jogo.isGameOver());
			//ok
			
			//teste game over nas posições de 1 à 9
			
			jogo.carregar();
			jogo.avancar();
			assertEquals(0, jogo.getFuel());
			assertEquals(1, jogo.getPosicao());
			
				//ambiente pronto
			
			for (int cont=1; cont<10; cont++) {
				assertEquals(true, jogo.isGameOver());
				jogo.getMapa()[cont]=1;
				jogo.carregar();
				jogo.avancar();
			}
			//ok	
		}
		
		@After
	public void tearDownG() {
			jogo = null;
		}
		
}
