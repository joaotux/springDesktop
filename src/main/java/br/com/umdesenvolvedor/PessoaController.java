package br.com.umdesenvolvedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.umdesenvolvedor.model.Pessoa;
import br.com.umdesenvolvedor.service.PessoaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

@Component
public class PessoaController {
	
	@FXML
	private TextField txtCodigo;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtCpf;

	@FXML
	private TextField txtEmail;

	@Autowired
	private PessoaService pessoas;

	@FXML
	void salvar(ActionEvent event) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(txtNome.getText());
		pessoa.setCpf(txtCpf.getText());
		pessoa.setEmail(txtEmail.getText());

		pessoa = pessoas.salvar(pessoa);
		
		txtCodigo.setText(pessoa.getCodigo().toString());
	}

}
