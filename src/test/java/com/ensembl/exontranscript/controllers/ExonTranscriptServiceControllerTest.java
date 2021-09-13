package com.ensembl.exontranscript.controllers;

import com.ensembl.exontranscript.entities.Exon;
import com.ensembl.exontranscript.services.ExonTranscriptService;
import org.jeasy.random.EasyRandom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ExonTranscriptServiceController.class)
public class ExonTranscriptServiceControllerTest {
    @MockBean
    ExonTranscriptService exonTranscriptService;

    @Autowired
    private MockMvc mockMvc;
    private List<Exon> mockExonData;

    @Before
    public void setup() {
        EasyRandom generator  = new EasyRandom();
        this.mockExonData = generator.objects(Exon.class, 1).collect(Collectors.toList());
    }

    @Test
    public void shouldReturnExons() throws Exception {
        when(this.exonTranscriptService.getExonsByTranscriptId(anyLong())).thenReturn(this.mockExonData);

        this.mockMvc.perform(get("/api/exons?transcriptId=1680"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].exonId", is(this.mockExonData.get(0).getExonId())))
                    .andExpect(jsonPath("$[0].stableId", is(this.mockExonData.get(0).getStableId())));
    }

    @Test
    public void shouldThrowBadRequestException() throws Exception {
        this.mockMvc.perform(get("/api/exons"))
                .andExpect(status().is4xxClientError());
    }
}
