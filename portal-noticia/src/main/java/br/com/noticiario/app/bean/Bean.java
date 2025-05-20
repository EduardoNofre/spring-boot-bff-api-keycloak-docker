package br.com.noticiario.app.bean;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@ViewScoped
public class Bean implements Serializable {

    public static class Item {
        private int id;
        private String nome;

        public Item(int id, String nome) {
            this.id = id;
            this.nome = nome;
        }

        public int getId() { return id; }
        public String getNome() { return nome; }
    }

    public List<Item> getItens() {
        return Arrays.asList(
            new Item(1, "Produto A"),
            new Item(2, "Produto B"),
            new Item(3, "Produto C")
        );
    }
}
