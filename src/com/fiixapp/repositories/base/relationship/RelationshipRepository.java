package com.fiixapp.repositories.base.relationship;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.fiixapp.data.RelationshipDatabase;
import com.fiixapp.models.RelationshipModel;
import com.fiixapp.repositories.base.BaseRelationshipRepository;

/**
 * @author Timor
 *
 */
@Repository
public class RelationshipRepository extends BaseRelationshipRepository {

	private RelationshipDatabase relationshipDatabase;
	private List<RelationshipModel> listOfRelationship = new ArrayList<>();

	public RelationshipRepository() {
		this.relationshipDatabase = new RelationshipDatabase();
		if (listOfRelationship.isEmpty()) {
			listOfRelationship = this.relationshipDatabase.generateRelationships();
		}
	}

	/* (non-Javadoc)
	 * @see com.fiixapp.repositories.base.IRepository#getAll()
	 * This method used to get all the currently existing relationships
	 */
	@Override
	public List<RelationshipModel> getAll() {
		return this.listOfRelationship;
	}

	/* (non-Javadoc)
	 * @see com.fiixapp.repositories.base.IRepository#findById(java.lang.Object)
	 * This method used to find a relationship by ID(long)
	 * return relation if exist and NULL if not.
	 */
	@Override
	public RelationshipModel findById(Long id) {
		for(RelationshipModel relModel : listOfRelationship) {
			if(relModel.getId() == id) {
				return relModel;
			}
		}
		return null;
	}

}
