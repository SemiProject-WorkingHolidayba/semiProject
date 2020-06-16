package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class CommonFilter
 */
// filterName을 통해서 어떤 역할을 하는 필터인지 이름을 정해주고
// urlPatterns를 통해서 어떠한 서블릿을 가기 전에 이 필터를 거칠 것인지 지정해 준다.
@WebFilter(filterName = "encoding", urlPatterns = "/*")
public class CommonFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CommonFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 1. 뷰에서 전달 받은 값에 한글이 있는 경우
		request.setCharacterEncoding("UTF-8");
		
		// 2. 뷰로 전달할 값에 한글이 있는 경우
		response.setContentType("text/html;charset=utf-8");
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
