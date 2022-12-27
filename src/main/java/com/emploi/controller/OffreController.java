package com.emploi.controller;

import com.emploi.model.Offre;
import com.emploi.service.OffreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Offre")
@RequiredArgsConstructor

public class OffreController {
    private final OffreService offreService;

     @GetMapping("/all")
    public ResponseEntity<List<Offre>> getAllOffres(){
        List<Offre> offres = offreService.findAllOffres();
        return new ResponseEntity<>(offres, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Offre> getOffreById(@PathVariable("id") Long id){
        Offre offre = offreService.findOffreById(id);
        return new ResponseEntity<>(offre, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Offre> addOffre(@RequestBody Offre offre){
        Offre saveOffre = offreService.addOffre(offre);
        return new ResponseEntity<>(saveOffre, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Offre> updateOffre(@RequestBody Offre offre){
        Offre updateOffre = offreService.updateOffre(offre);
        return new ResponseEntity<>(updateOffre, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOffre(@PathVariable("id") Long id){
       String delete = offreService.deleteOffre(id);
        return delete;
    }

    @PostMapping("/search/{profil}")
    public Offre searchOffre(@PathVariable("profil") String profil){
            return offreService.findByProfil(profil);
    }



    @PutMapping("/updateStatus")
    public String updateOffreStatus(@RequestBody Offre offre){
        return offreService.updateOffreStatus(offre);
    }
}
