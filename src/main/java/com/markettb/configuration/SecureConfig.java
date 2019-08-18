package com.markettb.configuration;

import com.markettb.service.UserDetailServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class SecureConfig extends WebSecurityConfigurerAdapter {
    private UserDetailServicesImpl userDetailServices;

    @Autowired
    public void setUserDetailServices(UserDetailServicesImpl userDetailServices){
        this.userDetailServices = userDetailServices;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailServices).passwordEncoder(getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                /*Authorized for Bill Controller */
                .antMatchers("/orderdetail/bill/{order_id:\\d+}/delete/{id:\\d+}").hasAnyRole("ADMIN","USER")
                /*Authorized for OrderBill Controller*/
                .antMatchers("/start").hasAnyRole("ADMIN","USER")
                .antMatchers("/postorder").hasAnyRole("ADMIN","USER")
                .antMatchers("/orderdetail/{id:\\d+}").hasAnyRole("ADMIN","USER")
                .antMatchers("/postorderdetail").hasAnyRole("ADMIN","USER")
                .antMatchers("/deleteorder/{id:\\d+}").hasAnyRole("ADMIN","USER")
                .antMatchers("/printorderdetail/{id:\\d+}").hasAnyRole("ADMIN","USER")
                /*Authorize for Product Controller*/
                .antMatchers("/product").hasAnyRole("ADMIN","USER")
                .antMatchers("/postproduct").hasAnyRole("ADMIN","USER")
                .antMatchers("/editproduct/{id:\\d+}").hasAnyRole("ADMIN","USER")
                .antMatchers("/updateproduct").hasAnyRole("ADMIN","USER")
                .antMatchers("/deleteproduct/{id:\\d+}").hasAnyRole("ADMIN","USER")
                /*Authorized for Statistic Controller*/
                .antMatchers("/statistic").hasAnyRole("ADMIN","USER")
                .antMatchers("/statisticsale").hasAnyRole("ADMIN","USER")
                .antMatchers("/statisticproduct").hasAnyRole("ADMIN","USER")
                .antMatchers("/poststatisticproduct").hasAnyRole("ADMIN","USER")
                /*Authorized for Teams Controller*/
                .antMatchers("/teams").hasAnyRole("ADMIN")
                .antMatchers("/team").hasAnyRole("ADMIN")
                .antMatchers("/checkteam").hasAnyRole("ADMIN")
                .antMatchers("/editteam/{id:\\d+}").hasAnyRole("ADMIN")
                .antMatchers("/updateteam").hasAnyRole("ADMIN")
                .antMatchers("/deleteteam/{id:\\d+}").hasAnyRole("ADMIN")
                .antMatchers("/listactiveteam").hasAnyRole("ADMIN")
                .anyRequest().permitAll()
                .and().formLogin().permitAll();
    }

    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            @Override
            public String encode(CharSequence charSequence) {
                return bCryptPasswordEncoder.encode(charSequence);
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return bCryptPasswordEncoder.matches(charSequence,s);
            }
        };
    }
}
