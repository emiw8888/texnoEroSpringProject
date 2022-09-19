package com.example.texnoeraspringproject.client;

import feign.Response;
import feign.codec.ErrorDecoder;

public class TexnoEraSpringClientErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
//        throw new ClientException("TEXNOERA_UNIVERSITY_CLIENT_FAILED",503);
        return null;
    }
}
