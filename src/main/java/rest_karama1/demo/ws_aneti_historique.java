package rest_karama1.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "ws_aneti_historique")
public class ws_aneti_historique {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "agent")
    private Long agent;
    @Column(name = "type_contrat")
    private String type_contrat;
    @Column(name = "import_local")
    private LocalDate import_local;
    @Column(name = "date_import")
    private String date_import;
    @Column(name = "creation_dossier")
    private  Long creation_dossier;
    @Column(name = "boo_creation_dossier")
    private  Long boo_creation_dossier;

    public ws_aneti_historique() {
    }

    public Long getBoo_creation_dossier() {
        return boo_creation_dossier;
    }

    public void setBoo_creation_dossier(Long boo_creation_dossier) {
        this.boo_creation_dossier = boo_creation_dossier;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getAgent() {
        return agent;
    }

    public void setAgent(Long agent) {
        this.agent = agent;
    }

    public String getType_contrat() {
        return type_contrat;
    }

    public void setType_contrat(String type_contrat) {
        this.type_contrat = type_contrat;
    }

    public LocalDate getImport_local() {
        return import_local;
    }

    public void setImport_local(LocalDate import_local) {
        this.import_local = import_local;
    }

    public String getDate_import() {
        return date_import;
    }

    public void setDate_import(String date_import) {
        this.date_import = date_import;
    }

    public Long getCreation_dossier() {
        return creation_dossier;
    }

    public void setCreation_dossier(Long creation_dossier) {
        this.creation_dossier = creation_dossier;
    }
}
