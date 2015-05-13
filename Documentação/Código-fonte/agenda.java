package Bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Eduardo
 */
@Entity
@Table(name = "agenda", catalog = "dbconsultorio", schema = "")
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a"),
    @NamedQuery(name = "Agenda.findByIdConsulta", query = "SELECT a FROM Agenda a WHERE a.idConsulta = :idConsulta"),
    @NamedQuery(name = "Agenda.findByConfirma", query = "SELECT a FROM Agenda a WHERE a.confirma = :confirma"),
    @NamedQuery(name = "Agenda.findByDataConsulta", query = "SELECT a FROM Agenda a WHERE a.dataConsulta = :dataConsulta"),
    @NamedQuery(name = "Agenda.findByEspecialidade", query = "SELECT a FROM Agenda a WHERE a.especialidade = :especialidade"),
    @NamedQuery(name = "Agenda.findByHora", query = "SELECT a FROM Agenda a WHERE a.hora = :hora"),
    @NamedQuery(name = "Agenda.findByNmDentista", query = "SELECT a FROM Agenda a WHERE a.nmDentista = :nmDentista"),
    @NamedQuery(name = "Agenda.findByNmPaciente", query = "SELECT a FROM Agenda a WHERE a.nmPaciente = :nmPaciente"),
    @NamedQuery(name = "Agenda.findByDentistaiddentista", query = "SELECT a FROM Agenda a WHERE a.dentistaiddentista = :dentistaiddentista"),
    @NamedQuery(name = "Agenda.findByPacienteidpaciente", query = "SELECT a FROM Agenda a WHERE a.pacienteidpaciente = :pacienteidpaciente")})
public class Agenda implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_consulta")
    private Integer idConsulta;
    @Column(name = "confirma")
    private Boolean confirma;
    @Column(name = "data_consulta")
    @Temporal(TemporalType.DATE)
    private Date dataConsulta;
    @Column(name = "especialidade")
    private String especialidade;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "nm_dentista")
    private String nmDentista;
    @Column(name = "nm_paciente")
    private String nmPaciente;
    @ManyToOne
    @JoinColumn(name = "Dentista_id_dentista")
    private Dentista dentistaiddentista;
    @ManyToOne
    @JoinColumn(name = "Paciente_id_paciente")
    private Paciente pacienteidpaciente;

    public Agenda() {
    }

    public Agenda(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        Integer oldIdConsulta = this.idConsulta;
        this.idConsulta = idConsulta;
        changeSupport.firePropertyChange("idConsulta", oldIdConsulta, idConsulta);
    }

    public Boolean getConfirma() {
        return confirma;
    }

    public void setConfirma(Boolean confirma) {
        Boolean oldConfirma = this.confirma;
        this.confirma = confirma;
        changeSupport.firePropertyChange("confirma", oldConfirma, confirma);
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        Date oldDataConsulta = this.dataConsulta;
        this.dataConsulta = dataConsulta;
        changeSupport.firePropertyChange("dataConsulta", oldDataConsulta, dataConsulta);
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        String oldEspecialidade = this.especialidade;
        this.especialidade = especialidade;
        changeSupport.firePropertyChange("especialidade", oldEspecialidade, especialidade);
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        Date oldHora = this.hora;
        this.hora = hora;
        changeSupport.firePropertyChange("hora", oldHora, hora);
    }

    public String getNmDentista() {
        return nmDentista;
    }

    public void setNmDentista(String nmDentista) {
        String oldNmDentista = this.nmDentista;
        this.nmDentista = nmDentista;
        changeSupport.firePropertyChange("nmDentista", oldNmDentista, nmDentista);
    }

    public String getNmPaciente() {
        return nmPaciente;
    }

    public void setNmPaciente(String nmPaciente) {
        String oldNmPaciente = this.nmPaciente;
        this.nmPaciente = nmPaciente;
        changeSupport.firePropertyChange("nmPaciente", oldNmPaciente, nmPaciente);
    }

    public Dentista getDentistaiddentista() {
        return dentistaiddentista;
    }

    public void setDentistaiddentista(Dentista dentistaiddentista) {
        Dentista oldDentistaiddentista = this.dentistaiddentista;
        this.dentistaiddentista = dentistaiddentista;
        changeSupport.firePropertyChange("dentistaiddentista", oldDentistaiddentista, dentistaiddentista);
    }

    public Paciente getPacienteidpaciente() {
        return pacienteidpaciente;
    }

    public void setPacienteidpaciente(Paciente pacienteidpaciente) {
        Paciente oldPacienteidpaciente = this.pacienteidpaciente;
        this.pacienteidpaciente = pacienteidpaciente;
        changeSupport.firePropertyChange("pacienteidpaciente", oldPacienteidpaciente, pacienteidpaciente);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsulta != null ? idConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.idConsulta == null && other.idConsulta != null) || (this.idConsulta != null && !this.idConsulta.equals(other.idConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bean.Agenda[ idConsulta=" + idConsulta + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
