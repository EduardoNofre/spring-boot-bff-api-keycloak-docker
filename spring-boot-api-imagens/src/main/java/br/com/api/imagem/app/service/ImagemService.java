package br.com.api.imagem.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.com.api.imagem.app.dto.ImagemDTO;
import br.com.api.imagem.app.dto.ImagemResponse;
import br.com.api.imagem.app.handle.HandleException;
import br.com.api.imagem.app.model.Imagem;
import br.com.api.imagem.app.repository.ImagemRepository;
import br.com.api.imagem.app.util.FileImagemUtil;
import jakarta.transaction.Transactional;

@Service
public class ImagemService {

	@Value("${repositorio.imagem.servidor}")
	private transient String servidorImagem;

	@Value("${repositorio.local.imagem}")
	private transient String repositorioImagem;

	@Autowired
	private ImagemRepository imagemRepository;

	@Autowired
	private ModelMapper modelMapper;

	public ImagemResponse ImagemDownload(String servidor, String repositorio, String imagem) throws HandleException {

		File file = new File(servidor.concat(repositorio));

		FileImagemUtil.validarPath(file);

		FileImagemUtil.validarArquivo(StringUtils.cleanPath(imagem));

		FileImagemUtil.arquivoExiste(servidor.concat(repositorio) + imagem);

		Path caminhoImagem = Paths.get(servidor.concat(repositorio) + imagem);

		try {

			return this.parseImagemResponse(servidor, repositorio, imagem, Files.readAllBytes(caminhoImagem),
					Files.probeContentType(caminhoImagem));

		} catch (IOException e) {
			throw new HandleException(" A IMAGEM NÃO PODE SER ENCONTRADA ", HttpStatus.NO_CONTENT);
		}
	}

	public ImagemDTO ImagemUpload(MultipartFile imagem) throws HandleException {

		File file = new File(servidorImagem.concat(repositorioImagem));

		FileImagemUtil.validarPath(file);

		FileImagemUtil.validarArquivo(StringUtils.cleanPath(imagem.getOriginalFilename()));

		Path caminhoImagem = Paths
				.get(servidorImagem.concat(repositorioImagem) + StringUtils.cleanPath(imagem.getOriginalFilename()));

		try {
			Files.write(caminhoImagem, imagem.getBytes());
		} catch (IOException e) {
			throw new HandleException(" NÂO FOI POSSIVEL SALVAR A IMAGEM ", HttpStatus.CONFLICT);
		}

		return modelMapper.map(
				imagemRepository.save(this.parseImagemEntity(StringUtils.cleanPath(imagem.getOriginalFilename()))),
				new TypeToken<ImagemDTO>() {
				}.getType());

	}

	@Transactional(rollbackOn = Exception.class)
	public void deletarImagem(Integer idNoticia) throws HandleException {
		
		 Optional<Imagem> entity = imagemRepository.findByNoticiaId(idNoticia);
		 
		 if(entity.isEmpty()) {
			 
			 throw new HandleException(" IMAGEM DA NOTICIA NÃO ENCONTRADO ", HttpStatus.CONFLICT);
		 }
				
		File file = new File(entity.get().getServidor().concat(entity.get().getRepositorio()));

		FileImagemUtil.validarPath(file);

		FileImagemUtil.validarArquivo(StringUtils.cleanPath(entity.get().getImagem()));

		FileImagemUtil.arquivoExiste(entity.get().getServidor().concat(entity.get().getRepositorio()) + entity.get().getImagem());
		
		FileImagemUtil.arquivoExcluir(entity.get().getServidor().concat(entity.get().getRepositorio()) + entity.get().getImagem());

		imagemRepository.deleteById(entity.get().getId());		
	}

	private Imagem parseImagemEntity(String nameImagem) {

		Imagem entity = new Imagem();
		entity.setImagem(nameImagem);
		entity.setNoticiaId(1);
		entity.setRepositorio(repositorioImagem);
		entity.setServidor(servidorImagem);
		entity.setCriadoEm(LocalDateTime.now());

		return entity;

	}

	private ImagemResponse parseImagemResponse(String servidor, String repositorio, String imagem, byte[] imagemByte,
			String contentType) {

		ImagemResponse respImg = new ImagemResponse();
		respImg.setImagem(imagem);
		respImg.setRepositorio(repositorio);
		respImg.setServidor(servidor);
		respImg.setImagemByte(imagemByte);
		respImg.setContentType(contentType);

		return respImg;

	}
}
