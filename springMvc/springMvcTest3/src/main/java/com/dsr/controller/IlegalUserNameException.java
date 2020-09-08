package com.dsr.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "用户名错误")
public class IlegalUserNameException extends RuntimeException {
}
