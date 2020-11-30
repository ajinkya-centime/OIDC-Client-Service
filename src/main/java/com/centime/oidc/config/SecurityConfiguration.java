package com.centime.oidc.config;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
public class SecurityConfiguration { // extends WebSecurityConfigurerAdapter {

  // @Override
  // public void configure(HttpSecurity http) throws Exception {
  // http.authorizeRequests().anyRequest().authenticated();
  // // http.authorizeRequests().anyRequest().authenticated().and().oauth2Login();
  // }

  // @Override
  // protected void configure(HttpSecurity http) throws Exception {
  // http.oauth2Login().and().csrf()
  // .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
  // .authorizeRequests().antMatchers("/**/*.{js,html,css}").permitAll()
  // // .antMatchers("/", "/1.0/user/login").permitAll().anyRequest().authenticated()
  // .antMatchers("/", "/1.0/private").permitAll().anyRequest().authenticated();
  // }

  // The RequestCache bean overrides the default request cache. It saves the referrer header
  // so Spring Security can redirect back to it after authentication. The referrer-based request
  // cache
  // comes in handy when you’re developing React on http://localhost:3000 and want to be redirected
  // back
  // there after logging in.
  //
  // @Bean
  // public RequestCache refererRequestCache() {
  // return new HttpSessionRequestCache() {
  // @Override
  // public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
  // String referrer = request.getHeader("referer");
  // if (referrer != null) {
  // request.getSession().setAttribute("SPRING_SECURITY_SAVED_REQUEST",
  // new SimpleSavedRequest(referrer));
  // }
  // }
  // };
  // }
}
