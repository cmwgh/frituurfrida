package be.vdab.entities;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
public class OpenGesloten {
	@Override
	public String toString(){
		DayOfWeek dag = LocalDateTime.now().getDayOfWeek();
		return dag == DayOfWeek.MONDAY || dag == DayOfWeek.THURSDAY ? "gesloten" :
			"open";
	}
}
