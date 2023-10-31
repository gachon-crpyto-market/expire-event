package com.gachon.crpytomarket.common.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    /**
     *  400 Bad Request
     */
    USER_EXIST(HttpStatus.BAD_REQUEST, "유저 History Document가 이미 존재합니다."),

    /**
     *  401 Unauthorized
     */

    /**
     *  403 Forbidden
     */


    /**
     *  404 Not Found
     */
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "요청하신 엔티티를 찾을 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "요청하신 유저를 찾을 수 없습니다."),



    /**
     * 409 Conflict
     */

    /**
     *  500 INTERNAL SERVER ERROR
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다.");

    private final HttpStatus status;
    private final String message;
}
