package webapp.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.stereotype.Service;

import webapp.exception.JDOMRuntimeException;
import webapp.exception.URLRuntimeException;
import webapp.model.weather.Current;
import webapp.model.weather.Forecast;
import webapp.model.weather.Weather;

@Service
public class WeatherService {
	
	static Log log = LogFactory.getLog(WeatherService.class);
	String url = "http://weather.service.msn.com/data.aspx?culture=ko-KR&weasearchstr=";
	SAXBuilder jdom = new SAXBuilder();
	
	Current getCurrent(Element current){
		Current c = new Current();
		c.setTemperature(Integer.parseInt(current.getAttributeValue("temperature")));
		c.setSkycode(Integer.parseInt(current.getAttributeValue("skycode")));
		c.setSkytext(current.getAttributeValue("skytext"));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			c.setDate(df.parse(current.getAttributeValue("date")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	List<Forecast> getForecasts(Element weather){
		List<Forecast> list = new ArrayList<Forecast>();
		List<Element> ws = weather.getChildren("forecast");
		
		for(Element e : ws){
			Forecast f = new Forecast();
			f.setLow(Integer.parseInt(e.getAttributeValue("low")));
			f.setHigh(Integer.parseInt(e.getAttributeValue("high")));
			f.setSkycodeday(Integer.parseInt(e.getAttributeValue("skycodeday")));
			f.setSkytextday(e.getAttributeValue("skytextday"));
			f.setDay(e.getAttributeValue("day"));
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				f.setDate(df.parse(e.getAttributeValue("date")));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			list.add(f);
		}
		
		
		return list;
	}
	
	public Weather getWeather(String city) {
		log.info("############################");
		log.info("#getWeather() city="+city+"#");
		log.info("############################");
		
		String urlcity = url+city;
		
		Weather w = null;
		try {
			URL u = new URL(urlcity);
			InputStream in = u.openStream();
			Document doc = jdom.build(in);
			
			Element weatherdata = doc.getRootElement();
			Element weather = weatherdata.getChild("weather");
			Element current = weather.getChild("current");
			
			w = new Weather();
			Current c = getCurrent(current);
			List<Forecast> forecasts = getForecasts(weather);
			
			w.setCurrent(c);
			w.setForecasts(forecasts);
			
			log.info(current.getAttributeValue("skytext"));
			log.info(c.getDate());
			
		} catch (IOException e) {
			throw new URLRuntimeException(urlcity, e);
		} catch (JDOMException e) {
			throw new JDOMRuntimeException("build error", e);
		}
		
		return w;
	}
}
