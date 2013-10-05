import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class TravessiaDesertoTest {

	TravessiaDeserto jogo;
	
	//avancar - seguir a diante e ver se roda o code, luz verde

	@Before
	public void setUpA() {
		jogo = new TravessiaDeserto();

	}

	@ Test
	public void testAvancar() {

		jogo.inicializaJogo();

		int pos = jogo.getPosicao();
		int fuel = jogo.getFuel();

		if (jogo.getFuel()<1) {  				// NAO PODE AVANÇAR
			jogo.avancar();
			assertEquals(pos, jogo.getPosicao());
			assertEquals(fuel, jogo.getFuel());
		}
		else if (jogo.getFuel()>0 && jogo.getPosicao()>9) {			// NAO PODE AVANÇAR
			jogo.avancar();
			assertEquals(pos, jogo.getPosicao());
			assertEquals(fuel, jogo.getFuel());
		}
		else if (jogo.getFuel()>0 && jogo.getPosicao()<10){						// DEVE AVANÇAR
			jogo.avancar();
			assertEquals(pos + 1, jogo.getPosicao());
			assertEquals(fuel - 1, jogo.getFuel());
		}

	}
	
	
	@After
	public void tearDownA() {
		jogo = null;
	}

	
	
	//metodo voltar - teste
	
	@Before
	public void setUpV() {
		jogo = new TravessiaDeserto();

	}

	@Test
	public void testVoltar() {

		jogo.inicializaJogo();

		int pos = jogo.getPosicao();
		int fuel = jogo.getFuel();
		
		jogo.avancar();  // habilitar para terceiro teste
		jogo.avancar();	 // habilitar para terceiro teste
		
		
		if (jogo.getFuel()==0) {  				// ele nao pode voltar regra estabelecida
		jogo.voltar();
			assertEquals(pos, jogo.getPosicao());
		}
		else if (jogo.getFuel()>0 && jogo.getPosicao()==0) {			// ele nao pode voltar regra estabelecida
			jogo.voltar();
			assertEquals(pos, jogo.getPosicao());
			assertEquals(fuel, jogo.getFuel());
		}
		else if (jogo.getFuel()>0 && jogo.getPosicao()>0) {			// ele nao pode voltar regra estabelecida
			jogo.voltar();
			assertEquals(pos+1, jogo.getPosicao());
			assertEquals(fuel-3, jogo.getFuel());
		}

	}
	
	@After
	public void tearDownV() {
		jogo = null;
	}
	
	//metodo carregar fazer o teste 
	
		@Before
		public void setUpC() {
			jogo = new TravessiaDeserto();

		}

		@Test
		public void testCarregar() {

			jogo.inicializaJogo();
		
			int fuel=jogo.getFuel();
			int pos = jogo.getPosicao();
			int [] estoque = jogo.getMapa();
	
			jogo.avancar();  // habilitar para terceiro teste
		
			if (jogo.getFuel()>5) {			
				jogo.carregar();
				assertEquals(fuel, jogo.getFuel());
				System.out.println("1");
			}
			
			else if (jogo.getFuel()<6 && jogo.getPosicao()==0) {		
				jogo.carregar();
				assertEquals(6, jogo.getFuel());
				System.out.println("3");
			}
			else if (jogo.getFuel()<6 && jogo.getPosicao()>0) {
				
	//	me perdi code indicado pelo colega não sei o que fazer deixar ate achar a indicação	jogo.getMapa()[1]=1;		
				
				for (int i=1; i<10; i++) {			// tem um erro foi falado em aula nao resolvi ainda, mas ja sei o que é incremento
				
					if (jogo.getMapa()[i]==0) {
					jogo.carregar();
					assertEquals(fuel-1, jogo.getFuel());
					System.out.println("nao"+i);
					}
					else if (jogo.getMapa()[i]>0) {
						jogo.carregar();
						assertEquals(6, jogo.getFuel());
						assertEquals(0, jogo.getMapa()[i]);
						System.out.println("carregou no "+i);
						System.out.println("mapa vale: "+jogo.getMapa()[i]);
						System.out.println("fuel vale: "+jogo.getFuel());
					}
				}
			}
		}
		
		@After
		public void tearDownC() {
			jogo = null;
		}
	
	
		//metodo de descarregar
		
		@Before
		public void setUpD() {
			jogo = new TravessiaDeserto();

		}

		@Test
		public void testDESCARREGA() {

			jogo.inicializaJogo();
			
			int fuel=jogo.getFuel();
			int pos = jogo.getPosicao();
			
			jogo.avancar();		
			System.out.println("fuel "+jogo.getFuel());
			System.out.println("posicao "+jogo.getPosicao());
			
			if (jogo.getFuel()<1 && jogo.getPosicao()==0) {			
				jogo.descarregar();
				assertEquals(0, jogo.getFuel());
			}
			else if (jogo.getPosicao()==0) {		
				jogo.descarregar();
				assertEquals(6, jogo.getFuel());
			}
			else if (jogo.getPosicao()>0 && jogo.getPosicao()<10) {   
				
				for (int i=1; i<10; i++) {
				jogo.descarregar();
				assertEquals(fuel-3, jogo.getFuel());
				assertEquals(1, jogo.getMapa()[jogo.getPosicao()]);
				}
			}
			else {			
				jogo.descarregar();
				assertEquals(fuel, jogo.getFuel());
			}
			
			}
	
		@After
		public void tearDownD() {
			jogo = null; // conferir antes de mandar, duvidas mas jogo tem testes realizados 
		}

}

