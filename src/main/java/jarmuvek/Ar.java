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

@Entity
@NamedQueries
({
   @NamedQuery(name = "Ar.osszesAr", query = "SELECT a FROM Ar a"),
   @NamedQuery(name = "Ar.getArByBuszAndEvjarat", query = "SELECT a FROM Ar a WHERE a.jarmu =:jarmu AND a.me =:me"),
   @NamedQuery(name = "Ar.getArByBuszIdAndEvjaratId", query = "SELECT a FROM Ar a WHERE a.jarmu.id =:buszid AND a.me.id =:meid")
})
public class Ar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;
    private Gepjarmuvek jarmu;
    private Evjarat me;
    private long ar;

    public Gepjarmuvek getJarmu()
    {
        return jarmu;
    }

    public void setJarmu(Gepjarmuvek jarmu)
    {
        this.jarmu = jarmu;
    }

    public Evjarat getMe()
    {
        return me;
    }

    public void setMe(Evjarat me)
    {
        this.me = me;
    }

    public long getAr()
    {
        return ar;
    }

    public void setAr(long ar)
    {
        this.ar = ar;
    }   
    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ar))
        {
            return false;
        }
        Ar other = (Ar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "jarmuvek.Ar[ id=" + id + " ]";
    }
    
}
