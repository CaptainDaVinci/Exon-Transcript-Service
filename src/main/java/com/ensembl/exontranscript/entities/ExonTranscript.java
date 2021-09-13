package com.ensembl.exontranscript.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ExonTranscript {
    @EmbeddedId
    private ExonTranscriptKey exonTranscriptKey;
}
