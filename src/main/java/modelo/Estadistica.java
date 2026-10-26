package modelo;

import java.util.List;

public class Estadistica {

	private int totalJugadas;
	private int victorias;
	private double porcentajeVictorias;
	private int rachaMaxima;
	private String tipoMasJugado;

	public Estadistica (){
	}
	public void calcularMetricas(List<Resultado> historial) {
		// --- Cálculo de totales, victorias y rachas ---
		this.totalJugadas = historial.size();
		this.victorias = 0;
		this.rachaMaxima = 0;
		if (this.totalJugadas == 0) {
			return;
		}

		int rachaActual = 0;
		for (Resultado r : historial) {
			if (r.isVictoria()) {
				this.victorias++;
				rachaActual++;
				if (rachaActual > this.rachaMaxima) {
					this.rachaMaxima = rachaActual;
				}
			} else {
				rachaActual = 0;
			}
		}
		this.porcentajeVictorias = ((double) this.victorias / this.totalJugadas) * 100;

		// ---  Cálculo de la apuesta más jugada --
		java.util.Map<String, Integer> contadorApuestas = new java.util.HashMap<>();
		for (Resultado r : historial) {
			String tipo = r.getTipoApuesta();
			contadorApuestas.put(tipo, contadorApuestas.getOrDefault(tipo, 0) + 1);
		}

		int maxCantidad = 0;
		for (java.util.Map.Entry<String, Integer> entrada : contadorApuestas.entrySet()) {
			if (entrada.getValue() > maxCantidad) {
				maxCantidad = entrada.getValue();
				this.tipoMasJugado = entrada.getKey();
			}
		}
	}
	public int getTotalJugadas() { return totalJugadas; }
	public int getVictorias() { return victorias; }
	public double getPorcentajeVictorias() { return porcentajeVictorias; }
	public int getRachaMaxima() { return rachaMaxima; }
	public String getTipoMasJugado() { return tipoMasJugado; }
}