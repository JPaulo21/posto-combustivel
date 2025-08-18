package com.jp.posto_combustivel.web.controller.docs;

import com.jp.posto_combustivel.web.controller.dto.request.BombaCombustivelRequest;
import com.jp.posto_combustivel.web.controller.dto.response.BombaCombustivelResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Bomba de Combustível", description = "Operações relacionadas às bombas de combustível")
public interface BombaCombustivelDocs {

    @Operation(summary = "Cria uma nova bomba de combustível", description = "Cadastrar uma nova bomba de combustível no sistema")
    @ApiResponse(responseCode = "201", description = "Bomba de combustível criada com sucesso!",
            content = @Content(mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = BombaCombustivelResponse.class)))
    ResponseEntity<BombaCombustivelResponse> criarBombaCombustivel(@RequestBody BombaCombustivelRequest bombaCombustivelRequest);

    @Operation(summary = "Lista as bombas de combustível paginadas", description = "Retorna uma lista paginada de bombas de combustível")
    @ApiResponse(responseCode = "200", description = "Lista de bombas de combustível",
            content = @Content(mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = BombaCombustivelResponse.class)))
    ResponseEntity<Page<BombaCombustivelResponse>> pageBombaCombustivel(Pageable pageable);

    @Operation(summary = "Deleta uma bomba de combustível", description = "Remove uma bomba de combustível do sistema")
    @ApiResponse(responseCode = "204", description = "Bomba de combustível deletada com sucesso",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    ResponseEntity<Void> deleteBombaCombustivel(Long id);
}
