package ru.pesto.herald.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Log4j2
public class MainController {

    @Value("${energy.url}")
    private String crimeaEnergyUrl;

    @GetMapping
    public String home() throws IOException {
        Document document = Jsoup.connect(crimeaEnergyUrl).get();
        document.select("#ptgrafoff").forEach(element -> {
            System.out.println(element);
            System.out.println(element.select("#ptgrafoff > .panel > button").text());
        });

        return "success";
    }
}
