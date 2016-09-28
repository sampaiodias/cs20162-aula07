package com.github.kyriosdata.exemplo;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CalendarioTest {
    @Test
    public void formatoInvalido(){
        assertEquals(-1, Calendario.diaSemana(2001101, 2016, 20160928, 2));
    }
    
    @Test
    public void anoMaiorQue9999(){
        assertEquals(-1, Calendario.diaSemana(10000, 2016, 20160928, 2));
    }
    
    @Test
    public void mesMaiorQue12(){
        assertEquals(-1, Calendario.diaSemana(20161301, 2016, 20160928, 2));
    }
    
    @Test
    public void dia31EmMesQuePossui30(){
        assertEquals(-1, Calendario.diaSemana(20160931, 2016, 20160928, 2));
    }
    
    @Test
    public void diaBissextoEmAnoPadrao(){
        assertEquals(-1, Calendario.diaSemana(20150229, 2016, 20160928, 2));
    }
    
    @Test
    public void diaMenorQue1(){
        assertEquals(-1, Calendario.diaSemana(20160900, 2016, 20160928, 2));
    }
    
    @Test
    public void anoBissextoIgualAZero(){
        assertEquals(-1, Calendario.diaSemana(20160928, 0, 20160928, 2));
    }
    
    @Test
    public void anoBissextoIgualAMenos100(){
        assertEquals(-1, Calendario.diaSemana(20160928, -100, 20160928, 2));
    }
    
    @Test
    public void diaConhecidoDataInvalida(){
        assertEquals(-1, Calendario.diaSemana(20160928, 2016, 2016092, 2));
    }
    
    @Test
    public void diaSemanaValorMenorQueZero(){
        assertEquals(-1, Calendario.diaSemana(20160928, 2016, 20160928, 0));
    }
    
    @Test
    public void diaSemanaValorMaiorQue6(){
        assertEquals(-1, Calendario.diaSemana(20160928, 2016, 20160928, 7));
    }
    
    @Test
    public void aceitacaoDiaDeHoje(){
        assertEquals(2, Calendario.diaSemana(20160928, 2016, 20160928, 2));
    }
    
    @Test
    public void aceitacaoDia20160901(){
        assertEquals(2, Calendario.diaSemana(20160928, 2016, 20160901, 3));
    }
    
    @Test
    public void aceitacaoDia19950617(){
        assertEquals(5, Calendario.diaSemana(19950617, 2016, 20160928, 2));
    }
}

