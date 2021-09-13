package com.ensembl.exontranscript.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Exon {
    @Column(name="exon_id")
    @Id
    private long exonId;

    @Column(name="seq_region_id")
    private int seqRegionId;

    @Column(name="seq_region_start")
    private int seqRegionStart;

    @Column(name="seq_region_end")
    private int seqRegionEnd;

    @Column(name="seq_region_strand")
    private int seqRegionStrand;

    @Column(name="phase")
    private int phase;

    @Column(name="end_phase")
    private int endPhase;

    @Column(name="is_current")
    private int isCurrent;

    @Column(name="is_constitutive")
    private int isConstitutive;

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
