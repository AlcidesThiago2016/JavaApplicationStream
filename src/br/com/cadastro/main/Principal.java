package br.com.cadastro.main;

import br.com.cadastro.model.Jogador;
import br.com.cadastro.negocio.JogadorImpl;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Principal p = new Principal();
        JogadorImpl jogador = new JogadorImpl();
        String endDir = "E:\\Cursos Programação\\Curso Nelio\\JavaApplicationStream";
        String nomeArq = "jogadores.txt";
        List<Jogador> jogadorList = null;
        try {
            jogadorList = jogador.getListaDeJogadores(Paths.get(endDir + "\\" + nomeArq));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (!jogador.verificaArquivoExiste(Paths.get(endDir))){
            System.out.println("Arquivo não encontrado!");
        }else {
            jogador.imprimirJogadorArtilheiro(jogadorList);
            jogador.imprimirJogadorMaisVelho(jogadorList);
            jogador.imprimirJogadorMaisNovo(jogadorList);

        }
    }
}
