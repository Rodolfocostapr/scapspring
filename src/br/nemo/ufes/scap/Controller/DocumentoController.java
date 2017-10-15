package br.nemo.ufes.scap.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.nemo.ufes.scap.Application.AplDocumento;
import br.nemo.ufes.scap.Domain.Afastamento;
import br.nemo.ufes.scap.Domain.Documento;

@Controller
public class DocumentoController {

	@Autowired
	private AplDocumento aplDocumento;

	@RequestMapping(value = "/documento/form", method = RequestMethod.GET)
	public String formulario() {
		return "documento/formulario";
	}

	@RequestMapping(value = "/documento/salva", method = RequestMethod.POST)
	public String salva(Documento documento, @RequestParam("tituloDocumento") String name,
			@RequestParam("file") MultipartFile file, HttpSession session) throws IOException, ParseException {

		Afastamento afastamento = new Afastamento();
		afastamento = (Afastamento) session.getAttribute("afastamento");
		Calendar cal = Calendar.getInstance();

		documento.setData_juntada(cal);
		documento.setAfastamento(afastamento);
		documento.setTituloDocumento(name);
		documento.setNomeArquivo(file.getOriginalFilename());

		if (!file.isEmpty()) {
			byte[] bytes = file.getBytes();
			documento.setContent(bytes);
		}

		aplDocumento.salvar(documento);
		return "index/index";

	}

	public void download() {

	}

	@RequestMapping(value = "/documento/download", method = RequestMethod.POST)
	/*
	 * public void downloadArquivo(@RequestParam("id_documento") String
	 * id,HttpServletResponse response) { try { // get your file as InputStream
	 * Documento documento = aplDocumento.buscaId(id); InputStream is = new
	 * ByteArrayInputStream(documento.getContent()); // copy it to response's
	 * OutputStream org.apache.commons.io.IOUtils.copy(is,
	 * response.getOutputStream()); response.flushBuffer(); } catch (IOException
	 * ex) { throw new
	 * RuntimeException("IOError writing file to output stream"); } }
	 */
	/*
	 * public InputStreamDownload downloadArquivo(String id_documento){
	 * Documento documento = aplDocumento.buscaId(id_documento);
	 * if(documento!=null){ result.include("teste"," não nulo"); String
	 * contentType = "doc/pdf"; InputStream aux = new
	 * ByteArrayInputStream(documento.getContent()); InputStreamDownload stream
	 * = new InputStreamDownload(aux,contentType,documento.getNomeArquivo());
	 * return stream; }else{
	 * 
	 * return null; } }
	 */

	public void lista() {
	}

}
