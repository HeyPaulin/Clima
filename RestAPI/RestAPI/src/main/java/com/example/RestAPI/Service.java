package com.example.RestAPI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Service {
    public String preverTempo() {
        String dadosMeteorologicos = "";
        String apiUrl = "http://apiadvisor.climatempo.com.br/api/v1/anl/synoptic/locale/BR?token=fdcadcecc8c695e885084368c02d535c";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dadosMeteorologicos = responseEntity.getBody();
        } else {
            dadosMeteorologicos = "Falha ao obter dados meteorol[ogicos. Código de status: " + responseEntity.getStatusCode();
        }
        return dadosMeteorologicos;
    }

    }

