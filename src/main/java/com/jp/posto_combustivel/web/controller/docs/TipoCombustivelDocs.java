package com.jp.posto_combustivel.web.controller.docs;

import com.jp.posto_combustivel.web.controller.dto.request.TipoCombustivelRequest;
import com.jp.posto_combustivel.web.controller.dto.response.TipoCombustivelResponse;
import com.jp.posto_combustivel.web.exception.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Tipos de Combustível", description = "Endpoints para tipos de combustível")
public interface TipoCombustivelDocs {

    @Operation(summary = "Cria um novo recurso tipo de combustível", description = "Cadastrar um novo tipo de combustível no sistema")
    @ApiResponse(responseCode = "201", description = "Tipo de combustível criado com sucesso!",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = TipoCombustivelResponse.class)))
    ResponseEntity<TipoCombustivelResponse> createTipoCombustivel(TipoCombustivelRequest tipoCombustivelRequest);

    @Operation(summary = "Consulta um tipo de combustível por ID", description = "Buscar um tipo de combustível no sistema a partir de seu ID")
    @ApiResponse(responseCode = "200", description = "Tipo de combustível encontrado com sucesso!",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = TipoCombustivelResponse.class)))
    @ApiResponse(responseCode = "404", description = "Tipo de combustível não encontrado com o ID:",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class)))
    ResponseEntity<TipoCombustivelResponse> buscarPorId(Long id);

    @Operation(summary = "Atualiza um tipo de combustível", description = "Altera os dados de um tipo de combustível existente")
    @ApiResponse(responseCode = "200", description = "Tipo de combustível atualizado com sucesso!",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = TipoCombustivelResponse.class)))
    @ApiResponse(responseCode = "404", description = "Tipo de combustível não encontrado com o ID:",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class)))
    ResponseEntity<TipoCombustivelResponse> alterarTipoCombustivel(Long id, TipoCombustivelRequest tipoCombustivelRequest);
}
