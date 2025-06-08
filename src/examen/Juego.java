package examen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Juego {

	static ArrayList<Entrenador> entrenadores = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		crearEntrenadores();
		Criador c = crearCriador();

		preguntandoPokemons(c);

		Pokemon[] pokemons = rellenarArray();

		Arrays.sort(pokemons); // en la clase Pokemon se debe implementar Comparable<Pokemon>
		System.out.println("Pokemons que van a pelear: ");
		for (int i = 0; i < pokemons.length; i++) {
			System.out.println(pokemons[i].getNombre());
		}
		System.out.println();
		combatePokemon(pokemons);

		System.out.println("Informacion de los Entrenadores");
		for (Entrenador entrenador : entrenadores) {
			entrenador.mostrarInfoPersona();
		}

	}

	private static void combatePokemon(Pokemon[] pokemons) {
		int ronda = 1;

		for (int i = 0; i < pokemons.length - 1; i++) {
			for (int j = i + 1; j < pokemons.length; j++) {
				System.out
						.println("Ronda " + ronda + ": " + pokemons[i].getNombre() + " vs. " + pokemons[j].getNombre());

				pelea(pokemons[i], pokemons[j]);
				ronda++;
			}
		}

	}

	private static void pelea(Pokemon pokemon1, Pokemon pokemon2) {
		Pokemon ganador = pokemon2;

		if (pokemon1.getTipo().equals(Tipo.AGUA) && pokemon2.getTipo().equals(Tipo.FUEGO)) {
			ganador = pokemon1;
		} else if (pokemon1.getTipo().equals(Tipo.FUEGO) && pokemon2.getTipo().equals(Tipo.PLANTA)) {
			ganador = pokemon1;
		} else if (pokemon1.getTipo().equals(Tipo.PLANTA) && pokemon2.getTipo().equals(Tipo.AGUA)) {
			ganador = pokemon1;
		} else if (pokemon1.getTipo().equals(pokemon2.getTipo())) {
			if (pokemon1.getFuerza() > pokemon2.getFuerza()) {
				ganador = pokemon1;
			}
		}

		System.out.println("Pokemon ganador :" + ganador.getNombre());
		System.out.println("Puntos de fuerza: " + ganador.getFuerza() + " + 10");
		ganador.setFuerza(ganador.getFuerza() + 10);
		ganador.getEntrenador().setnCombates(ganador.getEntrenador().getnCombates() + 1);

	}

	private static Pokemon[] rellenarArray() {

		int contadorPokemons = 0;
		for (Entrenador entrenador : entrenadores) {
			for (Pokemon pokemon : entrenador.getPokemons()) {
				contadorPokemons++;
			}
		}

		Pokemon[] pokemons = new Pokemon[contadorPokemons];
		int falseFor = 0;
		for (Entrenador entrenador : entrenadores) {
			for (Pokemon pokemon : entrenador.getPokemons()) {
				pokemons[falseFor] = pokemon;

				falseFor++;
			}
		}

		return pokemons;
	}

	private static void preguntandoPokemons(Criador c) {
		Scanner sc = new Scanner(System.in);
		int num;
		do {
			System.out.println("Cuantos pokemons tendra cada entrenador(1/6)?");
			num = sc.nextInt();
			if (num < 1 || num > 6) {
				System.out.println("De 1 a 6");
			}
		} while (num < 1 || num > 6);

		System.out.println("Criador cria a los pokemons para los Entrenadores");
		for (Entrenador entrenador : entrenadores) {
			System.out.println("creando pokemons para Entrenador " + entrenador.nombre);
			entrenador.setPokemons(crearPokemons(num, entrenador, c));
		}
	}

	private static ArrayList<Pokemon> crearPokemons(int num, Entrenador entrenador, Criador criador) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Pokemon> pok = new ArrayList<>();

		for (int i = 0; i < num; i++) {
			System.out.println("Pokemon " + (i + 1));
			System.out.println("Nombre: ");
			String name = sc.nextLine();

			String type;
			do {
				System.out.println("Tipo:(Agua, Fuego, Planta)");
				type = sc.nextLine().toUpperCase();

				if (!type.equals("AGUA") && type.equals("FUEGO") && type.equals("PLANTA")) {
					System.out.println("Tipo no encontrado ");

				}
			} while (!type.equals("AGUA") && !type.equals("FUEGO") && !type.equals("PLANTA"));

			Tipo tipo = Tipo.valueOf(type);
			System.out.println("Fuerza:");
			int fuerza = sc.nextInt();
			sc.nextLine();
			Pokemon a = criador.criarPokemon(name, tipo, fuerza, entrenador);
			System.out.println("Pokemon registrado");
			pok.add(a);

		}
		return pok;
	}

	private static Criador crearCriador() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Crear criador:\nNombre:");
		String name = sc.nextLine();

		System.out.println("Edad");
		int age = sc.nextInt();
		System.out.println("Experiencia");
		int exp = sc.nextInt();

		Criador cr = new Criador(name, age, exp);

		return cr;
	}

	private static void crearEntrenadores() {
		Scanner sc = new Scanner(System.in);
		int num;
		do {
			System.out.println("Cuantos entrenadores hay?(deben ser pares)");
			num = sc.nextInt();
			sc.nextLine();
			if (num % 2 != 0) {
				System.out.println("DEBEN SER PARES DIJE");
			} else if (num < 0) {
				System.out.println("Mayor a 0 obviamente");
			} else if (num == 0) {
				System.out.println("no puede ser tampoco 0");
			}
		} while (num % 2 != 0 || num < 0 || num == 0);

		for (int i = 0; i < num; i++) {
			System.out.println("Creando entrenador " + (i + 1));
			System.out.println("Nombre: ");

			String name = sc.nextLine();

			System.out.println("Edad:");
			int age = sc.nextInt();
			sc.nextLine();

			System.out.println("Combates ganados:");
			int fights = sc.nextInt();
			sc.nextLine();

			Entrenador a = new Entrenador(name, age, fights);
			entrenadores.add(a);
		}

	}
}
