package examen;

import java.util.ArrayList;

public class Entrenador extends Persona {
	private int nCombates;
	private ArrayList<Pokemon> pokemons = new ArrayList<>();

	public Entrenador() {
	}

	public Entrenador(String nombre, int edad, int nCombates, ArrayList<Pokemon> pokemons) {
		super(nombre, edad);
		this.nCombates = nCombates;
		this.pokemons = pokemons;
	}

	public Entrenador(String nombre, int edad, int nCombates) {
		super(nombre, edad);
		this.nCombates = nCombates;
	}

	public int getnCombates() {
		return nCombates;
	}

	public void setnCombates(int nCombates) {
		this.nCombates = nCombates;
	}

	public ArrayList<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(ArrayList<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	@Override
	public void mostrarInfoPersona() {
		super.mostrarInfoPersona();
		System.out.println("\nCombates Ganados: "+nCombates+"\nPokemons de este entrenador: ");
		if (!pokemons.isEmpty()) {
			for (Pokemon pokemon : pokemons) {
				pokemon.mostrarInfoPokemon();
			}
		}
		

	}

}
