package com.ensembl.exontranscript.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ExonTranscriptKey implements Serializable {
    @ManyToOne
    @JoinColumn(name="exon_id")
    private Exon exon;

    @ManyToOne
    @JoinColumn(name="transcript_id")
    private Transcript transcript;

    @Column(name="rank")
    private int rank;
}
