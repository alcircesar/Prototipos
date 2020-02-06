package br.com.prototipos.tasks.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
	        .antMatchers("/login", "/webjars/**", "/error").permitAll()
			.anyRequest().authenticated()
			.and()
		    .formLogin().loginPage("/login").failureUrl("/login?error").defaultSuccessUrl("/", true).permitAll()
			.and()
			.logout()
				.permitAll();
		// Permite realizar o logout
        http.csrf().disable();


	}
/*
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("prototipo")
				.password("Prototipo")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
	*/
	
	@Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser("tarefa").password(passwordEncoder().encode("Tarefa")).roles("USER")
          .and()
          .withUser("admin").password(passwordEncoder().encode("ProtoAdm")).roles("ADMIN");
    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}