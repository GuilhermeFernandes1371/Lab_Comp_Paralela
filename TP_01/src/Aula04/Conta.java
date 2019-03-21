package Aula04;

public class Conta implements Runnable {
	 int resultado;
	 int primeiro;
	 int segundo;
	
	Conta (int primeiro, int segundo){
		this.primeiro = primeiro;
		this.segundo = segundo;
	}

	public void run() {
		
		
		if(Thread.currentThread().getName()=="nulo1") {
			soma(primeiro,segundo);
		}
		if(Thread.currentThread().getName()=="nulo2") {
			subtrai(primeiro,segundo);
		}
		if(Thread.currentThread().getName()=="nulo3") {
			multiplicacao(primeiro,segundo);
		}
		if(Thread.currentThread().getName()=="nulo4") {
			divisao(primeiro,segundo);
		}
		
			
	
	
	
		
	}
	public void soma(int primeiro,  int segundo) {
		
		resultado = primeiro + segundo;
		Thread.currentThread().setName("soma ="+ resultado);
		System.out.println("soma ="+ resultado);
		
		
		
		
		
		
	}
	public void subtrai(int primeiro,  int segundo) {
		
		resultado = primeiro - segundo;
		Thread.currentThread().setName("subtracao ="+ resultado);
		System.out.println("subtracao ="+ resultado);
		
		
		
		
	}
	public void multiplicacao(int primeiro,  int segundo) {

		resultado = primeiro * segundo;
		Thread.currentThread().setName("multiplicacao ="+ resultado);
		System.out.println("produto ="+ resultado);
		
		
		
		
		
	}
	public void divisao(int primeiro,  int segundo) {

		resultado = primeiro / segundo;
		Thread.currentThread().setName("divisao ="+ resultado);
		System.out.println("divisao ="+ resultado);
		
		
		
		
		
	}




}
