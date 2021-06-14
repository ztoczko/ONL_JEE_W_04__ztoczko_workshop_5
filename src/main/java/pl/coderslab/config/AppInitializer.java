package pl.coderslab.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {AppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] {"/"};
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
	    FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter",
	            new CharacterEncodingFilter());
	        fr.setInitParameter("encoding", "UTF-8");
	        fr.setInitParameter("forceEncoding", "true");
	        fr.addMappingForUrlPatterns(null, true, "/*");
	}

}
