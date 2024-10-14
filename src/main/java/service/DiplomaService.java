package service;

import dto.DiplomaDTO;
import model.Diploma;
import model.Sexo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DiplomaRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class DiplomaService {

    @Autowired
    private DiplomaRepository diplomaRepository;

    public String gerarTextoDiploma(UUID diplomaId) {
        Optional<Diploma> diplomaOpt = diplomaRepository.findById(diplomaId);
        if (!diplomaOpt.isPresent()) {
            throw new RuntimeException("Diploma não encontrado!");
        }

        Diploma diploma = diplomaOpt.get();
        DiplomaDTO diplomaDTO = mapToDTO(diploma);

        return String.format(
                "O %s, %s da Universidade Fake, no uso de suas atribuições, confere a %s, de nacionalidade %s, " +
                        "natural de %s, portador do rg %s, o presente diploma de %s, do curso de %s, por ter concluído " +
                        "seus estudos nesta instituição de ensino no dia %s.",
                diplomaDTO.getTituloReitor(),
                diplomaDTO.getCargoReitor(),
                diplomaDTO.getNomeDiplomado(),
                diplomaDTO.getNacionalidadeDiplomado(),
                diplomaDTO.getNaturalidadeDiplomado(),
                diplomaDTO.getRgDiplomado(),
                diplomaDTO.getTipoCurso(),
                diplomaDTO.getNomeCurso(),
                diplomaDTO.getDataConclusao()
        );
    }

    private DiplomaDTO mapToDTO(Diploma diploma) {
        DiplomaDTO diplomaDTO = new DiplomaDTO();

        diplomaDTO.setId(diploma.getId());
        diplomaDTO.setNomeDiplomado(diploma.getDiplomado().getNome());
        diplomaDTO.setNacionalidadeDiplomado(diploma.getDiplomado().getNacionalidade());
        diplomaDTO.setNaturalidadeDiplomado(diploma.getDiplomado().getNaturalidade());
        diplomaDTO.setRgDiplomado(diploma.getDiplomado().getRg());
        diplomaDTO.setNomeCurso(diploma.getCurso().getNome());
        diplomaDTO.setTipoCurso(diploma.getCurso().getTipo().name());
        diplomaDTO.setDataConclusao(diploma.getDataConclusao());


        String tituloReitor = (diploma.getSexoReitor() == Sexo.M ? "Prof." : "Dr.") + " " + diploma.getNomeReitor();
        diplomaDTO.setTituloReitor(tituloReitor);
        String tituloReitora = (diploma.getSexoReitor() == Sexo.F ? "Profa." : "Dra.") + " " + diploma.getNomeReitor();
        diplomaDTO.setTituloReitor(tituloReitor);


        String cargoReitor = (diploma.getSexoReitor() == Sexo.M ? "reitor" : "Caro reitor");
        diplomaDTO.setCargoReitor(cargoReitor);
        String cargoReitora = (diploma.getSexoReitor() == Sexo.F ? "reitora" : "Cara reitora");
        diplomaDTO.setCargoReitor(cargoReitor);

        return diplomaDTO;
    }
}

