package complete.login.activate.email.loginAndCreate;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoginAndCreateApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginAndCreateApplication.class, args);
	}

	String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
	String pwd = RandomStringUtils.random( 15, characters );
//        System.out.println(pwd);
//

//	@Bean
//	public ServletWebServerFactory servletContainer() {
//		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {@Override
//		protected void postProcessContext(Context context) {
//			SecurityConstraint securityConstraint = new SecurityConstraint();
//			securityConstraint.setUserConstraint("CONFIDENTIAL");
//			SecurityCollection collection = new SecurityCollection();
//			collection.addPattern("/*");
//			securityConstraint.addCollection(collection);
//			context.addConstraint(securityConstraint);
//		}
//		};
//		tomcat.addAdditionalTomcatConnectors(redirectConnector());
//		return tomcat;
//	}
//
//	private Connector redirectConnector() {
//		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//		connector.setScheme("http");
//		connector.setPort(8080);
//		connector.setSecure(false);
//		connector.setRedirectPort(8443);
//		return connector;
//	}
}
