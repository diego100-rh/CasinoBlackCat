package modelo;

import java.util.List;

public class Estadistica {

	private int totalJugadas;
	private int victorias;
	private double porcentajeVictorias;
	private int rachaMaxima;
	private TipoApuesta tipoMasJugado;

	public Estadistica (){
	}
	public void calcularMetricas(List<Resultado> historial) {
		this.totalJugadas = historial.size();
		this.victorias = 0;
		this.rachaMaxima = 0;

		if (this.totalJugadas == 0) {
			return; // Si no hay jugadas, terminamos aquí
		}
		int rachaActual = 0;

		for (Resultado r : historial) {
			if (r.isVictoria()) {
				this.victorias++;
				rachaActual++; // La racha viva aumenta

				// Si la racha actual supera el récord, actualizamos el récord
				if (rachaActual > this.rachaMaxima) {
					this.rachaMaxima = rachaActual;
				}
			} else {
				// Perdió: la racha viva se corta y vuelve a cero
				rachaActual = 0;
			}
			java.util.Map<TipoApuesta, Integer> contadorApuestas = new java.util.HashMap<>();

			// 2. Recorremos el historial y vamos sumando +1 a cada tipo
			for (Resultado i : historial) {
				TipoApuesta tipo = i.getTipoApuesta();
				// getOrDefault busca si ya tiene un número; si no, empieza en 0, y siempre le suma 1
				contadorApuestas.put(tipo, contadorApuestas.getOrDefault(tipo, 0) + 1);
			}

			// 3. Revisamos la libreta para ver cuál tiene el número más alto
			int maxCantidad = 0;
			for (java.util.Map.Entry<TipoApuesta, Integer> entrada : contadorApuestas.entrySet()) {
				if (entrada.getValue() > maxCantidad) {
					maxCantidad = entrada.getValue();
					this.tipoMasJugado = entrada.getKey(); // Coronamos al nuevo ganador
				}
		}
		// Calculamos el porcentaje
		this.porcentajeVictorias = ((double) this.victorias / this.totalJugadas) * 100;

		//  adelante agregaremos la lógica para rachaMaxima y tipoMasJugado
	}
}
	public int getTotalJugadas() { return totalJugadas; }
	public int getVictorias() { return victorias; }
	public double getPorcentajeVictorias() { return porcentajeVictorias; }
	public int getRachaMaxima() { return rachaMaxima; }
	public TipoApuesta getTipoMasJugado() { return tipoMasJugado; }
}