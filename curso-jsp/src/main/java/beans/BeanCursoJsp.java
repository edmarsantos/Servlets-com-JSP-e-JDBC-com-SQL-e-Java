package beans;

public class BeanCursoJsp {
	
	
	private String login;
	private String senha;
	private long id;
	private String nome;
	/*
	 * public boolean validarLoginSenha(String login , String senha) {
	 * if(login.equalsIgnoreCase("edmar") && senha.equalsIgnoreCase("2606")) {
	 * return true; }else { return false; } }
	 */
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAno() {
		return ano;
	}


	
	
	private String ano;
	private String sexo;
	
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int calcula(int numero ) {
		return numero  * 100;
	}

}
