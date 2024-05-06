package ejercicio4;

public class AreaEmpresa {
	private String identificacion;
	private int ping;
	
	public AreaEmpresa(String identificacion, int ping) {
		this.identificacion = identificacion;
		this.ping = ping;
	}
	
	public String getIdentificacion() {
		return identificacion;
	}
	
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	
	public int getPing() {
		return ping;
	}
	
	public void setPing(int ping) {
		this.ping = ping;
	}
	
}
