package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.DiplomaService;

import java.util.UUID;

@RestController
public class DiplomaController {

    @Autowired
    private DiplomaService diplomaService;

    @GetMapping("/diploma/{id}")
    public String getDiplomaTexto(@PathVariable UUID id) {
        return diplomaService.gerarTextoDiploma(id);
    }
}

