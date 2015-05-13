package Bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Eduardo
 */
@Entity
@Table(name = "dentista", catalog = "dbconsultorio", schema = "")
@NamedQueries({
    @NamedQuery(name = "Dentista.findAll", query = "SELECT d FROM Dentista d"),
    @NamedQuery(name = "Dentista.findByIdDentista", query = "SELECT d FROM Dentista d WHERE d.idDentista = :idDentista"),
    @NamedQuery(name = "Dentista.findByEspecialidade", query = "SELECT d FROM Dentista d WHERE d.especialidade = :especialidade"),
    @NamedQuery(name = "Dentista.findByNmDentista", query = "SELECT d FROM Dentista d WHERE d.nmDentista = :nmDentista"),
    @NamedQuery(name = "Dentista.findByTelDentista", query = "SELECT d FROM Dentista d WHERE d.telDentista = :telDentista")})
public class Dentista implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_dentista")
    private Integer idDentista;
    @Column(name = "especialidade")
    private String especialidade;
    @Column(name = "nm_dentista")
    private String nmDentista;
    @Column(name = "tel_dentista")
    private String telDentista;

    public Dentista() {
    }

    public Dentista(Integer idDentista) {
        this.idDentista = idDentista;
    }

    public Integer getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(Integer idDentista) {
        Integer oldIdDentista = this.idDentista;
        this.idDentista = idDentista;
        changeSupport.firePropertyChange("idDentista", oldIdDentista, idDentista);
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        String oldEspecialidade = this.especialidade;
        this.especialidade = especialidade;
        changeSupport.firePropertyChange("especialidade", oldEspecialidade, especialidade);
    }

    public String getNmDentista() {
        return nmDentista;
    }

    public void setNmDentista(String nmDentista) {
        String oldNmDentista = this.nmDentista;
        this.nmDentista = nmDentista;
        changeSupport.firePropertyChange("nmDentista", oldNmDentista, nmDentista);
    }

    public String getTelDentista() {
        return telDentista;
    }

    public void setTelDentista(String telDentista) {
        String oldTelDentista = this.telDentista;
        this.telDentista = telDentista;
        changeSupport.firePropertyChange("telDentista", oldTelDentista, telDentista);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDentista != null ? idDentista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dentista)) {
            return false;
        }
        Dentista other = (Dentista) object;
        if ((this.idDentista == null && other.idDentista != null) || (this.idDentista != null && !this.idDentista.equals(other.idDentista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nmDentista;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
