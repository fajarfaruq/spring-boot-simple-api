package id.my.fajarfaruq.simpleapi.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/** SecurityConfiguration Class. This class using for custom configure security of spring boot API
 *
 * @author Fajar Faruq
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * configure method. This method using for configure HttpSecurity when API hit payload 
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Allow sending body payload without csrf security, if enable every sent payload must be sent csrf token too
        http.csrf().disable();
    }
}
