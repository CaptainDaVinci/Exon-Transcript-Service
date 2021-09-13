package com.ensembl.exontranscript.controllers;

import com.ensembl.exontranscript.entities.Exon;
import com.ensembl.exontranscript.services.ExonTranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class ExonTranscriptServiceController {
    @Autowired
    ExonTranscriptService exonTranscriptService;

    @GetMapping("/healthcheck")
    Map<String, String> healthCheck() {
        return Collections.singletonMap("health", "OK");
    }

    @GetMapping("/api/exons")
    List<Exon> getExonsByTranscriptId(@RequestParam Long transcriptId) {
        return exonTranscriptService.getExonsByTranscriptId(transcriptId);
    }
}
