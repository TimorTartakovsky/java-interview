package com.fiixapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fiixapp.models.RelationshipModel;
import com.fiixapp.service.relationship.RelationshipService;

@RestController
public class RelationshipController {

	
	@Autowired
	private RelationshipService relationshipService;
	
	@RequestMapping(value="/relationFindByUser/{userId}", method = RequestMethod.GET)
	public String getAllRelationships(@PathVariable("userId") long userId) {
		
		List<RelationshipModel> relList = relationshipService.getAllRelationships();
		StringBuffer sb = new StringBuffer("");
		for(RelationshipModel rel : relList) {
			sb.append(rel.getRelationshipDetails()).append("\n");
		}
		return sb.toString();
	}
}
