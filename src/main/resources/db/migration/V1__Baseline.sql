create table exon (
  exon_id int not null,
  seq_region_id int,
  seq_region_start int,
  seq_region_end int,
  seq_region_strand tinyint(2),
  phase tinyint(2),
  end_phase tinyint(2),
  is_current tinyint(1),
  is_constitutive tinyint(1),
  stable_id varchar(128),
  version smallint,
  created_date datetime,
  modified_date datetime,

  primary key (exon_id)
);

create table transcript (
  transcript_id int not null,
  gene_id int,
  analysis_id int,
  seq_region_id int,
  seq_region_start int,
  seq_region_end int,
  display_xref_id int,
  source varchar(40),
  biotype varchar(40),
  description text,
  is_current tinyint(1),
  canonical_translation_id int,
  stable_id varchar(128),
  version smallint,
  created_date datetime,
  modified_date datetime,

  primary key (transcript_id)
);

create table exon_transcript (
  exon_id int not null,
  transcript_id int not null,
  rank int,

  primary key (exon_id, transcript_id, rank)
);