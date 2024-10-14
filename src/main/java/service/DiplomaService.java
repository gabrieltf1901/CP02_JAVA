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

    // Método para buscar o diploma e gerar o texto
    public String gerarTextoDiploma(UUID diplomaId) {
        Optional<Diploma> diplomaOpt = diplomaRepository.findById(diplomaId);
        if (!diplomaOpt.isPresent()) {
            throw new RuntimeException("Diploma não encontrado!");
        }

        Diploma diploma = diplomaOpt.get();
        DiplomaDTO diplomaDTO = mapToDTO(diploma);

        // Geração do texto
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

    // Método auxiliar para mapear um Diploma para o DTO
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

        // Gerar o título do reitor com base no sexo
        String tituloReitor = (diploma.getSexoReitor() == Sexo.M ? "Prof. Dr." : "Profa. Dra.") + " " + diploma.getNomeReitor();
        diplomaDTO.setTituloReitor(tituloReitor);

        // Definir o cargo do reitor com base no sexo
        String cargoReitor = (diploma.getSexoReitor() == Sexo.M ? "reitor" : "reitora");
        diplomaDTO.setCargoReitor(cargoReitor);

        return diplomaDTO;
    }
}

