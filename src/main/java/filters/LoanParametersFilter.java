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

import domain.LoanParameters;

@WebFilter("/person.jsp")
public class LoanParametersFilter implements Filter 
{
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest httpRequest = (HttpServletRequest) request; 
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		
		LoanParameters parameters = (LoanParameters) session.getAttribute("parameters");
		String amount = "" + httpRequest.getParameter("amount");
		String installmentCount = "" + httpRequest.getParameter("installmentCount");

		if( parameters == null )
		{
		    httpResponse.sendRedirect("/");
		    
		}
		else if( amount == null || installmentCount == null )
		{
			httpResponse.sendRedirect("/");
			
		}
		else if( amount.equals("") || installmentCount.equals("") )
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