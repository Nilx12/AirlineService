package searchers;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import validation.CheckTimeFormat;


public class FligthSearcher {
	
	@NotNull(message="necesary")
	private String originAirport;
	
	@NotNull(message="necesary")
	private String desitinyAirport;
	
	@CheckTimeFormat
	private String time;
	
	public String getOriginAirport() {
		return originAirport;
	}

	public void setOriginAirport(String originAirport) {
		this.originAirport = originAirport;
	}

	public String getDesitinyAirport() {
		return desitinyAirport;
	}

	public void setDesitinyAirport(String desitinyAirport) {
		this.desitinyAirport = desitinyAirport;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public LocalTime convertTime(){
		return LocalTime.parse(time);
	}
	
	public FligthSearcher() {
		
	}
	
	
	
}
