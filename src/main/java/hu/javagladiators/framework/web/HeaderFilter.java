/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.framework.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author krisztian
 */
@WebFilter(filterName = "UTFFilter", urlPatterns = {"/*"})
public class HeaderFilter implements Filter {

    //Logger log = LoggerFactory.getLogger(HeaderFilter.class.getSimpleName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        //log.info("FILTER:" + HeaderFilter.class.getName());
//        ((HttpServletResponse) response).setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");			
	((HttpServletResponse) response).setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia, Authorization");        
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
