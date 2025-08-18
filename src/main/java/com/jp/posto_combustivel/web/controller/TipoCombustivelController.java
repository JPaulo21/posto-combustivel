package com.jp.posto_combustivel.web.controller;

import com.jp.posto_combustivel.domain.tipocombustivel.TipoCombustivel;
import com.jp.posto_combustivel.domain.tipocombustivel.TipoCombustivelService;
import com.jp.posto_combustivel.web.controller.docs.TipoCombustivelDocs;
import com.jp.posto_combustivel.web.controller.dto.request.TipoCombustivelRequest;
import com.jp.posto_combustivel.web.controller.dto.response.TipoCombustivelResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/v1/tipos-combustivel", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TipoCombustivelController implements TipoCombustivelDocs {

    private static final Logger log = LoggerFactory.getLogger(TipoCombustivelController.class);
    private final TipoCombustivelService tipoCombustivelService;

    @PostMapping
    public ResponseEntity<TipoCombustivelResponse> createTipoCombustivel(@RequestBody TipoCombustivelRequest tipoCombustivelRequest) {
        TipoCombustivel tipoCombustivel = tipoCombustivelService.criar(tipoCombustivelRequest.toEntity());
        log.info("Tipo de combustível criado com sucesso: {}", tipoCombustivel);
        return ResponseEntity.status(HttpStatus.CREATED).body(TipoCombustivelResponse.toResponse(tipoCombustivel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoCombustivelResponse> buscarPorId(@PathVariable Long id) {
        TipoCombustivel tipoCombustivel = tipoCombustivelService.buscarPorId(id);
        log.info("Tipo de combustível encontrado: {}", tipoCombustivel);
        return ResponseEntity.ok(TipoCombustivelResponse.toResponse(tipoCombustivel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoCombustivelResponse> alterarTipoCombustivel(@PathVariable Long id, TipoCombustivelRequest tipoCombustivelRequest) {
        TipoCombustivel tipoCombustivel = tipoCombustivelService.alterar(id, tipoCombustivelRequest.toEntity());
        return ResponseEntity.ok(TipoCombustivelResponse.toResponse(tipoCombustivel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoCombustivel(@PathVariable Long id) {
        tipoCombustivelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
