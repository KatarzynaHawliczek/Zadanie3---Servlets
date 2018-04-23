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

import domain.Address;

@WebFilter("/success.jsp")
public class AddressFilter implements Filter 
{
	
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
    	HttpServletRequest httpRequest = (HttpServletRequest) request; 
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		
		Address address = (Address) session.getAttribute("address");
		String city = httpRequest.getParameter("city");
		String zipCode = httpRequest.getParameter("zipCode");
		String street = httpRequest.getParameter("street");
		String houseNumber = httpRequest.getParameter("houseNumber");
		String localNumber = httpRequest.getParameter("localNumber");
		String phoneNumber = httpRequest.getParameter("phoneNumber");

		if( address == null )
		{
			httpResponse.sendRedirect("/");
		}
		else if( city == null || zipCode == null || street == null || houseNumber == null || localNumber == null || phoneNumber == null )
		{
		    httpResponse.sendRedirect("/");
		}
		else if( city.equals("") || zipCode.equals("") || street.equals("") || houseNumber.equals("") || localNumber.equals("") || phoneNumber.equals("") )
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
