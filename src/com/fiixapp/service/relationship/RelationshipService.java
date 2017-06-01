package com.fiixapp.service.relationship;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fiixapp.models.RelationshipModel;
import com.fiixapp.repositories.base.relationship.RelationshipRepository;

@Service("RelationshipService")
public class RelationshipService {
	
	@Autowired
	private RelationshipRepository relationshipRepository;
	
	public List<RelationshipModel> getAllRelationships() {
		return relationshipRepository.getAll();
	}
	
}
