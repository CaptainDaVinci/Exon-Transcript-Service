package com.ensembl.exontranscript.services;

import com.ensembl.exontranscript.entities.Exon;

import java.util.List;

public interface IExonTranscriptService {
    List<Exon> getExonsByTranscriptId(Long transcriptId);
}
