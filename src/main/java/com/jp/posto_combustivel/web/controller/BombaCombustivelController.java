package com.jp.posto_combustivel.web.controller;

import com.jp.posto_combustivel.domain.bombacombustivel.BombaCombustivel;
import com.jp.posto_combustivel.domain.bombacombustivel.BombaCombustivelService;
import com.jp.posto_combustivel.web.controller.docs.BombaCombustivelDocs;
import com.jp.posto_combustivel.web.controller.dto.request.BombaCombustivelRequest;
import com.jp.posto_combustivel.web.controller.dto.response.BombaCombustivelResponse;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.jp.posto_combustivel.web.controller.dto.response.BombaCombustivelResponse.toResponse;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/v1/bombas-combustivel")
@RequiredArgsConstructor
public class BombaCombustivelController implements BombaCombustivelDocs {

    private final BombaCombustivelService bombaCombustivelService;

    @PostMapping
    public ResponseEntity<BombaCombustivelResponse> criarBombaCombustivel(@RequestBody BombaCombustivelRequest bombaCombustivelRequest) {
        BombaCombustivel bombaCombustivel = bombaCombustivelService.salvar(bombaCombustivelRequest.toEntity());
        return ResponseEntity.status(CREATED).body(toResponse(bombaCombustivel));
    }

    @GetMapping
    public ResponseEntity<Page<BombaCombustivelResponse>> pageBombaCombustivel(@Parameter(hidden = true) @PageableDefault(sort = "nome", direction = Sort.Direction.DESC)  Pageable pageable){
        Page<BombaCombustivel> bombaCombustivelPage = bombaCombustivelService.listarBombasPaginado(pageable);
        Page<BombaCombustivelResponse> bombaCombustivelResponsePage = bombaCombustivelPage
                .map(BombaCombustivelResponse::toResponse);
        return ResponseEntity.ok(bombaCombustivelResponsePage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBombaCombustivel(@PathVariable("id") Long id) {
        bombaCombustivelService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
