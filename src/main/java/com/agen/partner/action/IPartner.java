package com.agen.partner.action;

import com.agen.partner.data.IndividualRequestData;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

public class IPartner {
    public static final String COL_NAME = "individualPartner";

    public boolean isSaveToDB(IndividualRequestData individualRequestData) {
	boolean response = false;

	if (individualRequestData.getEmail() == null || individualRequestData.getName() == null
		|| individualRequestData.getPhoneNumber() == null) {
	    response = false;
	} else {
	    String ID = individualRequestData.getPartnerID();

	    Firestore dbFirestore = FirestoreClient.getFirestore();
	    ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(ID)
		    .set(individualRequestData);
	    response = true;
	}
	return response;
    }
}
