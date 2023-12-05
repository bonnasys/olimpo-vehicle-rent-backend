package br.com.bonnasys.olimpo.common.openapi.model.response;

import br.com.bonnasys.olimpo.users.app.rest.dto.response.UserSummaryResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageResponseOpenApi<T> {
    private List<T> content;
    @Schema(example = "10")
    private int size;
    @Schema(example = "54")
    private int totalElements;
    @Schema(example = "6")
    private int totalPages;
    private int page;

    public static class UserResponseOpenApi extends PageResponseOpenApi<UserSummaryResponse> {
    }
}
