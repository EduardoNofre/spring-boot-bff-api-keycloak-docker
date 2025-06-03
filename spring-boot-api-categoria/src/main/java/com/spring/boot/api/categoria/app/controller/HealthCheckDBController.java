package com.spring.boot.api.categoria.app.controller;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

@RequestMapping("/health-check-bd")
@Hidden
public class HealthCheckDBController {

	 private static final String TIME = "time";

	    @Autowired
	    private BuildProperties properties;

	    @Autowired
	    private HealthCheckApiController db;

	    @GetMapping("health-check")
	    public ResponseEntity<Map<String, Object>> healthCheck(){
	        Map<String, Object> map = new ConcurrentHashMap<>();
	        this.properties.forEach(p -> {
	            if (TIME.equalsIgnoreCase(p.getKey())) {
	                LocalDateTime time = null;
	                if (Objects.nonNull(this.properties.getTime())) {
	                    time = LocalDateTime.ofInstant(this.properties.getTime(), ZoneId.systemDefault());
	                }
	                map.put(p.getKey(), time);
	            } else {
	                map.put(p.getKey(), p.getValue());
	            }
	        });
	        map.put("Database conection DB2:", db.healthCheck());

	        return ResponseEntity.ok(map);
	    }
}
