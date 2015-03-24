package webapp.model.weather;

import java.util.Date;

//<current temperature="11" skycode="30" skytext="약간 흐림" date="2015-03-13" observationtime="12:00:00" observationpoint="Pusan" feelslike="11" humidity="53" winddisplay="24 km/h W" day="금요일" shortday="금" windspeed="24"/>
public class Current {
	Integer temperature;
	Integer skycode;
	String skytext;
	Date date;
	String observationtime;
	String observationpoint;
	Integer feelslike;
	Integer humidity;
	String winddisplay;
	String day;;
	String shortday;
	String windspeed;
	public Integer getTemperature() {
		return temperature;
	}
	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}
	public Integer getSkycode() {
		return skycode;
	}
	public void setSkycode(Integer skycode) {
		this.skycode = skycode;
	}
	public String getSkytext() {
		return skytext;
	}
	public void setSkytext(String skytext) {
		this.skytext = skytext;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getObservationtime() {
		return observationtime;
	}
	public void setObservationtime(String observationtime) {
		this.observationtime = observationtime;
	}
	public String getObservationpoint() {
		return observationpoint;
	}
	public void setObservationpoint(String observationpoint) {
		this.observationpoint = observationpoint;
	}
	public Integer getFeelslike() {
		return feelslike;
	}
	public void setFeelslike(Integer feelslike) {
		this.feelslike = feelslike;
	}
	public Integer getHumidity() {
		return humidity;
	}
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	public String getWinddisplay() {
		return winddisplay;
	}
	public void setWinddisplay(String winddisplay) {
		this.winddisplay = winddisplay;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getShortday() {
		return shortday;
	}
	public void setShortday(String shortday) {
		this.shortday = shortday;
	}
	public String getWindspeed() {
		return windspeed;
	}
	public void setWindspeed(String windspeed) {
		this.windspeed = windspeed;
	}
	
	
}
