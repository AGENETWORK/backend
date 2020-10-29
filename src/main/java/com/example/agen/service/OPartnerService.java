package com.example.agen.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.agen.partner.action.OPartner;
import com.agen.partner.data.OrganisationRequestData;
import com.agen.partner.data.OrganisationResponseData;
import com.agen.utilities.ResponseCodeConstant;

@Service
public class OPartnerService {
    public OrganisationResponseData addOrganisationPartnerToDB(OrganisationRequestData organisationRequestData) {
	OrganisationResponseData response = new OrganisationResponseData();
	response.setResponseCode(ResponseCodeConstant.FAILURE);
	response.setResponseMessage(ResponseCodeConstant.FAILURE_MESSAGE);

	if (new OPartner().isSaveToDB(organisationRequestData)) {
	    response.setResponseCode(ResponseCodeConstant.SUCCESSFUL);
	    response.setResponseMessage(ResponseCodeConstant.SUCCESSFUL_MESSAGE);
	}
	return response;
    }

    public OrganisationResponseData getOrganisation(String id) throws InterruptedException, ExecutionException {
	OPartner organisation = new OPartner();
	OrganisationResponseData organisationResponseData = organisation.getOrganisation(id);
	return organisationResponseData;
    }
}
