package com.ensembl.exontranscript.repositories;

import com.ensembl.exontranscript.entities.Exon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExonRepository extends JpaRepository<Exon, Integer> {

    @Query(value = "select et.exonTranscriptKey.exon from ExonTranscript et where et.exonTranscriptKey.transcript.transcriptId = ?1")
    List<Exon> findAllByTranscriptId(long transcriptId);

}
