package training;

abstract class Animal{
	public  void come() {}
}

class Perro extends Animal{
	
	static int a =1;
	public void ladra() {}

	@Override
	public void come() {
		int a;
		// TODO Auto-generated method stub
		
	}
}

class Gato extends Animal{
	public void maulla() {}
	
	public static void m() {
		int n =0;
	}

	@Override
	public void come() {
		// TODO Auto-generated method stub
		
	}
}


public class EjemploCasting {
	
	
	public static void main(String[] args) {
		Animal perro = new Perro();
		Animal gato =  new Gato();
		
		
		perro.come();
		((Perro) perro).ladra();
		
		gato.come();
		((Gato) gato).maulla();
		
		//((Perro)perro).maulla();
		//Perro perro = new Perro();
		//Gato gato = new Gato();
		
		perro.come();
		((Animal)perro).come();
		
		gato.come();
		((Animal)gato).come();
		
		//perro.ladra();
		((Perro) perro).ladra();
		
		//gato.maulla();
		((Gato) gato).maulla();
		
		//perro.maulla()
		
		
	}
}
