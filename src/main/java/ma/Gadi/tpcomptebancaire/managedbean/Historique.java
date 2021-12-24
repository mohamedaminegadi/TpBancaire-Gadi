/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.Gadi.tpcomptebancaire.managedbean;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import ma.Gadi.tpcomptebancaire.ejb.GestionnaireCompte;
import ma.Gadi.tpcomptebancaire.entities.CompteBancaire;
import ma.Gadi.tpcomptebancaire.entities.OperationBancaire;

/**
 *
 * @author GADI MOHAMED AMINE
 */
@Named(value = "historique")
@RequestScoped
public class Historique {
    List<OperationBancaire> operation;
    private Long id;
    @EJB
    private GestionnaireCompte gestionnaireCompte;
    public Historique() {}
    public List<OperationBancaire> getOprations(){
        CompteBancaire c = gestionnaireCompte.findById(id);
        if(c!=null){
            operation =c.getOperations();
            return operation;
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
