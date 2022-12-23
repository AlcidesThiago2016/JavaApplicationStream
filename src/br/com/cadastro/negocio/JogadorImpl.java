package br.com.cadastro.negocio;

import br.com.cadastro.model.Jogador;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
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
            jogador.setName(info[1]);
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

    
 }
