package examen;

public class Pokemon implements Comparable<Pokemon>{
	private String nombre;
	private Tipo tipo;
	private int fuerza;
	private Entrenador entrenador;

	public Pokemon() {
	}

	public Pokemon(String nombre, Tipo tipo, int fuerza, Entrenador entrenador) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.fuerza = fuerza;
		this.entrenador = entrenador;
	}

	public Pokemon(String nombre, Tipo tipo, int fuerza) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.fuerza = fuerza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	@Override
	public int compareTo(Pokemon o) {
		return this.getNombre().compareTo(o.getNombre());
	}

	public void mostrarInfoPokemon() {
		System.out.println("Nombre: "+nombre+"\nTipo: "+tipo+"\nFuerza: "+fuerza);
		
	}

}
