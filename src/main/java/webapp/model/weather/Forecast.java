package webapp.model.weather;

import java.util.Date;

//<forecast low="4" high="12" skycodeday="39" skytextday="소나기 후 맑음" date="2015-03-13" day="금요일" shortday="금" precip="65"/>
public class Forecast {
	Integer low;
	Integer high;
	Integer skycodeday;
	String skytextday;
	Date date;
	String day;
	String shortday;
	Integer precip;
	
	public Integer getLow() {
		return low;
	}
	public void setLow(Integer low) {
		this.low = low;
	}
	public Integer getHigh() {
		return high;
	}
	public void setHigh(Integer high) {
		this.high = high;
	}
	public Integer getSkycodeday() {
		return skycodeday;
	}
	public void setSkycodeday(Integer skycodeday) {
		this.skycodeday = skycodeday;
	}
	public String getSkytextday() {
		return skytextday;
	}
	public void setSkytextday(String skytextday) {
		this.skytextday = skytextday;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public Integer getPrecip() {
		return precip;
	}
	public void setPrecip(Integer precip) {
		this.precip = precip;
	}
	
}
