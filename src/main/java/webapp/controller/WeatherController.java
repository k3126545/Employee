package webapp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import webapp.model.weather.Weather;
import webapp.service.WeatherService;

@Controller
@RequestMapping("/weather")
public class WeatherController {
	
	static Log log = LogFactory.getLog(WeatherController.class);
	//String weatherurl = "http://weather.service.msn.com/data.aspx?culture=ko-KR&weasearchstr=%EC%84%9C%EC%9A%B8";
	
	@Autowired
	WeatherService service;
	
	@RequestMapping(value={"", "/"}, method=RequestMethod.GET)
	public String showForm() {
		log.info("################");
		log.info("###showForm()###");
		log.info("################");
		
		return "weather/form";
	}
	
	@RequestMapping(value="/show", method=RequestMethod.POST)
	public String showWeather(Model model, String city) throws IOException, JDOMException {
		log.info("###################");
		log.info("###showWeather()###");
		log.info("###################");
		
		Weather weather = service.getWeather(city);
		model.addAttribute("weather", weather);
		model.addAttribute("city", city);
		
//		URL url = new URL(weatherurl);
//		InputStream in = url.openStream();
//		SAXBuilder jdom = new SAXBuilder();
//		Document document = jdom.build(in);
//		
//		Element weatherdata = document.getRootElement();
//		Element weather = weatherdata.getChild("weather");
//		List<Element> list = weather.getChildren();
//		
//		List<String> date = new ArrayList<String>();
//		List<String> high = new ArrayList<String>();
//		List<String> low = new ArrayList<String>();
//		List<String> skytextday = new ArrayList<String>();
//		
//		for(Element e : list){
//			if("forecast".equals(e.getName())){
//					log.info(e.getAttributeValue("date")+" 의 날씨 !!!!!!!!!");
//					log.info("최고기온 : "+e.getAttributeValue("high"));
//					log.info("최저기온 : "+e.getAttributeValue("low"));
//					log.info("skytextday : "+e.getAttributeValue("skytextday"));
//					
//					date.add(e.getAttributeValue("date"));
//					high.add(e.getAttributeValue("high"));
//					low.add(e.getAttributeValue("low"));
//					skytextday.add(e.getAttributeValue("skytextday"));
//			}
//		}
//		model.addAttribute("date", date);
//		model.addAttribute("high", high);
//		model.addAttribute("low", low);
//		model.addAttribute("skytextday", skytextday);
		
		return "weather/weather";
	}
	
}
