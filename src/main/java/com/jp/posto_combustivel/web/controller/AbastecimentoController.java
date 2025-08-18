package com.jp.posto_combustivel.web.controller;

import com.jp.posto_combustivel.domain.abastecimento.Abastecimento;
import com.jp.posto_combustivel.domain.abastecimento.AbastecimentoService;
import com.jp.posto_combustivel.web.controller.docs.AbastecimentoDocs;
import com.jp.posto_combustivel.web.controller.dto.request.AbastecimentoRequest;
import com.jp.posto_combustivel.web.controller.dto.response.AbastecimentoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.jp.posto_combustivel.web.controller.dto.response.AbastecimentoResponse.toResponse;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/v1/abastecimentos")
@RequiredArgsConstructor
public class AbastecimentoController implements AbastecimentoDocs {

    private final AbastecimentoService abastecimentoService;

    @PostMapping
    public ResponseEntity<AbastecimentoResponse> criarAbastecimento(@RequestBody @Valid AbastecimentoRequest abastecimentoRequest) {
        Abastecimento abastecimento = abastecimentoService.abastecer(abastecimentoRequest.toEntity());
        return ResponseEntity.status(CREATED).body(toResponse(abastecimento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbastecimentoResponse> buscarAbastecimentoPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(toResponse(abastecimentoService.buscarPorId(id)));
    }
}
