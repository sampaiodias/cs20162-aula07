package com.github.kyriosdata.exemplo;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalendarioTest {

    @Test
    public void Teste1FormatoInvalido() {
        assertEquals(-1, Calendario.diaSemana(2001101, 2016, 20160928, 2));
    }

    @Test
    public void Teste2AnoMaiorQue9999() {
        assertEquals(-1, Calendario.diaSemana(10000, 2016, 20160928, 2));
    }

    @Test
    public void Teste3MesMaiorQue12() {
        assertEquals(-1, Calendario.diaSemana(20161301, 2016, 20160928, 2));
    }

    @Test
    public void Teste4Dia31EmMesQuePossui30() {
        assertEquals(-1, Calendario.diaSemana(20160931, 2016, 20160928, 2));
    }

    @Test
    public void Teste5DiaBissextoEmAnoPadrao() {
        assertEquals(-1, Calendario.diaSemana(20150229, 2016, 20160928, 2));
    }

    @Test
    public void Teste6DiaMenorQue1() {
        assertEquals(-1, Calendario.diaSemana(20160900, 2016, 20160928, 2));
    }

    @Test
    public void Teste7AnoBissextoIgualAZero() {
        assertEquals(-1, Calendario.diaSemana(20160928, 0, 20160928, 2));
    }

    @Test
    public void Teste8AnoBissextoIgualAMenos100() {
        assertEquals(-1, Calendario.diaSemana(20160928, -100, 20160928, 2));
    }

    @Test
    public void Teste9DiaConhecidoDataInvalida() {
        assertEquals(-1, Calendario.diaSemana(20160928, 2016, 2016092, 2));
    }

    @Test
    public void Teste10DiaSemanaValorMenorQueZero() {
        assertEquals(-1, Calendario.diaSemana(20160928, 2016, 20160928, -1));
    }

    @Test
    public void Teste11DiaSemanaValorMaiorQue6() {
        assertEquals(-1, Calendario.diaSemana(20160928, 2016, 20160928, 7));
    }

    @Test
    public void Teste12AceitacaoDiaDeHoje() {
        assertEquals(2, Calendario.diaSemana(20160928, 2016, 20160928, 2));
    }

    @Test
    public void Teste13AceitacaoDia20161231() {
        assertEquals(5, Calendario.diaSemana(20161231, 2016, 20161008, 5));
    }

    @Test
    public void Teste14AceitacaoDia19950617() {
        assertEquals(5, Calendario.diaSemana(19950617, 2016, 20160928, 2));
    }

    @Test
    public void Teste15Dia31EmMesDe30() {
        assertEquals(-1, Calendario.diaSemana(20160931, 2016, 20160928, 2));
    }
    
    @Test
    public void Teste16AceitacaoAmanha() {
        assertEquals(6, Calendario.diaSemana(20161009, 2016, 20161008, 5));
    }
    
    @Test
    public void Teste17AceitacaoOntem() {
        assertEquals(4, Calendario.diaSemana(20161007, 2016, 20161008, 5));
    }
    
    @Test
    public void Teste18Aceitacao20200301() {
        assertEquals(6, Calendario.diaSemana(20200301, 2016, 20161008, 5));
    }
    
    @Test
    public void Teste19Aceitacao20200201() {
        assertEquals(5, Calendario.diaSemana(20200201, 2016, 20161008, 5));
    }
    
    @Test
    public void Teste20AceitacaoFevNormal() {
        assertEquals(6, Calendario.diaSemana(20170205, 2016, 20161008, 5));
    }
}
