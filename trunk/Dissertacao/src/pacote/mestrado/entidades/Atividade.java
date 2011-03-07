package pacote.mestrado.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Atividade implements Serializable {
	private static final long serialVersionUID = 8586977373449624267L;

	private Integer id;
	private String nome;
	private String tipo;
	private ArrayList<Integer> atividadesPredecessoras; // ids das atividades
														// que precedem a
														// atividade
	private Date dataInicial;
	private Date dataEntrega;
	private Double orcamento;
	private ArrayList<Habilidade> requisitosHabilidades;
	private Double duracao;
	private int estado; // -1: bloqueada, 0 - disponivel, outro numero: alocada
						// (numero corresponde ao id do membro)

	public Atividade() {
		atividadesPredecessoras = new ArrayList<Integer>();
		requisitosHabilidades = new ArrayList<Habilidade>();
		if (dataInicial != null && dataEntrega != null) {
			calculaDuracao();
		}
	}

	void calculaDuracao() {
		this.setDuracao(0.0); // calcular duracao
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ArrayList<Integer> getAtividadesPredecessoras() {
		return atividadesPredecessoras;
	}

	public void setAtividadesPredecessoras(
			ArrayList<Integer> atividadesPredecessoras) {
		this.atividadesPredecessoras = atividadesPredecessoras;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Double orcamento) {
		this.orcamento = orcamento;
	}

	public ArrayList<Habilidade> getRequisitosHabilidades() {
		return requisitosHabilidades;
	}

	public void setRequisitosHabilidades(
			ArrayList<Habilidade> requisitosHabilidades) {
		this.requisitosHabilidades = requisitosHabilidades;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String toString() {
		
		StringBuilder str = new StringBuilder();
		
		str.append("--------------Atividade------------"+"\n");
		str.append("ID: " + this.id+"\n");
		str.append("Nome: " + this.nome+"\n");
		str.append("Tipo: " + this.tipo+"\n");
		str.append("Data de in�cio: " + this.dataInicial+"\n");
		str.append("Data de entrega: " + this.dataEntrega+"\n");
		str.append("Or�amento: " + this.orcamento+"\n");
		str.append("Estado: " + this.estado+"\n");
		// imprime atividades predecessoras
		if (!atividadesPredecessoras.isEmpty()) {
			str.append("-Atividades Predecessoras-"+"\n");
			for (int idAtiv : atividadesPredecessoras) {
				str.append(idAtiv+"\n");
			}
			str.append("--------------------------"+"\n");
		} else {
			str.append("Nao h� atividades predecessoras."+"\n");
		}
		// imprime habilidades
		if (!requisitosHabilidades.isEmpty()) {
			str.append("-Requisitos da Atividade-"+"\n");
			for (Habilidade req : requisitosHabilidades) {
				str.append(req.toString());
			}
			str.append("-------------------------");
		} else {
			str.append("Esta atividade nao possui requisitos."+"\n");
		}
		return str.toString();
	}

	public void setDuracao(Double duracao) {
		this.duracao = duracao;
	}

	public double getDuracao() {
		return duracao;
	}

}
