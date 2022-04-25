package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Livre;
import com.example.demo.repos.LivreRepo;

@Service
public class LivreService {
	@Autowired
	LivreRepo livreRepository;
	public List<Livre> findbytitle() {
		return livreRepository.findByOrderByTitreAsc();
		}
	public Livre getLivre(long id) {
		Livre livre= livreRepository.findById(id).get();
		livre.setDate_consultation(new Date());
		livreRepository.save(livre);
		return livre;
	}
	public void deleteLivre(long id) {

		 livreRepository.deleteById(id);
		}
	public void modifier(long id, Livre l) {
		Livre livre = livreRepository.findById(id).get();
		livre.setAuteur(l.getAuteur());
		livre.setDate_consultation(new Date());
		livre.setDate_sortie(l.getDate_sortie());
		livre.setDisponible(l.getDisponible());
		livre.setIsbn(l.getIsbn());
		livre.setMaison_edition(l.getMaison_edition());
		livre.setNbr_page(l.getNbr_page());
		livre.setTitre(l.getTitre());
		livreRepository.save(livre);
		}
	public Livre create(Livre livre) {

		return livreRepository.save(livre);

		 }
}
