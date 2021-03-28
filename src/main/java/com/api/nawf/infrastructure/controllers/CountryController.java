package com.api.nawf.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nawf.application.usecases.SearchCountry;
import com.api.nawf.domain.entities.CountryEntity;
import com.api.nawf.infrastructure.exceptions.ApiException;

@RestController
@RequestMapping("/v1/country")
public class CountryController {

	@Autowired
	private SearchCountry searchCountry;

	@GetMapping("/{ip:^\\d{1,3}+\\Q.\\E\\d{1,3}+\\Q.\\E\\d{1,3}+\\Q.\\E\\d{1,3}$}")
	public ResponseEntity<CountryEntity> getCountry(@PathVariable String ip) throws ApiException {
		return new ResponseEntity<>(this.searchCountry.searchByIp(ip), HttpStatus.OK);
	}
}
