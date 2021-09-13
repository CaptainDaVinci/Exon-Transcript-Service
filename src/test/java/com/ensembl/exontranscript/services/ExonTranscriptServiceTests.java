package com.ensembl.exontranscript.services;

import com.ensembl.exontranscript.entities.Exon;
import com.ensembl.exontranscript.repositories.ExonRepository;
import org.jeasy.random.EasyRandom;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExonTranscriptServiceTests {
    @InjectMocks
    ExonTranscriptService exonTranscriptService;

    @Mock
    ExonRepository mockExonRepository;

    private final long TRANSCRIPT_ID = 1680;
    private final long NON_EXISTING_TRANSCRIPT_ID = 16;
    private List<Exon> mockExonData;

    @Before
    public void setup() {
        EasyRandom generator  = new EasyRandom();
        this.mockExonData = generator.objects(Exon.class, 5).collect(Collectors.toList());
    }

    @Test
    public void testExonsForATranscriptId() {
        when(this.mockExonRepository.findAllByTranscriptId(eq(this.TRANSCRIPT_ID))).thenReturn(this.mockExonData);

        List<Exon> actual = exonTranscriptService.getExonsByTranscriptId(this.TRANSCRIPT_ID);
        Assert.assertEquals(this.mockExonData, actual);
    }

    @Test
    public void testNoExonsForATranscriptId() {
        when(this.mockExonRepository.findAllByTranscriptId(eq(this.NON_EXISTING_TRANSCRIPT_ID))).thenReturn(new ArrayList<>());

        List<Exon> actual = exonTranscriptService.getExonsByTranscriptId(this.NON_EXISTING_TRANSCRIPT_ID);
        Assert.assertEquals(0, actual.size());
    }
}
