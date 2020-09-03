package org.rapportMedical;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.creditMutuel.RapportMedical;
import org.creditMutuel.model.entity.Assure;
import org.creditMutuel.model.entity.Commentaire;
import org.creditMutuel.model.entity.Rapport;
import org.creditMutuel.model.enumeration.Domaine;
import org.creditMutuel.model.enumeration.Position;
import org.creditMutuel.model.mapper.RapportMapper;
import org.creditMutuel.repository.AssureeRepository;
import org.creditMutuel.repository.RapportRepository;
import org.creditMutuel.service.AssureService;
import org.creditMutuel.service.RapportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RapportMedical.class)
public class RapportControllerIntegrationTest {


	@Autowired
	private AssureService assureService;
	
	@Autowired
	private RapportMapper rapportMapper;
	
	@Autowired
	private RapportService rapportService;
	
	@MockBean
	private AssureeRepository repository;
	
	@MockBean
	private RapportRepository rapportrepository;
	
//	
	@Test
	public void findAllTest() {
		when(repository.findAll()).thenReturn(Stream.of(new Assure(1,"Dupont","Albert", "1966-02-15","Rue Victor Hugo - 6900 - Lyon"), new Assure(2,"Dupont", "Fréderic", "1970-05-12", "Rue des Fleurs - 6900 - Lyon"))
													.collect(Collectors.toList()));
		assertEquals(2, assureService.getAll().size());
	}
	
	
	@Test
	public void findByNumRapportTest() {
		Integer numRapport =1;
		Rapport rapport = new Rapport(new Assure(1,"Dupont","Albert", "1966-02-15","Rue Victor Hugo - 6900 - Lyon"),1, "Rapport DupFre1", "2019-08-15" ,Domaine.Sinistre, Position.En_attente, 
				Arrays.asList(new Commentaire("24/08/2020", "22/08/2020", "balabla"),new Commentaire("24/08/2020", "22/08/2020", "balabla")));
		when(rapportrepository.findByNumRapport(numRapport)).thenReturn(rapport);
		
		assertEquals(rapportMapper.entityToDto(rapport),rapportService.getByNumRapport(numRapport));
	}
	
	@Test
	public void findByNumAssureTest() {
		int numAssure = 1 ;
		when(rapportrepository.findByNumAssure(1)).thenReturn(Stream.of(new Rapport(new Assure(1,"Dupont","Albert", "1966-02-15","Rue Victor Hugo - 6900 - Lyon"),2, "Rapport DupFre1", "2019-08-15" ,Domaine.Sinistre, Position.En_attente, 
																	Arrays.asList(new Commentaire("24/08/2020", "22/08/2020", "balabla"),new Commentaire("24/08/2020", "22/08/2020", "balabla")))).collect(Collectors.toList()));
		
		assertEquals(2,rapportService.getByNumAssure(numAssure).get(0).getNumRapport().intValue());
	}
	
	@Test
	public void findByNomAssureTest() {
		String nomAssure="Dupont";
		when(rapportrepository.findByNomAssure(nomAssure)).thenReturn(Stream.of(new Rapport(new Assure(1,"Dupont","Albert", "1966-02-15","Rue Victor Hugo - 6900 - Lyon"),2, "Rapport DupFre1", "2019-08-15" ,Domaine.Sinistre, Position.En_attente, 
																	Arrays.asList(new Commentaire("24/08/2020", "22/08/2020", "balabla"),new Commentaire("24/08/2020", "22/08/2020", "balabla")))).collect(Collectors.toList()));
		
		assertEquals(2,rapportService.getByNomAssure(nomAssure).get(0).getNumRapport().intValue());
	}
	
	@Test
	public void deleteRapportTest() {
		Rapport rapport =  new Rapport(new Assure(1,"Dupont","Albert", "1966-02-15","Rue Victor Hugo - 6900 - Lyon"),2, "Rapport DupFre1", "2019-08-15" ,Domaine.Sinistre, Position.En_attente, 
				Arrays.asList(new Commentaire("24/08/2020", "22/08/2020", "balabla")));
		rapportService.deleteRapport(rapport);
		verify(rapportrepository,times(1)).delete(rapport);
	}
	
	
	
}
