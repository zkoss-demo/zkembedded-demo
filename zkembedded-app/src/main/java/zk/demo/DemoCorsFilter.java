package zk.demo;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Only for demo purposes - not for production use !
 */
public class DemoCorsFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) servletResponse;
		res.addHeader("Access-Control-Allow-Origin", "http://localhost:9000");
		res.addHeader("Access-Control-Allow-Headers", "zk-sid");
		res.addHeader("Access-Control-Expose-Headers", "zk-sid, zk-error");
		res.addHeader("Access-Control-Allow-Credentials", "true");
		res.addHeader("Access-Control-Allow-Methods", "GET, POST");
		filterChain.doFilter(servletRequest, servletResponse);
	}
}
