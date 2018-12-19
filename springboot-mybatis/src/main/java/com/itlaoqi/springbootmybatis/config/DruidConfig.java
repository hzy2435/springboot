package com.itlaoqi.springbootmybatis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {

	@Bean
	@ConfigurationProperties(prefix = "druid.datasource")
	public DataSource druid() {

		DruidDataSource druid = new DruidDataSource();
		return druid;

	}

	@Bean
	public ServletRegistrationBean<StatViewServlet> statViewServlet() {

		ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),
				"/druid/*");
		Map<String, String> params = new HashMap<>();
		params.put("loginUsername", "admin");
		params.put("loginPassword", "123456");
		params.put("allow", "");
		// params.put("deny", "127.9.29.0");
		bean.setInitParameters(params);
		
		return bean;
	}
	
	@Bean
	public FilterRegistrationBean<WebStatFilter> webStatFilter() {
		
		FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>();
		bean.setFilter(new WebStatFilter());
		bean.addUrlPatterns("/*");
		Map<String, String> params = new HashMap<>();
		params.put("exclusions", "*.js,*.css,*.png,*.woff,/druid/*");
		bean.setInitParameters(params);
		
		return bean;
		
	}

}
