package examen;

public class Criador extends Persona {
	private int experiencia;

	public Criador() {

	}

	public Criador(String nombre, int edad, int experiencia) {
		super(nombre, edad);
		this.experiencia = experiencia;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	@Override
	public void mostrarInfoPersona() {
		super.mostrarInfoPersona();
		System.out.println("Experiencia: "+ experiencia);
		
	}

	public Pokemon criarPokemon(String nombre, Tipo tipo, int fuerza, Entrenador entrenador) {

		Pokemon pokemon = new Pokemon(nombre, tipo, fuerza, entrenador);

		return pokemon;
	}

}
