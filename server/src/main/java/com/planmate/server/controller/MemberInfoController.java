package com.planmate.server.controller;

import com.planmate.server.dto.response.login.LoginResponseDto;
import com.planmate.server.service.member.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@Slf4j
@RequiredArgsConstructor
@Api(tags = {"사용자 인증 정보 API"})
@RequestMapping("/info")
public class MemberInfoController {

    private final MemberService memberService;
    
    @ApiOperation(value = "유저 인증 정보 받아오기")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "이미지 변경 환료")
    })
    @GetMapping(value = "/auth")
    public ResponseEntity<LoginResponseDto> getMemberInfo(@RequestParam("id") Long id) {
        LoginResponseDto responseDto = memberService.getUserInfo(id);

        return ResponseEntity.ok(responseDto);
    }
}
