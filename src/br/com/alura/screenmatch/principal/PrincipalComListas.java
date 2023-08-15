package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme matrix = new Filme("The Matrix", 1999);
        Serie lost = new Serie("Lost", 2000);
        Filme avatar = new Filme("Avatar 2", 2023);
        Filme dogville = new Filme("Dogville", 2003);

        ArrayList<Titulo> listaDeAssistidos = new ArrayList<>();
        listaDeAssistidos.add(matrix);
        listaDeAssistidos.add(avatar);
        listaDeAssistidos.add(dogville);
        listaDeAssistidos.add(lost);

        for (Titulo item: listaDeAssistidos) {
            System.out.println(item);
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação: " + dogville.getClassificacao());
            }
        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("addam sandler");
        buscaPorArtista.add("paulo");
        buscaPorArtista.add("jacqueline");

        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);

        Collections.sort(listaDeAssistidos);
        System.out.println(listaDeAssistidos);

        listaDeAssistidos.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("ordenando por ano " + listaDeAssistidos);
    }
}
