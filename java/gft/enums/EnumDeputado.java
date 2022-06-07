package gft.enums;

public enum EnumDeputado {
	
	ESTADUAL(1) , FEDERAL(2);
	
	private int valor;
	
	EnumDeputado(int valor){
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	

}
