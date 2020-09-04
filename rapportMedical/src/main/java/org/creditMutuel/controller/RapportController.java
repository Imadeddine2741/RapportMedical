package org.creditMutuel.controller;


import java.util.List;

import javax.validation.Valid;

import org.creditMutuel.exception.ResourceNotFoundException;
import org.creditMutuel.model.dto.RapportDto;
import org.creditMutuel.model.entity.Rapport;
import org.creditMutuel.service.RapportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api")
public class RapportController {


	private final RapportService rapportService;
	
	
	private final static Logger logger =LoggerFactory.getLogger(RapportController.class);
	/**
     * Fonction index : affichage de l'écran de départ
     * @return : le ModelAndView
     */
	
	@RequestMapping(value="/index")
	public ModelAndView index(Model model) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");

		return modelAndView;
	}
	
	/**
	 * Fonction recherche : recherche en fonction du critère renseigner 
	 * @param numRapport : le numéro du rapport 
	 * @param numAssure : le numéro de l'assuré 
	 * @param nomAssure : le nom du rapport 
	 * @return : le ModelAndView
	 */
	
	@SuppressWarnings({ "null", "unused" })
	@RequestMapping(value="/recherche")
	public ModelAndView recherche(Model model, @RequestParam(name ="num", defaultValue = "0") Integer  num, @RequestParam(name ="numAssure", defaultValue = "0") Integer  numAssure,  @RequestParam(name ="nomAssure", defaultValue = "") String  nomAssure) {

		ModelAndView modelAndView = new ModelAndView();
		RapportDto rapport = null;
		List<RapportDto> rapports = null;

		if(num ==0 && num ==0  && nomAssure.isEmpty()) {
			modelAndView.setViewName("index");
		}
		else {
			if(num !=0 ) {
				rapport = rapportService.getByNumRapport(num);
				// Si rapport à été trouvé, on l'ajoute au model
				if(rapport !=null) model.addAttribute("listeRapports", rapport); 
			}if(num !=0  && (rapport!=null && rapport == null)) {
				rapports = rapportService.getByNumAssure(numAssure);
				// Si rapport à été trouvé, on l'ajoute au model
				if(!rapports.isEmpty()) model.addAttribute("listeRapports", rapports); 	
			}if(!nomAssure.isEmpty() && (rapport!=null && rapports.isEmpty())) {
				rapports = rapportService.getByNomAssure("%"+nomAssure+"%");	
				// Si rapport à été trouvé, on l'ajoute au model
				if(!rapports.isEmpty()) model.addAttribute("listeRapports", rapports); 
			}
			modelAndView.setViewName("rechercheRapportMedical");
		}
		return modelAndView;
	}

	/**
     * Fonction getAllRaports : récuperer la liste de tout les rapports
     * @return : ResponseEntity
     */
	
	@GetMapping("/rapports")
	public ResponseEntity<List<RapportDto>> getAllRaports(){
		List<RapportDto> ListRapports = rapportService.getAll();

		return ResponseEntity.ok().body(ListRapports);
	}
	
	/**
	 * Fonction createrapport : permet de créer un rapport
	 * @param rapport : l'id de rapport
	 * @return RapportDTO
	 */
	
	@PostMapping("/rapport")
	public RapportDto createrapport(@Valid @RequestBody RapportDto rapport) {
		return rapportService.addRapport(rapport);
	}
	
	/**
	 * Fonction updateRapport : permet de update un rapport
	 * @param rapportId : L'id du rapport
	 * @param rapportDetails : rapport a update
	 * @return
	 * @throws ResourceNotFoundException
	 */

	@PutMapping("/rapport/{num}")
	public ResponseEntity<RapportDto> updateRapport(@PathVariable(value = "id") int num_rapport,
			@Valid @RequestBody Rapport rapportDetails) throws ResourceNotFoundException {
		RapportDto rapport = rapportService.getByNumRapport(num_rapport);
		if(rapport ==null) {
			throw new ResourceNotFoundException("Rapport not found for this id :: " + num_rapport);
		}

		rapport.setDateCreation(rapportDetails.getDateCreation());
		rapport.setDomaine(rapportDetails.getDomaine());
		rapport.setPosition(rapportDetails.getPosition());
		rapport.setTitre(rapportDetails.getTitre());
		rapport.setNum(rapportDetails.getNum());
		rapport.setAssure(rapportDetails.getAssure());
		rapport.setCommentaires(rapportDetails.getCommentaires());

		final RapportDto updatedRapport = rapportService.addRapport(rapport);
		return ResponseEntity.ok(updatedRapport);
	}


}
