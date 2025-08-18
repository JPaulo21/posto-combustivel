package com.jp.posto_combustivel.web.controller.docs;

import com.jp.posto_combustivel.web.controller.dto.request.AbastecimentoRequest;
import com.jp.posto_combustivel.web.controller.dto.response.AbastecimentoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Abastecimento", description = "Operações relacionadas a abastecimentos")
public interface AbastecimentoDocs {

    @Operation(summary = "Criar um novo abastecimento", description = "Registra um novo abastecimento no sistema")
    @ApiResponse(responseCode = "201", description = "Abastecimento criado com sucesso",
            content = @Content(mediaType = "application/json"))
    ResponseEntity<AbastecimentoResponse> criarAbastecimento(AbastecimentoRequest abastecimentoRequest);

    @Operation(summary = "Buscar abastecimento por ID", description = "Retorna os detalhes de um abastecimento específico pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Detalhes do abastecimento",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = AbastecimentoResponse.class)))
    ResponseEntity<AbastecimentoResponse> buscarAbastecimentoPorId(Long id);
}
