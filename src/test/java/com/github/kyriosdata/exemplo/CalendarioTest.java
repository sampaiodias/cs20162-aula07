package com.github.kyriosdata.exemplo;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalendarioTest {
    @Test
    public void Teste1FormatoInvalido(){
        assertEquals(-1, Calendario.diaSemana(2001101, 2016, 20160928, 2));
    }
    
    @Test
    public void Teste2AnoMaiorQue9999(){
        assertEquals(-1, Calendario.diaSemana(10000, 2016, 20160928, 2));
    }
    
    @Test
    public void Teste3MesMaiorQue12(){
        assertEquals(-1, Calendario.diaSemana(20161301, 2016, 20160928, 2));
    }
    
    @Test
    public void Teste4Dia31EmMesQuePossui30(){
        assertEquals(-1, Calendario.diaSemana(20160931, 2016, 20160928, 2));
    }
    
    @Test
    public void Teste5DiaBissextoEmAnoPadrao(){
        assertEquals(-1, Calendario.diaSemana(20150229, 2016, 20160928, 2));
    }
    
    @Test
    public void Teste6DiaMenorQue1(){
        assertEquals(-1, Calendario.diaSemana(20160900, 2016, 20160928, 2));
    }
    
    @Test
    public void Teste7AnoBissextoIgualAZero(){
        assertEquals(-1, Calendario.diaSemana(20160928, 0, 20160928, 2));
    }
    
    @Test
    public void Teste8AnoBissextoIgualAMenos100(){
        assertEquals(-1, Calendario.diaSemana(20160928, -100, 20160928, 2));
    }
    
    @Test
    public void Teste9DiaConhecidoDataInvalida(){
        assertEquals(-1, Calendario.diaSemana(20160928, 2016, 2016092, 2));
    }
    
    @Test
    public void Teste10DiaSemanaValorMenorQueZero(){
        assertEquals(-1, Calendario.diaSemana(20160928, 2016, 20160928, -1));
    }
    
    @Test
    public void Teste11DiaSemanaValorMaiorQue6(){
        assertEquals(-1, Calendario.diaSemana(20160928, 2016, 20160928, 7));
    }
    
    @Test
    public void Teste12AceitacaoDiaDeHoje(){
        assertEquals(2, Calendario.diaSemana(20160928, 2016, 20160928, 2));
    }
    
    @Test
    public void Teste13AceitacaoDia20160901(){
        assertEquals(2, Calendario.diaSemana(20160928, 2016, 20160901, 3));
    }
    
    @Test
    public void Teste14AceitacaoDia19950617(){
        assertEquals(5, Calendario.diaSemana(19950617, 2016, 20160928, 2));
    }
    
    @Test
    public void Teste15Dia31EmMesDe30(){
        assertEquals(-1, Calendario.diaSemana(20160931, 2016, 20160928, 2));
    }
}

