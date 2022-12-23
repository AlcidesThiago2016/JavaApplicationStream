package br.com.cadastro.negocio;

import br.com.cadastro.model.Jogador;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JogadorImpl {

    public boolean verificaArquivoExiste(Path caminho){
        boolean ret = false;
        try {
            Stream<Path> stream = Files.list(caminho);
            Optional<Path> arq = stream.filter(p -> p.toString().endsWith("jogadores.txt")).findAny();
            ret = arq.isPresent();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return ret;
    }

    public List<Jogador> getListaDeJogadores(Path caminho) throws IOException{
        Stream<String> linhas = Files.lines(caminho, StandardCharsets.ISO_8859_1);
        List<String> listaDeLinhas = linhas.collect(Collectors.toList());
        List<Jogador> listaDeJogador = new ArrayList<>();
        Jogador jogador;
        Iterator it = listaDeLinhas.listIterator();
        String str = null;
        while (it.hasNext()){
            str = (String) it.next();
            String info[] = str.split(",");
            jogador = new Jogador();
            jogador.setName(info[0]);
            jogador.setPosition(info[1]);
            jogador.setAge(Integer.parseInt(info[2]));
            jogador.setCurrentTeam(info[3]);
            jogador.setGoalsScored(Integer.parseInt(info[4]));
            listaDeJogador.add(jogador);
        }
        return listaDeJogador;
    }

    public void imprimiJogadores(List<Jogador> jogadores){
        jogadores.stream().forEach(System.out::println);
    }

    public void imprimirJogadoresTime(List<Jogador> jogadores, String time){
        jogadores.stream().filter(jogador -> jogador.getCurrentTeam().equals(time)).forEach(System.out::println);
    }

    public void imprimirJogadoresTimeGol(List<Jogador> jogadores, String time){
        jogadores.stream().filter(jogador -> jogador.getCurrentTeam().equals(time) && jogador.getGoalsScored() > 10)
                .forEach(System.out::println);
    }

    public void agruparJogadoresPorTime(List<Jogador> jogadores){
        jogadores.stream().sorted(Comparator.comparing(Jogador::getCurrentTeam)).forEach(System.out::println);
    }

    public double calcularMediaIdade(List<Jogador> jogadores){
        return jogadores.stream().mapToInt(Jogador::getAge).average().getAsDouble();
    }

    public void imprimirJogadorMaisVelho(List<Jogador> jogadores){
        Jogador jogador = jogadores.stream().max(Comparator.comparingInt(Jogador::getAge)).get();
        System.out.println("Jogador mais velho: " + jogador.getName());
    }

    public void imprimirJogadorMaisNovo(List<Jogador> jogadores){
        Jogador jogador = jogadores.stream().min(Comparator.comparingInt(Jogador::getAge)).get();
        System.out.println("Jogador mais novo: " + jogador.getName());
    }

    public void imprimirJogadorArtilheiro(List<Jogador> jogadores){
        Jogador jogador = jogadores.stream().max(Comparator.comparingInt(Jogador::getGoalsScored)).get();
        System.out.println("Jogador mais novo: " + jogador.getName());
    }

    public int imprimirSomatoriaGols(List<Jogador> jogadores){
        int soma = jogadores.stream().mapToInt(jogador -> jogador.getGoalsScored()).sum();
        return soma;
    }

    public void agrupaJogadoresPeloTime(List<Jogador> jogadores){
        Map<String, List<Jogador>> groupByTime = jogadores.stream().collect(
                Collectors.groupingBy(Jogador::getCurrentTeam));
        System.out.println(groupByTime);
    }

    public void ordenarJogadoresGols(List<Jogador> jogadores){
        jogadores.stream().sorted(Comparator.comparingInt(Jogador::getGoalsScored)
                .reversed()).forEach(System.out::println);
    }
 }
