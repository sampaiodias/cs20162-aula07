package com.github.kyriosdata.exemplo;

public class Calendario
{
    public static int diaSemana(int data, int bissexto, int conhecida, int ds) {
        int diaDaSemana = -1;
        int ano;
        int mes;
        int dia;
        
        if (dataFormatoValida(data) && dataFormatoValida(conhecida) 
                && bissexto > 0 && diaSemanaValido(ds)){ 
            ano = getAno(data);
            mes = getMes(data);
            dia = getDia(data);
            if (dataValida(ano, mes, dia, bissexto)){
                if (data > conhecida){ //Data conhecida é passada
                    while (conhecida < data){
                        conhecida++;
                        ds = incrementarDiaSemana(ds);
                    }
                }
                else{
                    while (conhecida > data){
                        conhecida--;
                        ds = incrementarDiaSemana(ds);
                    }
                }
                diaDaSemana = ds;
            }
        }
        
        return diaDaSemana;
    }
    
    private static int incrementarDiaSemana(int ds){
        ds++;
        
        if (ds > 6){
            ds = 0;
        }
        
        return ds;
    }
    
    private static int decrementarDiaSemana(int ds){
        ds--;
        
        if (ds < 0){
            ds = 6;
        }
        
        return ds;
    }
    
    private static boolean dataFormatoValida(int data){
        if (data > 9999999 && data < 100000000){ //Formato AAAAMMDD
            return true;
        }
        else{
            return false;
        }        
    }
    
    private static boolean diaSemanaValido(int dia){
        if (dia >= 0 && dia <= 6){
            return true;
        }
        else{
            return false;
        }
    }
    
    private static int getAno(int data){
        String texto = "" + data;
        String ano = texto.substring(0, 4);
        return Integer.parseInt(ano);
    }
    
    private static int getMes(int data){
        String texto = "" + data;
        String mes = texto.substring(4, 6);
        return Integer.parseInt(mes);
    }
    
    private static int getDia(int data){
        String texto = "" + data;
        String dia = texto.substring(6);
        return Integer.parseInt(dia);
    }
    
    private static boolean dataValida(int ano, int mes, int dia, int bissexto){
        boolean valido = false;
        if (mes >= 1 && mes <= 12 && dia >= 1 && dia <= 31){ //Limites maximos
            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 ||
                    mes == 8 || mes == 10 || mes == 12){ //Meses com 31 dias
                valido = true;  
            }
            else{
                if (mes == 2){
                    if (verificarBissexto(ano, bissexto)){
                        if (dia <= 29){
                            valido = true;
                        }   
                    }
                    else{
                        if (dia <= 28){
                            valido = true;
                        }
                    }
                }
                else{ //Meses com 30 dias
                    if (dia <= 30){
                        valido = true;
                    }
                }
            }
        }
        return valido;
    }
    
    private static boolean verificarBissexto(int ano, int bissexto){
        if (ano == bissexto){
            return true;
        }
        else{
            for (int dataTestada = ano; dataTestada < 10000; dataTestada += 4){
                if (dataTestada == bissexto){
                    return true;
                }
            }
            for (int dataTestada = ano; dataTestada > 999; dataTestada -= 4){
                if (dataTestada == bissexto){
                    return true;
                }
            }
        }
        return false;
    }
}