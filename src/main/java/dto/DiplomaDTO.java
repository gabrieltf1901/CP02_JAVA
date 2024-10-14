package dto;

import java.time.LocalDate;
import java.util.UUID;

public class DiplomaDTO {

    private UUID id;
    private String nomeDiplomado;
    private String nacionalidadeDiplomado;
    private String naturalidadeDiplomado;
    private String rgDiplomado;
    private String nomeCurso;
    private String tipoCurso;
    private LocalDate dataConclusao;
    private String tituloReitor;
    private String cargoReitor;

    // Getters e Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeDiplomado() {
        return nomeDiplomado;
    }

    public void setNomeDiplomado(String nomeDiplomado) {
        this.nomeDiplomado = nomeDiplomado;
    }

    public String getNacionalidadeDiplomado() {
        return nacionalidadeDiplomado;
    }

    public void setNacionalidadeDiplomado(String nacionalidadeDiplomado) {
        this.nacionalidadeDiplomado = nacionalidadeDiplomado;
    }

    public String getNaturalidadeDiplomado() {
        return naturalidadeDiplomado;
    }

    public void setNaturalidadeDiplomado(String naturalidadeDiplomado) {
        this.naturalidadeDiplomado = naturalidadeDiplomado;
    }

    public String getRgDiplomado() {
        return rgDiplomado;
    }

    public void setRgDiplomado(String rgDiplomado) {
        this.rgDiplomado = rgDiplomado;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getTituloReitor() {
        return tituloReitor;
    }

    public void setTituloReitor(String tituloReitor) {
        this.tituloReitor = tituloReitor;
    }

    public String getCargoReitor() {
        return cargoReitor;
    }

    public void setCargoReitor(String cargoReitor) {
        this.cargoReitor = cargoReitor;
    }
}

