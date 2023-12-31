package com.planmate.server.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.planmate.server.dto.request.tendinous.AlertRequestDto;
import com.planmate.server.service.tendinous.AlertService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/tendinous")
@Slf4j
@Api(tags = {"건의 관련 API"})
@RequiredArgsConstructor
public class TendinousController {
    private final AlertService alertService;

    @PostMapping("alert")
    @ApiOperation(value = "신고 내용을 슬랙으로 전송")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "삭제 환료")
    })
    public ResponseEntity signOut(@RequestBody AlertRequestDto alertRequestDto) {
        alertService.alert(alertRequestDto);
        return ResponseEntity.ok().build();
    }
}
