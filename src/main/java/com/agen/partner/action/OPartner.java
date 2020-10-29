package com.agen.partner.action;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.agen.partner.data.OrganisationRequestData;
import com.agen.partner.data.OrganisationResponseData;
import com.agen.utilities.ResponseCodeConstant;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

public class OPartner {
    public static final String COL_NAME = "organisationPartner";

    public boolean isSaveToDB(OrganisationRequestData organisationRequestData) {
	boolean response = false;

	if (organisationRequestData.getEmail() == null || organisationRequestData.getName() == null
		|| organisationRequestData.getPhoneNumber() == null
		|| organisationRequestData.getRepresentativeEmail() == null
		|| organisationRequestData.getRepresentativeName() == null
		|| organisationRequestData.getDetails() == null) {
	    response = false;
	} else {
	    String ID = organisationRequestData.getPartnerID();

	    Firestore dbFirestore = FirestoreClient.getFirestore();
	    ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(ID)
		    .set(organisationRequestData);
	    response = true;
	}
	return response;
    }

    public OrganisationResponseData getOrganisation(String id) throws InterruptedException, ExecutionException {
	Firestore dbFirestore = FirestoreClient.getFirestore();
	DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(id);
	ApiFuture<DocumentSnapshot> future = documentReference.get();
	DocumentSnapshot document = future.get();
	OrganisationResponseData response = new OrganisationResponseData();
	response.setResponseCode(ResponseCodeConstant.FAILURE);
	response.setResponseMessage(ResponseCodeConstant.FAILURE_MESSAGE);
	List<OrganisationRequestData> organisationLst = new ArrayList<OrganisationRequestData>();
	if (document.exists()) {
	    OrganisationRequestData organisationRequestData = new OrganisationRequestData();
	    organisationRequestData.setDetails(document.getString("details"));
	    organisationRequestData.setEmail("email");
	    organisationRequestData.setName("name");
	    organisationRequestData.setPartnerID("partnerID");
	    organisationRequestData.setPhoneNumber("phoneNumber");
	    organisationRequestData.setRepresentativeEmail("representativeEmail");
	    organisationRequestData.setRepresentativeName("representativeName");
	    organisationLst.add(organisationRequestData);

	    response.setResponseCode(ResponseCodeConstant.SUCCESSFUL);
	    response.setResponseMessage(ResponseCodeConstant.SUCCESSFUL_MESSAGE);
	}
	response.setOrganisations(organisationLst);
	return response;

    }
}
