package com.selim.uscis_case_tracker_app.controller;

import com.selim.uscis_case_tracker_app.entity.Case;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/uscis")
@RequiredArgsConstructor
public class uscis {

    @Value("${uscis.bearer-token}")
    private String bearerToken;

    private final RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<String> getUserCases() {
        // 1. USCIS dış API çağrısı (sadece örnek)
        RestTemplate restTemplate = new RestTemplate();

        String uscisApiUrl = "https://api-int.uscis.gov/case-status/EAC9999103403"; // Gerçek endpoint'e göre düzenle

        try {
            // Opsiyonel: Header ekleyebilirsin
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "application/json");
            headers.set( "Authorization", "Bearer " + bearerToken);

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<String> uscisResponse = restTemplate.exchange(
                    uscisApiUrl, HttpMethod.GET, entity, String.class
            );

            System.out.println("USCIS API RESPONSE: " + uscisResponse.getBody());

            // Ancak şimdilik response'u kullanmadan DB'den case dönüyoruz:
            return ResponseEntity.ok(uscisResponse.getBody());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(404).build();
        }
    }
}

//AWS deployement Ec2 case number yazildiginida bana case status donucek.
//Index sayfasina gidince. Ana sayfaya gidince index.html ye gididicek.
//REst degil normal controller kullanicam cunku api mi index.html e yonlendiricem
//Ec2 public ip adresi girince homepage e gidicek orda da bi tane text box olucak buraya reciept number yazcam
//search dicem sonra gelen cevabi gostericek. scp ile upload yapicam instancima sonra jari calistiricam.
//Token api ile cagiricam postmande yaptigimizi acces token alicam ve sonra bunu code icine girmesi lazim. Ilk once
//Token i aliyorum sonra o token ile gercek case i cagiricam. Thymleaf(frontend)
