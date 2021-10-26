package com.counter;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@Controller
public class CounterJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterJavaApplication.class, args);
		
	}
	
	// Getters
	
	/*private Integer getSessionCount( HttpSession session ) {
		Object counter = session.getAttribute( "count" );

		if( counter == null ) {
			setSessionCounter(session, 0);
			counter = session.getAttribute("count");
		}
		return (Integer)counter;
	}*/
	
	//Setters
	
	private void setSessionCounter(HttpSession session, int val) {
		session.setAttribute("count", val);
	}
	
	// Routes
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public String homePage(HttpSession session, Model model ) {
		Object counter = session.getAttribute( "count" );
		if( counter == null ) {
			setSessionCounter(session, -1);
			counter = session.getAttribute("count");
		}
		/*else {
			counter = session.getAttribute("count");
			setSessionCounter(session, ++counter);
		}*/
		
		int counter1 = (int) session.getAttribute("count");
		setSessionCounter(session, ++counter1);
		
		model.addAttribute( "count", counter1 );
		System.out.println(counter1);
		return "index.jsp";
	}
	
	@RequestMapping( value = "/counter", method = RequestMethod.GET )
	public String counterPage(HttpSession session, Model model) {
		int counter1 = (int) session.getAttribute("count");
		model.addAttribute( "count", counter1 );
		return "countertemplate.jsp";
	}
	
	@RequestMapping("/reset")
	public String Reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
