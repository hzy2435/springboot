package com.itlaoqi.springbootmybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.itlaoqi.springbootmybatis.mapper")
public class SpringBootMybatis {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatis.class, args);
	}
	
}
