package com.example.agen.service;

import org.springframework.stereotype.Service;

import com.agen.partner.action.IPartner;
import com.agen.partner.data.IndividualRequestData;
import com.agen.partner.data.IndividualResponseData;
import com.agen.utilities.ResponseCodeConstant;

@Service
public class IPartnerService {
    public IndividualResponseData addIndividualPartnerToDB(IndividualRequestData individualRequestData) {
	IndividualResponseData response = new IndividualResponseData();
	response.setResponseCode(ResponseCodeConstant.FAILURE);
	response.setResponseMessage(ResponseCodeConstant.FAILURE_MESSAGE);

	if (new IPartner().isSaveToDB(individualRequestData)) {
	    response.setResponseCode(ResponseCodeConstant.SUCCESSFUL);
	    response.setResponseMessage(ResponseCodeConstant.SUCCESSFUL_MESSAGE);
	}
	return response;
    }
}
