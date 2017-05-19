/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jarmuvek;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Administrator
 */
@Entity
@NamedQueries
({
    @NamedQuery(name = "Evjarat.getOsszesEvjarat", query = "SELECT m FROM Evjarat m"),
    @NamedQuery(name = "Evjarat.getEvjaratById", query = "SELECT m FROM Evjarat m WHERE m.id =:id")
})
public class Evjarat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer evjarat;
    private String idoszak;
    private String szarmazas;

    public Integer getEvjarat() {
        return evjarat;
    }

    public void setEvjarat(Integer evjarat) {
        this.evjarat = evjarat;
    }

    public String getIdoszak() {
        return idoszak;
    }

    public void setIdoszak(String idoszak) {
        this.idoszak = idoszak;
    }

    public String getSzarmazas() {
        return szarmazas;
    }

    public void setSzarmazas(String szarmazas) {
        this.szarmazas = szarmazas;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evjarat)) {
            return false;
        }
        Evjarat other = (Evjarat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jarmuvek.Evjarat[ id=" + id + " ]";
    }
    
}
