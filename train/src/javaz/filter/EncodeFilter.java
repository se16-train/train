package javaz.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class EncodeFilter implements Filter {
	
	private String inEncode;
	private String outEncode;
	
	public void destroy() {
		this.inEncode = null;
		this.outEncode = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		//设置编码格式
		request.setCharacterEncoding(inEncode);
		response.setContentType(outEncode);
        chain.doFilter(request, response);  
	}

	public void init(FilterConfig FilterConfig) throws ServletException {
		String encode = FilterConfig.getInitParameter("inEncode");
		if(this.inEncode == null){
			this.inEncode = encode;
		}
		String outFormat = FilterConfig.getInitParameter("outEncode");
		if(this.outEncode == null){
			this.outEncode = outFormat;
		}
	}

}
