package com.ensembl.exontranscript.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Transcript {
    @Column(name="transcript_id")
    @Id
    private long transcriptId;

    @Column(name="gene_id")
    private int geneId;

    @Column(name="analysis_id")
    private int analysisId;

    @Column(name="seq_region_id")
    private int seqRegionId;

    @Column(name="seq_region_start")
    private int seqRegionStart;

    @Column(name="seq_region_end")
    private int seqRegionEnd;

    @Column(name="display_xref_id")
    private int displayXrefId;

    @Column(name="source")
    private String source;

    @Column(name="biotype")
    private String biotype;

    @Column(name="description")
    private String description;

    @Column(name="is_current")
    private int isCurrent;

    @Column(name="canonical_translation_id")
    private int canonicalTranslationId;

    @Column(name="stable_id")
    private String stableId;

    @Column(name="version")
    private int version;

    @Column(name="created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdDate;

    @Column(name="modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date modified_date;
}