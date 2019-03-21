package dados;

import java.util.ArrayList;
import java.util.Random;

public class Dados {
    private ArrayList<String> nomes;
    private ArrayList<String> emails;
    private ArrayList<String> senhas;
    private ArrayList<String> telefones;
    private Random random;

    public Dados(){
        this.nomes = new ArrayList<>();
        this.emails = new ArrayList<>();
        this.senhas = new ArrayList<>();
        this.telefones = new ArrayList<>();
        this.random = new Random();
        this.setNomes();
        this.setEmails();
        this.setSenhas();
        this.setTelefones();
    }
    public String getNomes() {
        return nomes.get(random.nextInt(10));
    }

    public void setNomes() {
        this.nomes.add("Ana Maria Amaral");
        this.nomes.add("Barbara Silva");
        this.nomes.add("Carolina Faria");
        this.nomes.add("Daenerys Targaryen");
        this.nomes.add("Elisa Melo");
        this.nomes.add("Fabiana Santos");
        this.nomes.add("Gabriela Teixeira");
        this.nomes.add("Helen Ferreira");
        this.nomes.add("Isabela Parreiras");
        this.nomes.add("Janaina Oliveira");
    }

    public String getEmails() {
        return emails.get(random.nextInt(10));
    }

    public void setEmails() {
        this.emails.add("anamariaamaral@gmail.com");
        this.emails.add("barbarasilva@gmail.com");
        this.emails.add("carolinafaria@gmail.com");
        this.emails.add("daernerystargaryen@gmail.com");
        this.emails.add("elisamelo@gmail.com");
        this.emails.add("fabianasantos@gmail.com");
        this.emails.add("gabrielateixeira@gmail.com");
        this.emails.add("helenferreira@gmail.com");
        this.emails.add("isabelapereira@gmail.com");
        this.emails.add("janainaoliveira@gmail.com");
    }

    public String getSenhas() {
        return senhas.get(random.nextInt(10));
    }

    public void setSenhas() {
        this.senhas.add("123456");
        this.senhas.add("147852");
        this.senhas.add("123963");
        this.senhas.add("369963");
        this.senhas.add("258852");
        this.senhas.add("951753");
        this.senhas.add("789456");
        this.senhas.add("369853");
        this.senhas.add("587496");
        this.senhas.add("259653");
    }

    public String getTelefones() {
        return telefones.get(random.nextInt(10));
    }

    public void setTelefones() {
        this.telefones.add("(37) 99999-9999");
        this.telefones.add("(37) 99999-9147");
        this.telefones.add("(37) 99999-9852");
        this.telefones.add("(37) 99999-9896");
        this.telefones.add("(37) 99999-9745");
        this.telefones.add("(37) 99999-9365");
        this.telefones.add("(37) 99999-9365");
        this.telefones.add("(37) 99999-9475");
        this.telefones.add("(37) 99999-9533");
        this.telefones.add("(37) 99999-9745");
    }
}
