package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Person;

@WebFilter("/address.jsp")
public class PersonFilter implements Filter
{
	
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
    	HttpServletRequest httpRequest = (HttpServletRequest) request; 
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		
		Person person = (Person) session.getAttribute("person");
		String firstName = httpRequest.getParameter("firstName");
		String surname = httpRequest.getParameter("surname");
		String pesel = httpRequest.getParameter("pesel");
		
		if( person == null )
		{
		    httpResponse.sendRedirect("/");
		}
		else if( firstName == null || surname == null || pesel == null )
		{
			httpResponse.sendRedirect("/");
		}
		else if( firstName.equals("") || surname.equals("") || pesel.equals("") )
		{
			httpResponse.sendRedirect("/");
		}
		
		chain.doFilter(request, response);
	}
    
	public void destroy() 
	{
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException
	{
		
	}

}
