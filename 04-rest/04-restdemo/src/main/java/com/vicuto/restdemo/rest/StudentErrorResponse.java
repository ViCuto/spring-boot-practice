package com.vicuto.restdemo.rest;

public record StudentErrorResponse(int status,
                                   String message,
                                   long timeStamp) {
}
