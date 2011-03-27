package pacote.mestrado;

import jade.core.Agent;

import java.util.Collection;

import pacote.mestrado.behaviors.BuscaTarefaBehaviour;
import pacote.mestrado.dao.HabilidadeDAO;
import pacote.mestrado.dao.MembroDAO;
import pacote.mestrado.entidades.Agenda;
import pacote.mestrado.entidades.Atividade;
import pacote.mestrado.entidades.Habilidade;

/**
 * Classe que corresponde ao agente membro de um projeto
 * 
 * @author Liane Cafarate
 */
public class Membro extends Agent {
    private static final long serialVersionUID = -4300677614968664782L;

    private int id;
    private String nome;
    private double salario; // homem/hora
    private Collection<Habilidade> habilidades; // habilidades que a pessoa
						// possui
    private Agenda agenda; // tempo disponivel da pessoa
    private Atividade atividadeEscolhida;
    private Collection<Atividade> atividadesInvalidas; // atividades que o
						       // agente quis, mas por
						       // algum motivo nao pode
						       // ter e devem ser
						       // descartadas

    /**
     * Metodo de inicializacao de agentes
     */
    protected void setup() {
	System.out.println("Agente " + getAID().getLocalName() + " vivo! :)");
	inicializaMembro();
	addBehaviour(new BuscaTarefaBehaviour(this));
    }
    
    public Atividade getAtividadeEscolhida() {
        return atividadeEscolhida;
    }

    public void setAtividadeEscolhida(Atividade atividadeEscolhida) {
        this.atividadeEscolhida = atividadeEscolhida;
    }

    public Collection<Atividade> getAtividadesInvalidas() {
        return atividadesInvalidas;
    }

    public void setAtividadesInvalidas(Collection<Atividade> atividadesInvalidas) {
        this.atividadesInvalidas = atividadesInvalidas;
    }

    /**
     * Metodo de finalizacao de agentes
     */
    protected void takeDown() {
	System.out.println("Agente " + getAID().getLocalName() + " est� morto.");
    }

    /**
     * Inicializa o agente com os dados cadastrados no banco de dados.
     */
    private void inicializaMembro() {
	MembroDAO daoMemb = new MembroDAO();
	Membro temp = daoMemb.get(getLocalName());
	// Inicializa dados do agente
	this.id = temp.getId();
	this.nome = temp.getNome();
	this.salario = temp.getSalario();
	// Inicializa habilidades
	HabilidadeDAO daoHab = new HabilidadeDAO();
	habilidades = daoHab.getHabilidades(this.id, "Membro");
	/*
	 * System.out.println(toString()); for (Habilidade habilidade :
	 * habilidades) { System.out.println(habilidade.toString()); }
	 */
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public Collection<Habilidade> getHabilidades() {
	return habilidades;
    }

    public void setHabilidades(Collection<Habilidade> habilidades) {
	this.habilidades = habilidades;
    }

    public double getSalario() {
	return salario;
    }

    public void setSalario(double salario) {
	this.salario = salario;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("--Agente--" + "\n");
	str.append("ID: " + this.id + "\n");
	str.append("Nome: " + this.nome + "\n");
	str.append("Salario: " + this.salario + "\n");
	return str.toString();
    }

}
