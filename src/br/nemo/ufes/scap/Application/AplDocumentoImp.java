package br.nemo.ufes.scap.Application;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.nemo.ufes.scap.Domain.Documento;
import br.nemo.ufes.scap.Persistency.DocumentoDAO;

@Service
public class AplDocumentoImp implements AplDocumento {

	@Autowired
	private DocumentoDAO documentoDAO;

	@Transactional
	@Override
	public void salvar(Documento documento) {
		documentoDAO.salvar(documento);

	}

	@Transactional
	@Override
	public Documento buscaId(String id_documento) {
		Documento documento = documentoDAO.buscaId(id_documento);
		return documento;
	}

	@Transactional
	@Override
	public List<Documento> buscaPorAfastamento(String id_afastamento) {
		return documentoDAO.buscaPorAfastamento(id_afastamento);
	}

}