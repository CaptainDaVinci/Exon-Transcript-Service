package com.ensembl.exontranscript.services;

import com.ensembl.exontranscript.entities.Exon;
import com.ensembl.exontranscript.repositories.ExonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExonTranscriptService implements IExonTranscriptService {
    @Autowired
    ExonRepository exonRepository;

    @Override
    public List<Exon> getExonsByTranscriptId(Long transcriptId) {
        return exonRepository.findAllByTranscriptId(transcriptId);
    }
}
