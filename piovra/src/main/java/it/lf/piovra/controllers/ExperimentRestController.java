package it.lf.piovra.controllers;

import it.lf.piovra.facades.FactorFacade;
import it.lf.piovra.views.FactorData;
import it.lf.piovra.views.forms.AddFactorForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.validation.Valid;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/my-account/experiment")
public class ExperimentRestController
{

	@Resource
	private FactorFacade factorFacade;

	@PostMapping(value = "/add-factor", produces = "application/json")
	public FactorData addFactor(@Valid AddFactorForm addFactorForm) {
		return factorFacade.addFactor(addFactorForm.getExperimentId(), addFactorForm.getName());
	}

}
