package it.polito.tdp.corsi.model;

import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.*;

public class Model {
	//la classe model richiama il dao che può avere l'interaione con ilDB
	
	private corsoDAO dao;
	
	public Model() {
		dao = new corsoDAO();
	}
	
	public List<Corso> getCorsiByPeriodo(Integer pd){
		return dao.getCorsiByPeriodo(pd);
	}
	

	public Map<Corso,Integer> getIscrittiByPeriodo(Integer pd){
		return dao.getIscrittiByPeriodo(pd);
	}
	
	public List<Studente> getStudentiByCorso(Corso c){
		return dao.getStudentiByCorso(c);
	}
	
	public boolean esisteCorso(String codins) {
		return dao.esisteCorso(codins);
	}
	
	public Map<String, Integer> getDivisioneCDS(Corso c){
		//SOLUZIONE 1
		/*List<Studente> studenti = dao.getStudentiByCorso(c);
		 * 
		 * utile la hashmap per controllare se la chiave esiste già o meno
		
		Map<String, Integer> statistiche = new HashMap<String, Integer>();
		
		for(Studente s : studenti) {
			
			if(s.getCDS() != null && !s.getCDS().equals("")) {
				if(statistiche.containsKey(s.getCDS())) {
					statistiche.put(s.getCDS(),statistiche.get(s.getCDS()) +1);
				} else {
					statistiche.put(s.getCDS(), 1);
				}		
			}
		}
		
		return statistiche;*/
		return dao.getDivisioneCDS(c);
	}
}