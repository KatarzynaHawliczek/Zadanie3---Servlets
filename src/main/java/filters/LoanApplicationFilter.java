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

import domain.LoanApplication;

@WebFilter("/success.jsp")
public class LoanApplicationFilter implements Filter 
{

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
    {
    	HttpServletRequest httpRequest = (HttpServletRequest) request; 
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		
		LoanApplication loan = (LoanApplication) session.getAttribute("loan");
		
		if( loan == null )
		{
		    httpResponse.sendRedirect("/");
		}
		else if( loan.getNumber() == null || loan.getDate() == null )
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
