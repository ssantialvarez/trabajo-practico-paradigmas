package edu.unlam.paradigmas.tp.entidades;

import java.util.Comparator;
import java.util.Objects;

public class RegistroHistorico implements Comparable<RegistroHistorico>{
	protected String simbolo;
	protected double cantidad;
	
	
	public RegistroHistorico(String simbolo, double cantidad) {
		this.simbolo = simbolo;
		this.cantidad = cantidad;
	}
	
	public RegistroHistorico(String simbolo, String cantidad) {
		this.simbolo = simbolo;
		this.cantidad = Double.parseDouble(cantidad);
	}
	
	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return  simbolo + ", " + cantidad;
	}
	@Override
	public int hashCode() {
		return Objects.hash(simbolo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroHistorico other = (RegistroHistorico) obj;
		return Objects.equals(simbolo, other.simbolo);
	}
	
	public static class CompararPorSimbolo implements Comparator<RegistroHistorico> {

        @Override
        public int compare(RegistroHistorico reg1, RegistroHistorico reg2) {
            return reg1.simbolo.compareTo(reg2.simbolo);
        }
    }

    public static class CompararCantidad implements Comparator<RegistroHistorico> {

        @Override
        public int compare(RegistroHistorico reg1, RegistroHistorico reg2) {
            return Double.compare(reg1.cantidad, reg2.cantidad);
        }
    }

	public static class CompararCantidadDescendente implements Comparator<RegistroHistorico> {

        @Override
        public int compare(RegistroHistorico reg1, RegistroHistorico reg2) {
            return Double.compare(reg2.cantidad, reg1.cantidad);
        }
    }

	@Override
	public int compareTo(RegistroHistorico o) {
	return this.simbolo.compareTo(o.simbolo);
	}
	
	/*
	@Override
	public int compareTo(RegistroHistorico o) {
	return Double.compare(o.cantidad, cantidad);
	}
	
	@Override
	public int compareTo(RegistroHistorico o) {
	return this.simbolo.compareTo(o.simbolo);
	}
	*/
}
