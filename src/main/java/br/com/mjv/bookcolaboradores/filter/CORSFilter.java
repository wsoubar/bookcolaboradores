package br.com.mjv.bookcolaboradores.filter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CORSFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		

		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true" );
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT" );
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "auth_token" );
		
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Map<String, String> map = new HashMap<String, String>();
        
    	Enumeration headerNames = httpRequest.getHeaderNames();
    	while (headerNames.hasMoreElements()) {
    		String key = (String) headerNames.nextElement();
    		String value = httpRequest.getHeader(key);
    		map.put(key, value);
    		//System.out.println("key: "+key+ " | value: "+value);
    	}
             
        
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
