package com.agen.partner.data;

import java.util.List;

import com.agen.utilities.BaseResponseData;

public class OrganisationResponseData extends BaseResponseData {
    public OrganisationResponseData() {

    }

    public OrganisationResponseData(String responseCode, String responseMessage) {
	super(responseCode, responseMessage);
    }

    private List<OrganisationRequestData> organisation = null;

    public List<OrganisationRequestData> getOrganisation() {
	return organisation;
    }

    public void setOrganisations(List<OrganisationRequestData> organisations) {
	this.organisation = organisations;
    }
}
