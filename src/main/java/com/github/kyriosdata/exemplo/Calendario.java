/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.kyriosdata.exemplo;

/**
 * Classe Calendário que verifica qual o dia da semana de uma data.
 */
public final class Calendario {

    /**
     * Construtor.
     */
    private Calendario() {
    }
    /**
     * Valor máximo para que a entrada esteja no formato AAAAMMDD.
     */
    private static final int MAX_FORMATO_VALIDO = 100000000;
    /**
     * Valor mínimo para que a entrada esteja no formato AAAAMMDD.
     */
    private static final int MIN_FORMATO_VALIDO = 9999999;
    /**
     * Código para o dia de Domingo.
     */
    private static final int COD_DOMINGO = 6;
    /**
     * Código para o dia de Segunda.
     */
    private static final int COD_SEGUNDA = 0;
    /**
     * Código para o mês.
     */
    private static final int COD_JANEIRO = 1;
    /**
     * Código para o mês.
     */
    private static final int COD_FEVEREIRO = 2;
    /**
     * Código para o mês.
     */
    private static final int COD_MARCO = 3;
    /**
     * Código para o mês.
     */
    private static final int COD_MAIO = 5;
    /**
     * Código para o mês.
     */
    private static final int COD_JULHO = 7;
    /**
     * Código para o mês.
     */
    private static final int COD_AGOSTO = 8;
    /**
     * Código para o mês.
     */
    private static final int COD_OUTUBRO = 10;
    /**
     * Código para o mês.
     */
    private static final int COD_DEZEMBRO = 12;
    /**
     * Número de dias em um Fevereiro bissexto.
     */
    private static final int DIAS_FEV_BISSEXTO = 29;
    /**
     * Número de dias em um Fevereiro.
     */
    private static final int DIAS_FEV = 28;
    /**
     * Número de dias de meses 'normais'.
     */
    private static final int DIAS_MES30 = 30;
    /**
     * Número de dias de meses com 31 dias.
     */
    private static final int DIAS_MES31 = 31;
    /**
     * Data mínima para anos válidos (exclusivo).
     */
    private static final int LIMITE_ANO_MIN = 999;
    /**
     * Data máxima para anos válidos (exclusivo).
     */
    private static final int LIMITE_ANO_MAX = 10000;
    /**
     * Intervalo de anos entre anos bissextos.
     */
    private static final int INTERVALO_BISSEXTO = 4;
    /**
     * Marcador na substring para código de datas AAAAMMDD.
     */
    private static final int LIMITE_COD_DIA = 6;
    /**
     * Marcador na substring para código de datas AAAAMMDD.
     */
    private static final int LIMITE_COD_MES = 4;

    /**
     * Retorna um valor de 0 a 6 representando um dia da semana.
     *
     * @param dataAlvo Data alvo representada no formato AAAAMMDD
     * @param bissexto Valor maior que 0 se a data conhecida for bissexta
     * @param conhecida Data conhecida no formato AAAAMMDD
     * @param ds Dia da semana da data "Conhecida"
     *
     * @return resultado valor de 0 a 6 representando o dia da semana
     */
    public static int diaSemana(final int dataAlvo, final int bissexto,
            final int conhecida, final int ds) {
        int diaSemana = ds;
        int resultado = -1;
        int ano;
        int mes;
        int dia;
        int diaConhecido;
        int mesConhecido;
        int anoConhecido;
        boolean respostaEncontrada = false;

        if (dataFormatoValida(dataAlvo) && dataFormatoValida(conhecida)
                && bissexto > 0 && diaSemanaValido(ds)) {
            ano = getAno(dataAlvo);
            mes = getMes(dataAlvo);
            dia = getDia(dataAlvo);
            anoConhecido = getAno(conhecida);
            mesConhecido = getMes(conhecida);
            diaConhecido = getDia(conhecida);
            if (dataValida(ano, mes, dia, bissexto)) {
                if (dataAlvo > conhecida) { //Data conhecida é passada
                    while (!respostaEncontrada) {
                        if (dia == diaConhecido && mes == mesConhecido
                                && ano == anoConhecido) {
                            respostaEncontrada = true;
                        } else {
                            int diaConhecidoAux = diaConhecido;
                            int mesConhecidoAux = mesConhecido;
                            int anoConhecidoAux = anoConhecido;
                            diaConhecido = incrementarDia(diaConhecidoAux,
                                    mesConhecidoAux, anoConhecidoAux, bissexto);
                            mesConhecido = incrementarMes(diaConhecidoAux,
                                    mesConhecidoAux, anoConhecidoAux, bissexto);
                            anoConhecido = incrementarAno(diaConhecidoAux,
                                    mesConhecidoAux, anoConhecidoAux, bissexto);
                            diaSemana = incrementarDiaSemana(diaSemana);
                        }
                    }
                } else {
                    while (!respostaEncontrada) {
                        if (dia == diaConhecido && mes == mesConhecido
                                && ano == anoConhecido) {
                            respostaEncontrada = true;
                        } else {
                            int diaConhecidoAux = diaConhecido;
                            int mesConhecidoAux = mesConhecido;
                            int anoConhecidoAux = anoConhecido;
                            diaConhecido = decrementarDia(diaConhecidoAux,
                                    mesConhecidoAux, anoConhecidoAux, bissexto);
                            mesConhecido = decrementarMes(diaConhecidoAux,
                                    mesConhecidoAux, anoConhecidoAux, bissexto);
                            anoConhecido = decrementarAno(diaConhecidoAux,
                                    mesConhecidoAux, anoConhecidoAux, bissexto);
                            diaSemana = decrementarDiaSemana(diaSemana);
                        }
                    }
                }
                resultado = diaSemana;
            }
        }

        return resultado;
    }

    /**
     * Encontra qual o código do dia da semana do dia seguinte ao informado.
     *
     * @param diaSemana Dia da semana atual
     * @return Dia da semana do dia seguinte
     */
    private static int incrementarDiaSemana(final int diaSemana) {
        int ds = diaSemana;
        ds++;

        if (ds > COD_DOMINGO) {
            ds = COD_SEGUNDA;
        }

        return ds;
    }

    /**
     * Encontra o valor numérico do dia seguinte.
     *
     * @param dia dia atual
     * @param mes mes atual
     * @param ano ano atual
     * @param bissexto um ano que é conhecidamente bissexto
     * @return novo valor de dia.
     */
    private static int incrementarDia(final int dia, final int mes,
            final int ano, final int bissexto) {
        int hoje = dia;
        hoje++;
        if (hoje > DIAS_FEV) {
            if (mes == COD_FEVEREIRO) {
                System.out.println("aaaa");
                if (!verificarBissexto(ano, bissexto)) { //Dia 29 em ano normal
                    hoje = 1;
                } else if (hoje > DIAS_FEV_BISSEXTO) {
                    hoje = 1;
                }
            } else if (mes == COD_JANEIRO || mes == COD_MARCO
                    || mes == COD_MAIO || mes == COD_JULHO
                    || mes == COD_AGOSTO || mes == COD_OUTUBRO
                    || mes == COD_DEZEMBRO) {
                if (dia > DIAS_MES31) {
                    hoje = 1;
                }
            } else if (dia > DIAS_MES30) {
                hoje = 1;
            }
        }
        return hoje;
    }

    /**
     * Encontra o valor numérico do dia anterior.
     *
     * @param dia dia atual
     * @param mes mes atual
     * @param ano ano atual
     * @param bissexto um ano que é conhecidamente bissexto
     * @return novo valor de dia.
     */
    private static int decrementarDia(final int dia, final int mes,
            final int ano, final int bissexto) {
        int hoje = dia;
        int mesAtual = mes;
        hoje--;
        if (hoje < 1) {
            mesAtual = decrementarMes(hoje, mes, ano, bissexto);
            if (mesAtual == COD_FEVEREIRO) {
                if (!verificarBissexto(ano, bissexto)) { //Dia 29 em ano normal
                    hoje = DIAS_FEV;
                } else {
                    hoje = DIAS_FEV_BISSEXTO;
                }
            } else if (mesAtual == COD_JANEIRO || mesAtual == COD_MARCO
                    || mesAtual == COD_MAIO || mesAtual == COD_JULHO
                    || mesAtual == COD_AGOSTO || mesAtual == COD_OUTUBRO
                    || mesAtual == COD_DEZEMBRO) {
                hoje = DIAS_MES31;
            } else {
                hoje = DIAS_MES30;
            }
        }
        return hoje;
    }

    /**
     * Encontra o valor numérico do mês anterior.
     *
     * @param dia dia atual
     * @param mes mes atual
     * @param ano ano atual
     * @param bissexto um ano que é conhecidamente bissexto
     * @return novo valor de mês
     */
    private static int decrementarMes(final int dia, final int mes,
            final int ano, final int bissexto) {
        int hoje = dia;
        int mesAtual = mes;
        hoje--;
        if (hoje < 1) {
            mesAtual--;
        }
        if (mesAtual < 1) {
            mesAtual = COD_DEZEMBRO;
        }
        return mesAtual;
    }

    /**
     * Encontra o valor numérico do mês de amanhã.
     *
     * @param dia dia atual
     * @param mes mes atual
     * @param ano ano atual
     * @param bissexto um ano que é conhecidamente bissexto
     * @return novo valor de mês
     */
    private static int incrementarMes(final int dia, final int mes,
            final int ano, final int bissexto) {
        int mesAtual = mes;
        int hoje = dia;
        hoje++;
        if (hoje > DIAS_FEV) {
            if (mesAtual == COD_FEVEREIRO) {
                if (!verificarBissexto(ano, bissexto)) { //Dia 29 em ano normal
                    mesAtual++;
                } else if (hoje > DIAS_FEV_BISSEXTO) {
                    mesAtual++;
                }
            } else if (mesAtual == COD_JANEIRO || mesAtual == COD_MARCO
                    || mesAtual == COD_MAIO || mesAtual == COD_JULHO
                    || mesAtual == COD_AGOSTO || mesAtual == COD_OUTUBRO
                    || mesAtual == COD_DEZEMBRO) {
                if (hoje > DIAS_MES31) {
                    mesAtual++;
                }
            } else if (hoje > DIAS_MES30) {
                mesAtual++;
            }
        }
        if (mesAtual > COD_DEZEMBRO) {
            mesAtual = COD_JANEIRO;
        }
        return mesAtual;
    }

    /**
     * Encontra o valor numérico de ano para amanhã.
     *
     * @param dia dia atual
     * @param mes mes atual
     * @param ano ano atual
     * @param bissexto um ano que é conhecidamente bissexto
     * @return novo valor de ano
     */
    private static int incrementarAno(final int dia, final int mes,
            final int ano, final int bissexto) {
        if (dia >= DIAS_MES31 && mes == COD_DEZEMBRO) {
            return ano + 1;
        }
        return ano;
    }

    /**
     * Encontra o valor numérico de ano para amanhã.
     *
     * @param dia dia atual
     * @param mes mes atual
     * @param ano ano atual
     * @param bissexto um ano que é conhecidamente bissexto
     * @return novo valor de ano
     */
    private static int decrementarAno(final int dia, final int mes,
            final int ano, final int bissexto) {
        if (dia <= 1 && mes == COD_JANEIRO) {
            return ano - 1;
        }
        return ano;
    }

    /**
     * Encontra qual o código do dia da semana do dia anterior ao informado.
     *
     * @param diaSemana Dia da semana atual
     * @return Dia da semana do dia anterior
     */
    private static int decrementarDiaSemana(final int diaSemana) {
        int ds = diaSemana;
        ds--;

        if (ds < COD_SEGUNDA) {
            ds = COD_DOMINGO;
        }

        return ds;
    }

    /**
     * Verifica se a data informada está no formato AAAAMMDD.
     *
     * @param data data informada
     * @return Verdadeiro ou falso
     */
    private static boolean dataFormatoValida(final int data) {
        return data > MIN_FORMATO_VALIDO && data < MAX_FORMATO_VALIDO;
    }

    /**
     * Verifica se o código da semana está entre 0 e 6.
     *
     * @param dia código informado
     * @return Verdadeiro ou falso
     */
    private static boolean diaSemanaValido(final int dia) {
        return dia >= COD_SEGUNDA && dia <= COD_DOMINGO;
    }

    /**
     * Obtém um valor inteiro para o ano a partir de uma data.
     *
     * @param data Data no formato AAAAMMDD
     * @return Valor do ano
     */
    private static int getAno(final int data) {
        String texto = "" + data;
        String ano = texto.substring(0, LIMITE_COD_MES);
        return Integer.parseInt(ano);
    }

    /**
     * Obtém um valor inteiro para o mês a partir de uma data.
     *
     * @param data Data no formato AAAAMMDD
     * @return Valor do mês
     */
    private static int getMes(final int data) {
        String texto = "" + data;
        String mes = texto.substring(LIMITE_COD_MES, LIMITE_COD_DIA);
        return Integer.parseInt(mes);
    }

    /**
     * Obtém um valor inteiro para o dia a partir de uma data.
     *
     * @param data Data no formato AAAAMMDD
     * @return Valor do dia
     */
    private static int getDia(final int data) {
        String texto = "" + data;
        String dia = texto.substring(LIMITE_COD_DIA);
        return Integer.parseInt(dia);
    }

    /**
     * Verifica se a data informada está de acordo com o calendário gregoriano.
     *
     * @param ano Ano informado
     * @param mes Mês informado
     * @param dia Dia informado
     * @param bissexto Ano bissexto
     * @return Verdadeiro ou falso
     */
    private static boolean dataValida(final int ano, final int mes,
            final int dia, final int bissexto) {
        int anoAtual = ano;
        int mesAtual = mes;
        int diaAtual = dia;
        boolean valido = false;
        if (mesAtual >= COD_JANEIRO && mesAtual <= COD_DEZEMBRO
                && diaAtual >= 1 && diaAtual <= DIAS_MES31) { //Limites maximos
            if (mesAtual == COD_JANEIRO || mesAtual == COD_MARCO
                    || mesAtual == COD_MAIO || mesAtual == COD_JULHO
                    || mesAtual == COD_AGOSTO || mesAtual == COD_OUTUBRO
                    || mesAtual == COD_DEZEMBRO) { //Meses com 31 dias
                valido = true;
            } else if (mesAtual == COD_FEVEREIRO) {
                if (verificarBissexto(anoAtual, bissexto)) {
                    if (diaAtual <= DIAS_FEV_BISSEXTO) {
                        valido = true;
                    }
                } else if (diaAtual <= DIAS_FEV) {
                    valido = true;
                }
            } else { //Meses com 30 dias
                if (diaAtual <= DIAS_MES30) {
                    valido = true;
                }
            }
        }
        return valido;
    }

    /**
     * Verifica se o ano informado é bissexto.
     *
     * @param ano Ano que deseja-se saber se é ou não bissexto
     * @param bissexto Ano que é conhecidamente bissexto
     * @return Verdadeito ou falso
     */
    private static boolean verificarBissexto(final int ano,
            final int bissexto) {
        if (ano == bissexto) {
            return true;
        } else {
            for (int dataTestada = ano; dataTestada < LIMITE_ANO_MAX;
                    dataTestada += INTERVALO_BISSEXTO) {
                if (dataTestada == bissexto) {
                    return true;
                }
            }
            for (int dataTestada = ano; dataTestada > LIMITE_ANO_MIN;
                    dataTestada -= INTERVALO_BISSEXTO) {
                if (dataTestada == bissexto) {
                    return true;
                }
            }
        }
        return false;
    }
}
